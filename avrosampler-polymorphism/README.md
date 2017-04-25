# No Support for Inheritance and Polymorphy

Apache Avro does not support any kind of inheritance or polymorphy for that matter. However, there are ways to work around that, although they are a bit cumbersome as they require the developer to implement a lot of boilerplate code.

Consider an *Event-sourced* application in which state mutations are presented as events - immutable facts - that are serialized to binary using Apache Avro before they are written to an event store.

An event is comprised of a generic part, which covers things like event identity and a creation timestamp, and a specific part, which covers the functional aspects of that event (association to an aggregate, the modified state, ...). Using Apache Avro, we could represent the generic part like so:

```json
{
  "namespace": "net.mguenther.avrosampler.json.gtd",
  "type": "record",
  "name": "Event",
  "fields": [
    {"name": "eventId", "type": "string"},
    {"name": "timestamp", "type": "long"},
    {"name": "specificEventData", "type": [
      ???
    ]}
  ]
}
```


We will fill in the `???` in just a second. The specific data is represented using `record`s as well, like so:

```json
{
  "name": "ItemCreated",
  "type": "record",
  "fields": [
    {"name": "itemId", "type": "string"},
    {"name": "description", "type": "string"},
    {"name": "creator", "type": "string"}
  ]
}
```

and

```json
{
  "name": "ItemConcluded",
  "type": "record",
  "fields": [
    {"name": "itemId", "type": "string"}
  ]
}
```

As we can see, the specific data of both events differ. Using such `record`s as part of the generic event is easy. The following listing shows the complete example with one specific event (others are omitted for brevity).

```json
{
  "namespace": "net.mguenther.avrosampler.json.gtd",
  "type": "record",
  "name": "Event",
  "fields": [
    {"name": "eventId", "type": "string"},
    {"name": "timestamp", "type": "long"},
    {"name": "specificEventData", "type": [
      {
        "name": "ItemCreated",
        "type": "record",
        "fields": [
          {"name": "itemId", "type": "string"},
          {"name": "description", "type": "string"},
          {"name": "creator", "type": "string"}
        ]
      },
      {
        "name": "ItemConcluded",
        "type": "record",
        "fields": [
          {"name": "itemId", "type": "string"}
        ]
      }
    ]}
  ]
}
```

If we compile this protocol into Java classes, we notice that the types for the specific parts of an event are not respected, since `specificEventData` uses the static type `Object`.

We have to enforce type-compliance on the application level ourselves. This can be done using a mapping class that mediates between Avro-based events that are used *transfer objects* and polymorphic events on application level.

Treating Avro-based events as transfer objects is indeed a good thing: Avro itself provides no means for functional validation, so we'd have to implement any kind of validation on the application level anyways to ensure that only valid events are written to the event store. The downside of the approach is that we have to mirror the event hierarchy.

The application-level events are listed underneath.

```java
@lombok.RequiredArgsConstructor
@lombok.Getter
public class Event {
  private final String id;
  private final long created;
}
```

```java
@lombok.Getter
public class ItemCreated extends Event {
  private final String itemId;
  private final String description;
  private final String creator;
  
  public ItemCreated(final String eventId,
                     final long created,
                     final String itemId,
                     final String description,
                     final String creator) {
    super(eventId, created);
    this.itemId = itemId;
    this.description = description;
    this.creator = creator;
  }
}
```

```java
@lombok.Getter
public class ItemConcluded extends Event {
  private final String itemId;
  
  public ItemConcluded(final String eventId,
                       final long created,
                       final String itemId) {
    super(eventId, created);
    this.itemId = itemId;
  }
}
```

The mapping class for Avro- and application-level event representations is simple:

```java
class EventConverter {
  
  public net.mguenther.avrosampler.json.gtd.Event from(final ItemCreated event) {
  
    final net.mguenther.avrosampler.json.gtd.ItemCreated data = 
      net.mguenther.avrosampler.json.gtd.ItemCreated
      .newBuilder()
      .setItemId(event.getItemId())
      .setDescription(event.getDescription())
      .setCreator(event.getCreator())
      .build();
    return toTransportObject(event, data);
  }
  
  public net.mguenther.avrosampler.json.gtd.Event from(final RequiredTimeAssigned event) {
  
    final net.mguenther.avrosampler.json.gtd.RequiredTimeAssigned data = 
      net.mguenther.avrosampler.json.gtd.RequiredTimeAssigned
      .newBuilder()
      .setItemId(event.getItemId())
      .setRequiredTime(event.getRequiredTime())
      .build();
    return toTransportObject(event, data);
  }
  
  private net.mguenther.avrosampler.json.gtd.Event toTransportObject(final Event event, final Object data) {
    final net.mguenther.avrosampler.json.gtd.Event transferObject = new net.mguenther.avrosampler.json.gtd.Event();
    transferObject.setEventId(event.getId());
    transferObject.setEventType(event.getType());
    transferObject.setTimestamp(event.getCreated());
    transferObject.setData(data);
    return transferObject;
  }
        
  public Event to(final net.mguenther.avrosampler.json.gtd.Event event) {

    final String eventId = String.valueOf(event.getEventId());
    final String eventType = String.valueOf(event.getEventType());
    final long created = event.getTimestamp();

    Event functionalEvent;
    if (event.getData() instanceof net.mguenther.avrosampler.json.gtd.ItemCreated) {
      final net.mguenther.avrosampler.json.gtd.ItemCreated payload = (net.mguenther.avrosampler.json.gtd.ItemCreated) event.getData();
      functionalEvent = new ItemCreated(eventId, eventType, created, String.valueOf(payload.getItemId()), String.valueOf(payload.getDescription()), String.valueOf(payload.getCreator()));
    } else if(event.getData() instanceof net.mguenther.avrosampler.json.gtd.ItemConcluded) {
      final net.mguenther.avrosampler.json.gtd.ItemConcluded payload = (net.mguenther.avrosampler.json.gtd.ItemConcluded) event.getData();
      functionalEvent = new ItemConcluded(eventId, eventType, created, String.valueOf(payload.getItemId()));
    } else {
      throw new IllegalStateException("Unsupported event payload for event with ID " + eventId);
    }
    return functionalEvent;
  }
}
```

This mapping class sits right between our business logic and the serialization subsystem. Having to write all this boilerplate code is indeed a bit sad. But again, we should treat Avro records as transfer objects anyways and implement any business logic entirely on a higher level, where we are able to validate the data created before it gets serialized. This validation logic can be part of a functional event or - in our Event-sourced example - part of an accompanying command that emits the corresponding event if it is valid.

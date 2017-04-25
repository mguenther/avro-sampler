package net.mguenther.avrosampler;

/**
 * @author Markus Guenther (markus.guenther@gmail.com)
 */
public class EventConverter {

    public net.mguenther.avrosampler.json.gtd.Event from(final ItemCreated event) {

        final net.mguenther.avrosampler.json.gtd.ItemCreated data = net.mguenther.avrosampler.json.gtd.ItemCreated.newBuilder()
                .setItemId(event.getItemId())
                .setDescription(event.getDescription())
                .setCreator(event.getCreator())
                .build();
        return toTransportObject(event, data);
    }

    public net.mguenther.avrosampler.json.gtd.Event from(final RequiredTimeAssigned event) {

        final net.mguenther.avrosampler.json.gtd.RequiredTimeAssigned data = net.mguenther.avrosampler.json.gtd.RequiredTimeAssigned.newBuilder()
                .setItemId(event.getItemId())
                .setRequiredTime(event.getRequiredTime())
                .build();
        return toTransportObject(event, data);
    }

    public net.mguenther.avrosampler.json.gtd.Event from(final DueDateAssigned event) {

        final net.mguenther.avrosampler.json.gtd.DueDateAssigned data = net.mguenther.avrosampler.json.gtd.DueDateAssigned.newBuilder()
                .setDueDate(event.getDueDate())
                .setItemId(event.getItemId())
                .build();
        return toTransportObject(event, data);
    }

    public net.mguenther.avrosampler.json.gtd.Event from(final RequiredEnergyAssigned event) {

        final net.mguenther.avrosampler.json.gtd.RequiredEnergyAssigned data = net.mguenther.avrosampler.json.gtd.RequiredEnergyAssigned.newBuilder()
                .setItemId(event.getItemId())
                .setRequiredEnergy(event.getRequiredEnergy())
                .build();
        return toTransportObject(event, data);
    }

    public net.mguenther.avrosampler.json.gtd.Event from(final TagAssigned event) {

        final net.mguenther.avrosampler.json.gtd.TagAssigned data = net.mguenther.avrosampler.json.gtd.TagAssigned.newBuilder()
                .setItemId(event.getItemId())
                .setTag(event.getTag())
                .build();
        return toTransportObject(event, data);
    }

    public net.mguenther.avrosampler.json.gtd.Event from(final TagRemoved event) {

        final net.mguenther.avrosampler.json.gtd.TagRemoved data = net.mguenther.avrosampler.json.gtd.TagRemoved.newBuilder()
                .setItemId(event.getItemId())
                .setTag(event.getTag())
                .build();
        return toTransportObject(event, data);
    }

    public net.mguenther.avrosampler.json.gtd.Event from(final ItemMovedToList event) {

        final net.mguenther.avrosampler.json.gtd.ItemMovedToList data = net.mguenther.avrosampler.json.gtd.ItemMovedToList.newBuilder()
                .setItemId(event.getItemId())
                .setList(event.getList())
                .build();
        return toTransportObject(event, data);
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
        } else if (event.getData() instanceof net.mguenther.avrosampler.json.gtd.RequiredTimeAssigned) {
            final net.mguenther.avrosampler.json.gtd.RequiredTimeAssigned payload = (net.mguenther.avrosampler.json.gtd.RequiredTimeAssigned) event.getData();
            functionalEvent = new RequiredTimeAssigned(eventId, eventType, created, String.valueOf(payload.getItemId()), payload.getRequiredTime());
        } else if (event.getData() instanceof net.mguenther.avrosampler.json.gtd.RequiredEnergyAssigned) {
            final net.mguenther.avrosampler.json.gtd.RequiredEnergyAssigned payload = (net.mguenther.avrosampler.json.gtd.RequiredEnergyAssigned) event.getData();
            functionalEvent = new RequiredEnergyAssigned(eventId, eventType, created, String.valueOf(payload.getItemId()), payload.getRequiredEnergy());
        } else if (event.getData() instanceof net.mguenther.avrosampler.json.gtd.DueDateAssigned) {
            final net.mguenther.avrosampler.json.gtd.DueDateAssigned payload = (net.mguenther.avrosampler.json.gtd.DueDateAssigned) event.getData();
            functionalEvent = new DueDateAssigned(eventId, eventType, created, String.valueOf(payload.getItemId()), payload.getDueDate());
        } else if (event.getData() instanceof net.mguenther.avrosampler.json.gtd.TagAssigned) {
            final net.mguenther.avrosampler.json.gtd.TagAssigned payload = (net.mguenther.avrosampler.json.gtd.TagAssigned) event.getData();
            functionalEvent = new TagAssigned(eventId, eventType, created, String.valueOf(payload.getItemId()), String.valueOf(payload.getTag()));
        } else if (event.getData() instanceof net.mguenther.avrosampler.json.gtd.TagRemoved) {
            final net.mguenther.avrosampler.json.gtd.TagRemoved payload = (net.mguenther.avrosampler.json.gtd.TagRemoved) event.getData();
            functionalEvent = new TagRemoved(eventId, eventType, created, String.valueOf(payload.getItemId()), String.valueOf(payload.getTag()));
        } else if (event.getData() instanceof net.mguenther.avrosampler.json.gtd.ItemMovedToList) {
            final net.mguenther.avrosampler.json.gtd.ItemMovedToList payload = (net.mguenther.avrosampler.json.gtd.ItemMovedToList) event.getData();
            functionalEvent = new ItemMovedToList(eventId, eventType, created, String.valueOf(payload.getItemId()), String.valueOf(payload.getList()));
        } else {
            throw new IllegalStateException("Unsupported event payload for event with ID " + eventId);
        }

        return functionalEvent;
    }

    private net.mguenther.avrosampler.json.gtd.Event toTransportObject(final Event event, final Object data) {

        final net.mguenther.avrosampler.json.gtd.Event transferObject = new net.mguenther.avrosampler.json.gtd.Event();
        transferObject.setEventId(event.getId());
        transferObject.setEventType(event.getType());
        transferObject.setTimestamp(event.getCreated());
        transferObject.setData(data);
        return transferObject;
    }
}

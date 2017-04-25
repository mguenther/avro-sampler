package net.mguenther.avrosampler;

import lombok.Getter;

/**
 * @author Markus Guenther (markus.guenther@gmail.com)
 */
@Getter
public class TagAssigned extends Event {

    private final String itemId;
    private final String tag;

    public TagAssigned(final String eventId, final String eventType, final long created,
                       final String itemId, final String tag) {
        super(eventId, eventType, created);
        this.itemId = itemId;
        this.tag = tag;
    }
}

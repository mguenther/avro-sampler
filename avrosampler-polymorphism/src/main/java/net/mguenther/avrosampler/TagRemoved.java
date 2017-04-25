package net.mguenther.avrosampler;

import lombok.Getter;

/**
 * @author Markus Guenther (markus.guenther@gmail.com)
 */
@Getter
public class TagRemoved extends Event {

    private final String itemId;
    private final String tag;

    public TagRemoved(final String eventId, final String eventType, final long created,
                      final String itemId, final String tag) {
        super(eventId, eventType, created);
        this.itemId = itemId;
        this.tag = tag;
    }
}

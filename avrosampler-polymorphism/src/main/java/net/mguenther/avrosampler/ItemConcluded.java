package net.mguenther.avrosampler;

import lombok.Getter;

/**
 * @author Markus Günther (markus.guenther@gmail.com)
 */
@Getter
public class ItemConcluded extends Event {

    private final String itemId;

    public ItemConcluded(final String eventId, final String eventType, final long created,
                         final String itemId) {
        super(eventId, eventType, created);
        this.itemId = itemId;
    }
}

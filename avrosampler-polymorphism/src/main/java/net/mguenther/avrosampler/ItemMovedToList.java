package net.mguenther.avrosampler;

import lombok.Getter;

/**
 * @author Markus Guenther (markus.guenther@gmail.com)
 */
@Getter
public class ItemMovedToList extends Event {

    private final String itemId;
    private final String list;

    public ItemMovedToList(final String eventId, final String eventType, final long created,
                           final String itemId, final String list) {
        super(eventId, eventType, created);
        this.itemId = itemId;
        this.list = list;
    }
}

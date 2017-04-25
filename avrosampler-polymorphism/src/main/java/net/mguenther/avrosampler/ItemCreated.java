package net.mguenther.avrosampler;

import lombok.Getter;

/**
 * @author Markus Günther (markus.guenther@gmail.com)
 */
@Getter
public class ItemCreated extends Event {

    public ItemCreated(final String eventId, final String eventType, final long created,
                       final String itemId, final String description, final String creator) {
        super(eventId, eventType, created);
        this.itemId = itemId;
        this.description = description;
        this.creator = creator;
    }

    private final String itemId;
    private final String description;
    private final String creator;
}

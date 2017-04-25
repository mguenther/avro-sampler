package net.mguenther.avrosampler;

import lombok.Getter;

/**
 * @author Markus Günther (markus.guenther@gmail.com)
 */
@Getter
public class DueDateAssigned extends Event {

    private final String itemId;
    private final long dueDate;

    public DueDateAssigned(final String eventId, final String eventType, final long created,
                           final String itemId, final long dueDate) {
        super(eventId, eventType, created);
        this.itemId = itemId;
        this.dueDate = dueDate;
    }
}

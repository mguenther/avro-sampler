package net.mguenther.avrosampler;

import lombok.Getter;

/**
 * @author Markus Günther (markus.guenther@gmail.com)
 */
@Getter
public class RequiredTimeAssigned extends Event {

    private final String itemId;
    private final long requiredTime;

    public RequiredTimeAssigned(final String eventId, final String eventType, final long created,
                                final String itemId, final long requiredTime) {
        super(eventId, eventType, created);
        this.itemId = itemId;
        this.requiredTime = requiredTime;
    }
}

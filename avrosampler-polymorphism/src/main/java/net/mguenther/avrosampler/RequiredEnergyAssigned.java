package net.mguenther.avrosampler;

import lombok.Getter;

/**
 * @author Markus Guenther (markus.guenther@gmail.com)
 */
@Getter
public class RequiredEnergyAssigned extends Event {

    private final String itemId;
    private final int requiredEnergy;

    public RequiredEnergyAssigned(final String eventId, final String eventType, final long created,
                                  final String itemId, final int requiredEnergy) {
        super(eventId, eventType, created);
        this.itemId = itemId;
        this.requiredEnergy = requiredEnergy;
    }
}

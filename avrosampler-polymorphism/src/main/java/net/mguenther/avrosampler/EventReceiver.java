package net.mguenther.avrosampler;

/**
 * @author Markus Guenther (markus.guenther@gmail.com)
 */
public interface EventReceiver {

    void accept(ItemCreated event);
    void accept(ItemConcluded event);
    void accept(RequiredTimeAssigned event);
    void accept(RequiredEnergyAssigned event);
    void accept(DueDateAssigned event);
    void accept(TagAssigned event);
    void accept(TagRemoved event);
    void accept(ItemMovedToList event);
}

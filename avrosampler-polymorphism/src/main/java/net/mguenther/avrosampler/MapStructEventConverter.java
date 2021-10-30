package net.mguenther.avrosampler;

import net.mguenther.avrosampler.json.gtd.Event;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @author Markus Günther (markus.guenther@gmail.com)
 */
@Mapper
public interface MapStructEventConverter {

    MapStructEventConverter INSTANCE = Mappers.getMapper(MapStructEventConverter.class);

    @Mappings(
            {
                    @Mapping(source = "event.itemId", target = "itemId"),
                    @Mapping(source = "", target = "")
            }
    )
    Event from(ItemCreated event);

    @Mappings(
            {
                    @Mapping(source = "event.itemId", target = "itemId"),
                    @Mapping(source = "", target = "")
            }
    )
    net.mguenther.avrosampler.json.gtd.ItemCreated fromDomain(ItemCreated event);
}

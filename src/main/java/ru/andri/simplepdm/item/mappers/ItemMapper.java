package ru.andri.simplepdm.item.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.andri.simplepdm.ebom.mappers.EbomLineMapper;
import ru.andri.simplepdm.item.dao.entities.Item;
import ru.andri.simplepdm.item.dto.ItemDto;
import ru.andri.simplepdm.item.dto.ItemEditDto;

@Mapper(componentModel = "spring", uses = {EbomLineMapper.class})
public interface ItemMapper {

    ItemDto entityToItemDto(Item item);

    @Mapping(target = "ebomRevisions", ignore = true)
    @Mapping(target = "id", source = "itemId")
    Item itemEditDtoToEntity(ItemEditDto itemEditDto, Long itemId);

}

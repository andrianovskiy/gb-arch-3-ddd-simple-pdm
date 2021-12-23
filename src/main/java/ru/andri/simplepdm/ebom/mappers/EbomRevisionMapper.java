package ru.andri.simplepdm.ebom.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.andri.simplepdm.ebom.dao.entities.EbomRevision;
import ru.andri.simplepdm.ebom.dto.EbomRevisionDto;
import ru.andri.simplepdm.ebom.dto.EbomRevisionEditDto;
import ru.andri.simplepdm.item.dao.entities.Item;

@Mapper(componentModel = "spring")
public interface EbomRevisionMapper {

    EbomRevisionDto entityToEbomRevisionDto(EbomRevision ebomRevision);

    @Mapping(source = "revisionId", target = "id")
    EbomRevision ebomRevisionEditDtoToEntity(EbomRevisionEditDto ebomRevisionEditDto, Long revisionId);

    @Mapping(source = "itemId", target = "item")
    EbomRevision ebomRevisionEditDtoWithItemToEntity(EbomRevisionEditDto ebomRevisionEditDto, Long itemId);

    default Item longToItem(Long value) {
        return value == null ? null : Item.builder()
                .id(value)
                .build();
    }

}

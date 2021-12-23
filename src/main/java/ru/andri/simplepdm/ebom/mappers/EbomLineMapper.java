package ru.andri.simplepdm.ebom.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.andri.simplepdm.ebom.dao.entities.EbomLine;
import ru.andri.simplepdm.ebom.dao.entities.EbomRevision;
import ru.andri.simplepdm.ebom.dto.EbomLineDto;
import ru.andri.simplepdm.ebom.dto.EbomLineEditDto;
import ru.andri.simplepdm.item.dao.entities.Item;

@Mapper(componentModel = "spring")
public interface EbomLineMapper {

    EbomLineDto entityToEbomLineDto(EbomLine ebomLine);

    @Mapping(source = "lineId", target = "id")
    EbomLine ebomLineEditDtoToEntity(EbomLineEditDto ebomLineEditDto, Long lineId);

    @Mapping(source = "revisionId", target = "ebomRevision")
    EbomLine ebomLineEditDtoWithRevisionToEntity(EbomLineEditDto ebomLineEditDto, Long revisionId);

    default EbomRevision longToRevision(Long value) {
        return value == null ? null : EbomRevision.builder()
                .id(value)
                .build();
    }

    default Item longToComponentItem(Long value) {
        return value == null ? null : Item.builder()
                .id(value)
                .build();
    }


}

package ru.andri.simplepdm.ebom.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.andri.simplepdm.ebom.dto.EbomRevisionDto;
import ru.andri.simplepdm.ebom.dto.EbomRevisionEditDto;

public interface EbomRevisionService {

    Page<EbomRevisionDto> findAllRevisions(Long itemId, Pageable pageable);

    EbomRevisionDto revisionById(Long revisionId);

    EbomRevisionDto createRevision(Long itemId, EbomRevisionEditDto ebomRevisionEditDto);

    EbomRevisionDto updateRevision(EbomRevisionEditDto ebomRevisionEditDto, Long revisionId);

    void deleteRevision(Long revisionId);

    void copyEbom(Long ebomRevisionId, Long toEbomRevisionId);

    void approveEbomRevision(Long ebomRevisionId);

}

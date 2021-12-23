package ru.andri.simplepdm.ebom.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.andri.simplepdm.ebom.dto.EbomLineDto;
import ru.andri.simplepdm.ebom.dto.EbomLineEditDto;

public interface EbomLineService {

    Page<EbomLineDto> findAllLines(Long revisionId, Pageable pageable);

    EbomLineDto lineById(Long bomLineId);

    EbomLineDto createLine(Long revisionId, EbomLineEditDto ebomLineEditDto);

    EbomLineDto updateLine(EbomLineEditDto ebomLineEditDto, Long bomLineId);

    void deleteLine(Long bomLineId);

}

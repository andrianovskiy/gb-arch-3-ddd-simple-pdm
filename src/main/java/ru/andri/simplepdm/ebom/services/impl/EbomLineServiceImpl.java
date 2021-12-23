package ru.andri.simplepdm.ebom.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.andri.simplepdm.ebom.dao.EbomLineRepository;
import ru.andri.simplepdm.ebom.dao.entities.EbomLine;
import ru.andri.simplepdm.ebom.dao.entities.EbomRevision;
import ru.andri.simplepdm.ebom.dto.EbomLineDto;
import ru.andri.simplepdm.ebom.dto.EbomLineEditDto;
import ru.andri.simplepdm.ebom.mappers.EbomLineMapper;
import ru.andri.simplepdm.ebom.services.EbomLineService;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class EbomLineServiceImpl implements EbomLineService {

    EbomLineRepository lineRepository;
    EbomLineMapper lineMapper;

    @Override
    public Page<EbomLineDto> findAllLines(Long revisionId, Pageable pageable) {
        return lineRepository.findByEbomRevision(lineMapper.longToRevision(revisionId), pageable)
                .map(lineMapper::entityToEbomLineDto);
    }

    @Override
    public EbomLineDto lineById(Long bomLineId) {
        return lineRepository.findById(bomLineId)
                .map(lineMapper::entityToEbomLineDto)
                .orElseThrow(() -> new NoSuchElementException("ebom.line.not.found.exception"));
    }

    @Override
    public EbomLineDto createLine(Long revisionId, EbomLineEditDto ebomLineEditDto) {
        EbomLine line = lineMapper.ebomLineEditDtoWithRevisionToEntity(ebomLineEditDto, revisionId);
        line = lineRepository.save(line);
        return lineMapper.entityToEbomLineDto(line);
    }

    @Override
    public EbomLineDto updateLine(EbomLineEditDto ebomLineEditDto, Long bomLineId) {
        EbomLine dbLine = lineRepository.findById(bomLineId)
                .orElseThrow(() -> new NoSuchElementException("ebom.line.not.found.exception"));
        EbomLine ebomLine = lineMapper.ebomLineEditDtoToEntity(ebomLineEditDto, bomLineId);
        ebomLine.setEbomRevision(dbLine.getEbomRevision());
        ebomLine = lineRepository.save(ebomLine);
        return lineMapper.entityToEbomLineDto(ebomLine);
    }

    @Override
    public void deleteLine(Long bomLineId) {
        lineRepository.deleteById(bomLineId);
    }
}

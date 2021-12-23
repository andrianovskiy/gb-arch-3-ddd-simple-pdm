package ru.andri.simplepdm.ebom.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.andri.simplepdm.ebom.dao.EbomRevisionRepository;
import ru.andri.simplepdm.ebom.dao.entities.EbomRevision;
import ru.andri.simplepdm.ebom.dto.EbomRevisionDto;
import ru.andri.simplepdm.ebom.dto.EbomRevisionEditDto;
import ru.andri.simplepdm.ebom.mappers.EbomRevisionMapper;
import ru.andri.simplepdm.ebom.services.EbomRevisionService;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class EbomRevisionServiceImpl implements EbomRevisionService {

    EbomRevisionRepository revisionRepository;
    EbomRevisionMapper revisionMapper;

    @Override
    public Page<EbomRevisionDto> findAllRevisions(Long itemId, Pageable pageable) {
        return revisionRepository.findByItem(revisionMapper.longToItem(itemId), pageable)
                .map(revisionMapper::entityToEbomRevisionDto);
    }

    @Override
    public EbomRevisionDto revisionById(Long revisionId) {
        return revisionRepository.findById(revisionId)
                .map(revisionMapper::entityToEbomRevisionDto)
                .orElseThrow(() -> new NoSuchElementException("ebom.revision.not.found.exception"));
    }

    @Override
    public EbomRevisionDto createRevision(Long itemId, EbomRevisionEditDto ebomRevisionEditDto) {
        EbomRevision revision = revisionMapper.ebomRevisionEditDtoWithItemToEntity(ebomRevisionEditDto, itemId);
        revision = revisionRepository.save(revision);
        return revisionMapper.entityToEbomRevisionDto(revision);
    }

    @Override
    public EbomRevisionDto updateRevision(EbomRevisionEditDto ebomRevisionEditDto, Long revisionId) {
        EbomRevision dbRevision = revisionRepository.findById(revisionId)
                .orElseThrow(() -> new NoSuchElementException("ebom.revision.not.found.exception"));
        EbomRevision ebomRevision = revisionMapper.ebomRevisionEditDtoToEntity(ebomRevisionEditDto, revisionId);
        ebomRevision.setItem(dbRevision.getItem());
        ebomRevision = revisionRepository.save(ebomRevision);
        return revisionMapper.entityToEbomRevisionDto(ebomRevision);
    }

    @Override
    public void deleteRevision(Long revisionId) {
        revisionRepository.deleteById(revisionId);
    }

    @Override
    public void copyEbom(Long revisionId, Long toRevisionId) {
        // TODO Реализация копирования EbomLine
    }

    @Override
    public void approveEbomRevision(Long revisionId) {
        EbomRevision ebomRevision = revisionRepository.findById(revisionId)
                .orElseThrow(() -> new NoSuchElementException("ebom.revision.not.found.exception"));

        ebomRevision.setApproved(true);
        ebomRevision.setApprovedDate(LocalDateTime.now());

    }
}

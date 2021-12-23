package ru.andri.simplepdm.ebom.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.andri.simplepdm.ebom.dao.entities.EbomRevision;
import ru.andri.simplepdm.ebom.dto.EbomLineDto;
import ru.andri.simplepdm.ebom.dto.EbomLineEditDto;
import ru.andri.simplepdm.ebom.dto.EbomRevisionDto;
import ru.andri.simplepdm.ebom.dto.EbomRevisionEditDto;
import ru.andri.simplepdm.ebom.services.EbomRevisionService;
import ru.andri.simplepdm.ebom.services.EbomLineService;

@RestController
@RequestMapping("/v1/ebom")
@RequiredArgsConstructor
public class EbomController {

    private final EbomRevisionService ebomRevisionService;
    private final EbomLineService ebomLineService;

    @GetMapping(value = "/item/{itemId}/revisions")
    public Page<EbomRevisionDto> getRevisions(@PathVariable Long itemId, Pageable pageable) {
        return ebomRevisionService.findAllRevisions(itemId, pageable);
    }

    @GetMapping(value = "/revisions/{revisionId}")
    public EbomRevisionDto getRevision(@PathVariable Long revisionId) {
        return ebomRevisionService.revisionById(revisionId);
    }

    @PostMapping("/item/{itemId}/revisions")
    public EbomRevisionDto createRevision(@PathVariable Long itemId, @RequestParam Long copyBomFromRevisionId, @RequestBody EbomRevisionEditDto ebomRevisionEditDto) {
        EbomRevisionDto revisionDto = ebomRevisionService.createRevision(itemId, ebomRevisionEditDto);

        if (copyBomFromRevisionId != null) {
            ebomRevisionService.copyEbom(copyBomFromRevisionId, revisionDto.getId());
        }
        return revisionDto;
    }

    @PutMapping("/revisions/{revisionId}")
    public EbomRevisionDto updateRevision(@RequestBody EbomRevisionEditDto ebomRevisionEditDto, @PathVariable Long revisionId) {
        return ebomRevisionService.updateRevision(ebomRevisionEditDto, revisionId);
    }

    @DeleteMapping(value = "/revisions/{revisionId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRevision(@PathVariable Long revisionId) {
        ebomRevisionService.deleteRevision(revisionId);
    }


    @GetMapping(value = "/revisions/{revisionId}/bomLines")
    public Page<EbomLineDto> getLines(@PathVariable Long revisionId, Pageable pageable) {
        return ebomLineService.findAllLines(revisionId, pageable);
    }

    @PostMapping(value = "/revisions/{revisionId}/approve")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void approveRevision(@PathVariable Long revisionId) {
        ebomRevisionService.approveEbomRevision(revisionId);
    }

    @GetMapping(value = "/bomLines/{bomLineId}")
    public EbomLineDto getLine(@PathVariable Long bomLineId) {
        return ebomLineService.lineById(bomLineId);
    }

    @PostMapping("/revisions/{revisionId}/bomLines")
    public EbomLineDto createLine(@PathVariable Long revisionId, @RequestBody EbomLineEditDto ebomLineEditDto) {
        return ebomLineService.createLine(revisionId, ebomLineEditDto);
    }

    @PutMapping("/bomLines/{bomLineId}")
    public EbomLineDto updateLine(@RequestBody EbomLineEditDto ebomLineEditDto, @PathVariable Long bomLineId) {
        return ebomLineService.updateLine(ebomLineEditDto, bomLineId);
    }

    @DeleteMapping(value = "/bomLines/{bomLineId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLine(@PathVariable Long bomLineId) {
        ebomLineService.deleteLine(bomLineId);
    }


}

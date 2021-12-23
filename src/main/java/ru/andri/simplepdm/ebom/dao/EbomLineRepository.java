package ru.andri.simplepdm.ebom.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.andri.simplepdm.ebom.dao.entities.EbomLine;
import ru.andri.simplepdm.ebom.dao.entities.EbomRevision;

public interface EbomLineRepository extends JpaRepository<EbomLine, Long> {

    Page<EbomLine> findByEbomRevision(EbomRevision ebomRevision, Pageable pageable);

}
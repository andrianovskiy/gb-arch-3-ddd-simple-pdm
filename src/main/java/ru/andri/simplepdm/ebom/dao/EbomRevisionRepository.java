package ru.andri.simplepdm.ebom.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.andri.simplepdm.ebom.dao.entities.EbomRevision;
import ru.andri.simplepdm.item.dao.entities.Item;

import java.util.List;

public interface EbomRevisionRepository extends JpaRepository<EbomRevision, Long> {

    Page<EbomRevision> findByItem(Item item, Pageable pageable);

}
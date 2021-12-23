package ru.andri.simplepdm.item.dao.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.andri.simplepdm.ebom.dao.entities.EbomRevision;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Item {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @OneToMany(targetEntity = EbomRevision.class,
            cascade = CascadeType.REMOVE, orphanRemoval = true, mappedBy = "item", fetch = FetchType.LAZY)
    private List<EbomRevision> ebomRevisions = new ArrayList<>();

}

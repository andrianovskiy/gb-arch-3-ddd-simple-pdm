package ru.andri.simplepdm.ebom.dao.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.andri.simplepdm.item.dao.entities.Item;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EbomLine {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private EbomRevision ebomRevision;

    @Column(nullable = false)
    private Integer number;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Item componentItem;

    private BigDecimal qty;

}

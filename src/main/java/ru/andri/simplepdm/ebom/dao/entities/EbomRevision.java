package ru.andri.simplepdm.ebom.dao.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.andri.simplepdm.item.dao.entities.Item;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class EbomRevision {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Item item;

    @Column(nullable = false)
    private String number;

    private String description;

    @Column(nullable = false)
    private Boolean approved = false;

    private LocalDateTime approvedDate;

}

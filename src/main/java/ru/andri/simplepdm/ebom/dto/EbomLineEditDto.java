package ru.andri.simplepdm.ebom.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EbomLineEditDto {

    private Integer number;
    private Long componentItemId;
    private BigDecimal qty;

}

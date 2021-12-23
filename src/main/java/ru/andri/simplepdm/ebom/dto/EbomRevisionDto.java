package ru.andri.simplepdm.ebom.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EbomRevisionDto {

    private Long id;
    private Long itemId;
    private String number;
    private String description;
    private Boolean approved;
    private LocalDateTime approvedDate;

}

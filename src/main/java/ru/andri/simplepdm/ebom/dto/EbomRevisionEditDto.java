package ru.andri.simplepdm.ebom.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EbomRevisionEditDto {

    private String number;
    private String description;


}

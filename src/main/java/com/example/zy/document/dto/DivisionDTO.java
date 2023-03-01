package com.example.zy.document.dto;

import com.example.zy.document.document.Division;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DivisionDTO {
    private String id;
    private String code;
    private String description;

    public static DivisionDTO from(Division division) {
        return DivisionDTO.builder()
                .id(division.getId())
                .code(division.getCode())
                .description(division.getDescription())
                .build();
    }
}

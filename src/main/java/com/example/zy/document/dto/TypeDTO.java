package com.example.zy.document.dto;

import com.example.zy.document.document.Type;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TypeDTO {
    private String id;
    private String management;
    private String divisionId;
    private String description;
    private String descriptionShort;

    public static TypeDTO from(Type type) {
        return TypeDTO.builder()
                .id(type.getId())
                .management(type.getManagement())
                .divisionId(type.getDivisionId())
                .description(type.getDescription())
                .descriptionShort(type.getDescriptionShort())
                .build();
    }
}
package com.example.zy.document.dto;

import com.example.zy.document.document.Type;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TypeDTO {
    private String id;
    private String code;
    private String description;
    private String descriptionShort;
    private String management;
    private String divisionId;
    private String divisionCode;

    public static TypeDTO from(Type type) {
        return TypeDTO.builder()
                .id(type.getId())
                .code(type.getCode())
                .management(type.getManagement())
                .divisionId(type.getDivisionId())
                .description(type.getDescription())
                .divisionCode(type.getDivisionCode())
                .descriptionShort(type.getDescriptionShort())
                .build();
    }
}

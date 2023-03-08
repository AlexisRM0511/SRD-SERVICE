package com.example.zy.document.document;

import com.example.zy.document.dto.TypeDTO;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Types")
@Data
@Builder
public class Type {
    @Id
    private String id;
    private String code;
    private String description;
    private String descriptionShort;
    private String management;
    private String divisionId;
    private String divisionCode;

    public static Type from(TypeDTO typeDTO) {
        return Type.builder()
                .id(typeDTO.getId())
                .code(typeDTO.getCode())
                .management(typeDTO.getManagement())
                .divisionId(typeDTO.getDivisionId())
                .divisionCode(typeDTO.getDivisionCode())
                .description(typeDTO.getDescription())
                .descriptionShort(typeDTO.getDescriptionShort())
                .build();
    }
}

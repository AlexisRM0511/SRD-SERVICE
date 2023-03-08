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
    private String management;
    private String divisionId;
    private String divisionDescription;
    private String description;
    private String descriptionShort;

    public static Type from(TypeDTO typeDTO) {
        return Type.builder()
                .id(typeDTO.getId())
                .management(typeDTO.getManagement())
                .divisionId(typeDTO.getDivisionId())
                .divisionDescription(typeDTO.getDivisionDescription())
                .description(typeDTO.getDescription())
                .descriptionShort(typeDTO.getDescriptionShort())
                .build();
    }
}

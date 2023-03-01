package com.example.zy.document.document;

import com.example.zy.document.dto.DivisionDTO;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Division")
@Data
@Builder
public class Division {
    @Id
    private String id;
    private String code;
    private String description;

    public static Division from(DivisionDTO divisionDTO) {
        return Division.builder()
                .id(divisionDTO.getId())
                .code(divisionDTO.getCode())
                .description(divisionDTO.getDescription())
                .build();
    }
}

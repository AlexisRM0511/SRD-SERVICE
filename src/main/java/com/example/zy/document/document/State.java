package com.example.zy.document.document;

import com.example.zy.document.dto.StateDTO;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "States")
@Data
@Builder
public class State {
    @Id
    private String id;

    private String description;

    private String descriptionShort;

    public static State from(StateDTO stateDTO) {
        return State.builder()
                .id(stateDTO.getId())
                .description(stateDTO.getDescription())
                .descriptionShort(stateDTO.getDescriptionShort())
                .build();
    }
}

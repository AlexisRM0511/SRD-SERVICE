package com.example.zy.document.dto;

import com.example.zy.document.document.State;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StateDTO {
    private String id;
    private String description;
    private String descriptionShort;

    public static StateDTO from(State state) {
        return StateDTO.builder()
                .id(state.getId())
                .description(state.getDescription())
                .descriptionShort(state.getDescriptionShort())
                .build();
    }
}

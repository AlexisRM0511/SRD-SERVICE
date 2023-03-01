package com.example.zy.document.dto;

import com.example.zy.document.document.Client;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ClientDTO {
    private String id;
    private String description;
    private String descriptionShort;
    private String nickname;
    private String statusId;

    public static ClientDTO from(Client client) {
        return ClientDTO.builder()
                .id(client.getId())
                .description(client.getDescription())
                .descriptionShort(client.getDescriptionShort())
                .nickname(client.getNickname())
                .statusId(client.getStatusId())
                .build();
    }
}

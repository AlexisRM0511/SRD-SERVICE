package com.example.zy.document.document;

import com.example.zy.document.dto.ClientDTO;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Clients")
@Data
@Builder
public class Client {
    @Id
    private String id;
    private String description;
    private String descriptionShort;
    private String nickname;
    private String statusId;

    public static Client from(ClientDTO clientDTO) {
        return Client.builder()
                .id(clientDTO.getId())
                .description(clientDTO.getDescription())
                .descriptionShort(clientDTO.getDescriptionShort())
                .nickname(clientDTO.getNickname())
                .statusId(clientDTO.getStatusId())
                .build();
    }
}

package com.example.zy.document.document;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "Clients")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    private String id;
    @NonNull
    private String description;

    @NonNull
    private String description_short;

    @NonNull
    private String nickname;

    @NonNull
    private String status_id;

    public Client(String id, @NonNull String description, @NonNull String description_short, @NonNull String nickname, @NonNull String status_id) {
        this.id = id;
        this.description = description;
        this.description_short = description_short;
        this.nickname = nickname;
        this.status_id = status_id;
    }
}

package com.example.zy.document.document;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "Types")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Type {

    @Id
    private String id;
    @NonNull
    private String description;

    @NonNull
    private String description_short;

    public Type(String id, @NonNull String description, @NonNull String description_short) {
        this.id = id;
        this.description = description;
        this.description_short = description_short;
    }
}

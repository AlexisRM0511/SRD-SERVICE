package com.example.zy.document.document;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "Files")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Type {

    @Id
    private String id;
    @NonNull
    private int type_id;

    @NonNull
    private int client_id;

    @NonNull
    private String version;

    @NonNull
    private Date date_created;

    @NonNull
    private String file_pdf;

    @NonNull
    private String file_docx;

    @NonNull
    private int status_id;

    public Type(String id, @NonNull int type_id, @NonNull int client_id, @NonNull String version, @NonNull Date date_created, @NonNull String file_pdf, @NonNull String file_docx, @NonNull int status_id) {
        this.id = id;
        this.type_id = type_id;
        this.client_id = client_id;
        this.version = version;
        this.date_created = date_created;
        this.file_pdf = file_pdf;
        this.file_docx = file_docx;
        this.status_id = status_id;
    }
}

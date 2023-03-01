package com.example.zy.document.dto;

import com.example.zy.document.document.File;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class FileDTO {
    private String id;
    private String typeId;
    private String clientId;
    private String version;
    private Date dateCreated;
    private String filePdf;
    private String fileDocx;
    private String statusId;

    public static FileDTO from(File file) {
        return FileDTO.builder()
                .id(file.getId())
                .typeId(file.getTypeId())
                .clientId(file.getClientId())
                .version(file.getVersion())
                .dateCreated(file.getDateCreated())
                .filePdf(file.getFilePdf())
                .fileDocx(file.getFileDocx())
                .statusId(file.getStatusId())
                .build();
    }
}

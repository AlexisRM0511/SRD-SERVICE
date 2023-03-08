package com.example.zy.document.dto;

import com.example.zy.document.document.File;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class FileDTO {
    private String id;
    private String name;
    private String code;
    private String typeId;
    private String typeDescriptionShort;
    private String clientId;
    private String clientDescriptionShort;
    private String version;
    private Date dateCreated;
    private String filePdf;
    private String fileDocx;
    private String stateId;
    private String stateDescriptionShort;

    public static FileDTO from(File file) {
        return FileDTO.builder()
                .id(file.getId())
                .name(file.getName())
                .code(file.getCode())
                .typeId(file.getTypeId())
                .typeDescriptionShort(file.getTypeDescriptionShort())
                .clientId(file.getClientId())
                .clientDescriptionShort(file.getClientDescriptionShort())
                .version(file.getVersion())
                .dateCreated(file.getDateCreated())
                .filePdf(file.getFilePdf())
                .fileDocx(file.getFileDocx())
                .stateId(file.getStateId())
                .stateDescriptionShort(file.getStateDescriptionShort())
                .build();
    }
}

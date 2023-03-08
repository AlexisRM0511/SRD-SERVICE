package com.example.zy.document.document;

import com.example.zy.document.dto.FileDTO;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "Files")
@Data
@Builder
public class File {
    @Id
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

    public static File from(FileDTO fileDTO) {
        return File.builder()
                .id(fileDTO.getId())
                .name(fileDTO.getName())
                .code(fileDTO.getCode())
                .typeId(fileDTO.getTypeId())
                .typeDescriptionShort(fileDTO.getTypeDescriptionShort())
                .clientId(fileDTO.getClientId())
                .clientDescriptionShort(fileDTO.getClientDescriptionShort())
                .version(fileDTO.getVersion())
                .dateCreated(fileDTO.getDateCreated())
                .filePdf(fileDTO.getFilePdf())
                .fileDocx(fileDTO.getFileDocx())
                .stateId(fileDTO.getStateId())
                .stateDescriptionShort(fileDTO.getStateDescriptionShort())
                .build();
    }
}

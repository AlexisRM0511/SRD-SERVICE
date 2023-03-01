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
    private String typeId;
    private String clientId;
    private String version;
    private Date dateCreated;
    private String filePdf;
    private String fileDocx;
    private String statusId;

    public static File from(FileDTO fileDTO) {
        return File.builder()
                .id(fileDTO.getId())
                .typeId(fileDTO.getTypeId())
                .clientId(fileDTO.getClientId())
                .version(fileDTO.getVersion())
                .dateCreated(fileDTO.getDateCreated())
                .filePdf(fileDTO.getFilePdf())
                .fileDocx(fileDTO.getFileDocx())
                .statusId(fileDTO.getStatusId())
                .build();
    }
}

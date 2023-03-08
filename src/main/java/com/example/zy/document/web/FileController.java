package com.example.zy.document.web;

import com.example.zy.document.document.File;
import com.example.zy.document.dto.FileDTO;
import com.example.zy.document.repository.FileRepository;
import com.example.zy.document.utils.ZyCode;
import com.example.zy.document.utils.ZyResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/file")
public class FileController {

    Logger logger = Logger.getLogger(FileController.class.getName());
    private final FileRepository fileRepository;

    public FileController(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @PostMapping("/save")
    public ZyResponse<File> saveDocument(@RequestBody FileDTO fileDTO) {
        try {
            return new ZyResponse<>(ZyCode.SUCCESS, fileRepository.save(File.from(fileDTO)));
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ZyResponse<>(ZyCode.ERROR);
        }
    }

    @GetMapping("/all")
    public ZyResponse<List<File>> readAllDocuments() {
        try {
            return new ZyResponse<>(ZyCode.SUCCESS, fileRepository.findAll());
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ZyResponse<>(ZyCode.ERROR);
        }
    }

    @PutMapping("/update")
    public ZyResponse<File> updateDocument(@RequestBody FileDTO fileDTO) {
        try {
            return new ZyResponse<>(ZyCode.SUCCESS, fileRepository.save(File.from(fileDTO)));
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ZyResponse<>(ZyCode.ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ZyResponse<String> deleteDocument(@PathVariable String id) {
        try {
            fileRepository.deleteById(id);
            return new ZyResponse<>(ZyCode.SUCCESS);
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ZyResponse<>(ZyCode.ERROR);
        }
    }

    @GetMapping("/get/{id}")
    public ZyResponse<Optional<File>> readDocument(@PathVariable String id) {
        try {
            return new ZyResponse<>(ZyCode.SUCCESS, fileRepository.findById(id));
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ZyResponse<>(ZyCode.ERROR);
        }
    }

    @PostMapping("/filter")
    public ZyResponse<List<File>> filterDocuments(@RequestBody FileDTO fileDTO) {
        try {
            if (fileDTO.getStateId() == null) {
                fileDTO.setStateId("");
            }
            if (fileDTO.getTypeId() == null) {
                fileDTO.setTypeId("");
            }

            if (fileDTO.getClientId() == null) {
                fileDTO.setClientId("");
            }

            return new ZyResponse<>(ZyCode.SUCCESS, fileRepository.findByFills(fileDTO.getStateId(), fileDTO.getTypeId(), fileDTO.getClientId()));
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ZyResponse<>(ZyCode.ERROR);
        }
    }
}

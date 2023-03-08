package com.example.zy.document.web;

import com.example.zy.document.document.Type;
import com.example.zy.document.dto.TypeDTO;
import com.example.zy.document.repository.DivisionRepository;
import com.example.zy.document.repository.TypeRepository;
import com.example.zy.document.utils.ZyCode;
import com.example.zy.document.utils.ZyResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
@RequestMapping("/api/type")
public class TypeController {

    Logger logger = Logger.getLogger(TypeController.class.getName());
    private final TypeRepository typeRepository;
    private final DivisionRepository divisionRepository;

    public TypeController(TypeRepository typeRepository, DivisionRepository divisionRepository) {
        this.typeRepository = typeRepository;
        this.divisionRepository = divisionRepository;
    }

    @PostMapping("/save")
    public ZyResponse<Type> saveDocument(@RequestBody TypeDTO typeDTO) {
        try {
            divisionRepository.findById(typeDTO.getDivisionId()).ifPresent(division -> typeDTO.setDivisionCode(division.getCode()));
            return new ZyResponse<>(ZyCode.SUCCESS, typeRepository.save(Type.from(typeDTO)));
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ZyResponse<>(ZyCode.ERROR);
        }
    }

    @GetMapping("/all")
    public ZyResponse<List<Type>> readAllDocuments() {
        try {
            return new ZyResponse<>(ZyCode.SUCCESS, typeRepository.findAll());
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ZyResponse<>(ZyCode.ERROR);
        }
    }

    @PutMapping("/update")
    public ZyResponse<Type> updateDocument(@RequestBody TypeDTO typeDTO) {
        try {
            divisionRepository.findById(typeDTO.getDivisionId()).ifPresent(division -> typeDTO.setDivisionCode(division.getCode()));
            return new ZyResponse<>(ZyCode.SUCCESS, typeRepository.save(Type.from(typeDTO)));
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ZyResponse<>(ZyCode.ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ZyResponse<String> deleteDocument(@PathVariable String id) {
        try {
            typeRepository.deleteById(id);
            return new ZyResponse<>(ZyCode.SUCCESS);
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ZyResponse<>(ZyCode.ERROR);
        }
    }

    @GetMapping("/get/{id}")
    public ZyResponse<Optional<Type>> readDocument(@PathVariable String id) {
        try {
            return new ZyResponse<>(ZyCode.SUCCESS, typeRepository.findById(id));
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ZyResponse<>(ZyCode.ERROR);
        }
    }

    @PostMapping("/filter")
    public ZyResponse<List<Type>> filterDocuments(@RequestBody TypeDTO typeDTO) {
        try {
            if (typeDTO.getDescription() == null) {
                typeDTO.setDescription("");
            }
            if (typeDTO.getDescriptionShort() == null) {
                typeDTO.setDescriptionShort("");
            }
            return new ZyResponse<>(ZyCode.SUCCESS, typeRepository.findByFills(typeDTO.getManagement(), typeDTO.getDivisionId(), typeDTO.getDescription(), typeDTO.getDescriptionShort()));
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ZyResponse<>(ZyCode.ERROR);
        }
    }
}

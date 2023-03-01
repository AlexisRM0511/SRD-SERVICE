package com.example.zy.document.web;

import com.example.zy.document.document.Type;
import com.example.zy.document.dto.TypeDTO;
import com.example.zy.document.repository.TypeRepository;
import com.example.zy.document.utils.ZyCode;
import com.example.zy.document.utils.ZyResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/types")
public class TypeController {

    Logger logger = Logger.getLogger(TypeController.class.getName());
    private final TypeRepository typeRepository;

    public TypeController(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @PostMapping("/save")
    public ZyResponse<Type> saveDocument(@RequestBody TypeDTO typeDTO) {
        try {
//            tokenGenerator.
            return new ZyResponse<>(ZyCode.SUCCESS, typeRepository.save(Type.from(typeDTO)));
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ZyResponse<>(ZyCode.ERROR);
        }
    }

    @GetMapping("/all")
    public ZyResponse<List<Type>> readAllTypes() {
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
    public ZyResponse<Optional<Type>> readType(@PathVariable String id) {
        try {
            return new ZyResponse<>(ZyCode.SUCCESS, typeRepository.findById(id));
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ZyResponse<>(ZyCode.ERROR);
        }
    }

    @PostMapping("/filter")
    public ZyResponse<List<Type>> filterTypes(@RequestBody TypeDTO typeDTO) {
        try {
            if (typeDTO.getDescription() == null) {
                typeDTO.setDescription("");
            }
            if (typeDTO.getDescriptionShort() == null) {
                typeDTO.setDescriptionShort("");
            }
            return new ZyResponse<>(ZyCode.SUCCESS, typeRepository.findByFills(typeDTO.getDescription(), typeDTO.getDescriptionShort()));
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ZyResponse<>(ZyCode.ERROR);
        }
    }
}

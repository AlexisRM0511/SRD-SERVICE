package com.example.zy.document.web;

import com.example.zy.document.document.Division;
import com.example.zy.document.dto.DivisionDTO;
import com.example.zy.document.repository.DivisionRepository;
import com.example.zy.document.utils.ZyCode;
import com.example.zy.document.utils.ZyResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
@RequestMapping("/api/division")
public class DivisionController {

    Logger logger = Logger.getLogger(DivisionController.class.getName());
    private final DivisionRepository divisionRepository;

    public DivisionController(DivisionRepository divisionRepository) {
        this.divisionRepository = divisionRepository;
    }

    @PostMapping("/save")
    public ZyResponse<Division> saveDocument(@RequestBody DivisionDTO divisionDTO) {
        try {
//            tokenGenerator.
            return new ZyResponse<>(ZyCode.SUCCESS, divisionRepository.save(Division.from(divisionDTO)));
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ZyResponse<>(ZyCode.ERROR);
        }
    }

    @GetMapping("/all")
    public ZyResponse<List<Division>> readAllDocuments() {
        try {
            return new ZyResponse<>(ZyCode.SUCCESS, divisionRepository.findAll());
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ZyResponse<>(ZyCode.ERROR);
        }
    }

    @PutMapping("/update")
    public ZyResponse<Division> updateDocument(@RequestBody DivisionDTO divisionDTO) {
        try {
            return new ZyResponse<>(ZyCode.SUCCESS, divisionRepository.save(Division.from(divisionDTO)));
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ZyResponse<>(ZyCode.ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ZyResponse<String> deleteDocument(@PathVariable String id) {
        try {
            divisionRepository.deleteById(id);
            return new ZyResponse<>(ZyCode.SUCCESS);
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ZyResponse<>(ZyCode.ERROR);
        }
    }

    @GetMapping("/get/{id}")
    public ZyResponse<Optional<Division>> readDocument(@PathVariable String id) {
        try {
            return new ZyResponse<>(ZyCode.SUCCESS, divisionRepository.findById(id));
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ZyResponse<>(ZyCode.ERROR);
        }
    }

    @PostMapping("/filter")
    public ZyResponse<List<Division>> filterDocuments(@RequestBody DivisionDTO divisionDTO) {
        try {
            if (divisionDTO.getCode() == null) {
                divisionDTO.setCode("");
            }
            if (divisionDTO.getDescription() == null) {
                divisionDTO.setDescription("");
            }
            return new ZyResponse<>(ZyCode.SUCCESS, divisionRepository.findByFills(divisionDTO.getCode(), divisionDTO.getDescription()));
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ZyResponse<>(ZyCode.ERROR);
        }
    }
}

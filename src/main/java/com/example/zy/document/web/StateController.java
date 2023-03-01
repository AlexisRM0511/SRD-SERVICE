package com.example.zy.document.web;

import com.example.zy.document.document.State;
import com.example.zy.document.dto.StateDTO;
import com.example.zy.document.repository.StateRepository;
import com.example.zy.document.utils.ZyCode;
import com.example.zy.document.utils.ZyResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/state")
public class StateController {

    Logger logger = Logger.getLogger(StateController.class.getName());
    private final StateRepository stateRepository;

    public StateController(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @PostMapping("/save")
    public ZyResponse<State> saveDocument(@RequestBody StateDTO stateDTO) {
        try {
//            tokenGenerator.
            return new ZyResponse<>(ZyCode.SUCCESS, stateRepository.save(State.from(stateDTO)));
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ZyResponse<>(ZyCode.ERROR);
        }
    }

    @GetMapping("/all")
    public ZyResponse<List<State>> readAllDocuments() {
        try {
            return new ZyResponse<>(ZyCode.SUCCESS, stateRepository.findAll());
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ZyResponse<>(ZyCode.ERROR);
        }
    }

    @PutMapping("/update")
    public ZyResponse<State> updateDocument(@RequestBody StateDTO stateDTO) {
        try {
            return new ZyResponse<>(ZyCode.SUCCESS, stateRepository.save(State.from(stateDTO)));
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ZyResponse<>(ZyCode.ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ZyResponse<String> deleteDocument(@PathVariable String id) {
        try {
            stateRepository.deleteById(id);
            return new ZyResponse<>(ZyCode.SUCCESS);
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ZyResponse<>(ZyCode.ERROR);
        }
    }

    @GetMapping("/get/{id}")
    public ZyResponse<Optional<State>> readDocument(@PathVariable String id) {
        try {
            return new ZyResponse<>(ZyCode.SUCCESS, stateRepository.findById(id));
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ZyResponse<>(ZyCode.ERROR);
        }
    }

    @PostMapping("/filter")
    public ZyResponse<List<State>> filterDocuments(@RequestBody StateDTO stateDTO) {
        try {
            if (stateDTO.getDescription() == null) {
                stateDTO.setDescription("");
            }
            if (stateDTO.getDescriptionShort() == null) {
                stateDTO.setDescriptionShort("");
            }
            return new ZyResponse<>(ZyCode.SUCCESS, stateRepository.findByFills(stateDTO.getDescription(), stateDTO.getDescriptionShort()));
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ZyResponse<>(ZyCode.ERROR);
        }
    }
}

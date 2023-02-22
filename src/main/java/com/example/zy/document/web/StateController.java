package com.example.zy.document.web;

import com.example.zy.document.document.State;
import com.example.zy.document.document.User;
import com.example.zy.document.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/states")
public class StateController {

    @Autowired
    private StateRepository stateRepository;

    @PostMapping("/save")
    public ResponseEntity<?> createState(@RequestBody State state, @AuthenticationPrincipal User user) {
        try {
            State stateSave = stateRepository.save(state);
            return new ResponseEntity<>(stateSave, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getDocuments() {
        try {
            return new ResponseEntity<>(stateRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateState(@RequestBody State state) {
        try {
            State stateUpdate = stateRepository.save(state);
            return new ResponseEntity<>(stateUpdate, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDocument(@PathVariable String id) {
        try {
            stateRepository.deleteById(id);
            return new ResponseEntity<>("State deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> readState(@PathVariable String id) {
        try {
            return new ResponseEntity<>(stateRepository.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

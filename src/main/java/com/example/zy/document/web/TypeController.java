package com.example.zy.document.web;

import com.example.zy.document.document.Type;
import com.example.zy.document.document.User;
import com.example.zy.document.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/documents")
public class TypeController {

    @Autowired
    private TypeRepository typeRepository;

    @PostMapping("/save")
    public ResponseEntity<?> createType(@RequestBody Type type, @AuthenticationPrincipal User user) {
        try {
            Type typeSave = typeRepository.save(type);
            return new ResponseEntity<>(typeSave, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getDocuments() {
        try {
            return new ResponseEntity<>(typeRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateType(@RequestBody Type type) {
        try {
            Type typeUpdate = typeRepository.save(type);
            return new ResponseEntity<>(typeUpdate, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDocument(@PathVariable String id) {
        try {
            typeRepository.deleteById(id);
            return new ResponseEntity<>("Type deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> readType(@PathVariable String id) {
        try {
            return new ResponseEntity<>(typeRepository.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

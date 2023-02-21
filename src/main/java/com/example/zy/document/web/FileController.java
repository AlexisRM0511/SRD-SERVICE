package com.example.zy.document.web;

import com.example.zy.document.document.File;
import com.example.zy.document.document.User;
import com.example.zy.document.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/documents")
public class FileController {

    @Autowired
    private FileRepository fileRepository;

    @PostMapping("/save")
    public ResponseEntity<?> createDocument(@RequestBody File file, @AuthenticationPrincipal User user) {
        try {
            File fileSave = fileRepository.save(file);
            return new ResponseEntity<>(fileSave, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getDocuments() {
        try {
            return new ResponseEntity<>(fileRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateDocument(@RequestBody File file) {
        try {
            File fileUpdate = fileRepository.save(file);
            return new ResponseEntity<>(fileUpdate, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDocument(@PathVariable String id) {
        try {
            fileRepository.deleteById(id);
            return new ResponseEntity<>("Document deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getDocument(@PathVariable String id) {
        try {
            return new ResponseEntity<>(fileRepository.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

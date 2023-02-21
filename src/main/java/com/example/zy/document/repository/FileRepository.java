package com.example.zy.document.repository;

import com.example.zy.document.document.File;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface FileRepository extends MongoRepository<File, String> {
    Optional<File> findById(String id);
}

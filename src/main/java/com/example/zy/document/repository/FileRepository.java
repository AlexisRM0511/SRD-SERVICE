package com.example.zy.document.repository;

import com.example.zy.document.document.File;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FileRepository extends MongoRepository<File, String> {
}
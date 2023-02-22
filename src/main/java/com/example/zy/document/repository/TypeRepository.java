package com.example.zy.document.repository;

import com.example.zy.document.document.File;
import com.example.zy.document.document.Type;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TypeRepository extends MongoRepository<Type, String> {
}

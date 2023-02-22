package com.example.zy.document.repository;

import com.example.zy.document.document.File;
import com.example.zy.document.document.State;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StateRepository extends MongoRepository<State, String> {
}

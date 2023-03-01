package com.example.zy.document.repository;

import com.example.zy.document.document.File;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FileRepository extends MongoRepository<File, String> {
    @Override
    <S extends File> S save(S entity);

    @Override
    <S extends File> List<S> findAll(Example<S> example);

    @Override
    void deleteById(String s);

    @Override
    Optional<File> findById(String s);

    @Query("{ 'statusId' : { '$regex': ?0, '$options': 'i' }, 'typeId' : { '$regex': ?1, '$options': 'i' } }")
    List<File> findByFills(String statusId, String typeId);
}

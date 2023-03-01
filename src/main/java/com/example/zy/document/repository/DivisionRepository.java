package com.example.zy.document.repository;

import com.example.zy.document.document.Division;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DivisionRepository extends MongoRepository<Division, String> {

    @Override
    <S extends Division> S save(S entity);

    @Override
    <S extends Division> List<S> findAll(Example<S> example);

    @Override
    void deleteById(String s);

    @Override
    Optional<Division> findById(String s);

    @Query("{ 'code' : { '$regex': ?0, '$options': 'i' }, 'description' : { '$regex': ?1, '$options': 'i' } }")
    List<Division> findByFills(String code, String description);
}

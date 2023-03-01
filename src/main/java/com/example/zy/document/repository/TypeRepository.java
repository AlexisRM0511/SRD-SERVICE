package com.example.zy.document.repository;

import com.example.zy.document.document.Type;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TypeRepository extends MongoRepository<Type, String> {
    @Override
    <S extends Type> S save(S entity);

    @Override
    <S extends Type> List<S> findAll(Example<S> example);

    @Override
    void deleteById(String s);

    @Override
    Optional<Type> findById(String s);

    @Query("{ 'management' : { '$regex': ?0, '$options': 'i' }, 'divisionId' : { '$regex': ?1, '$options': 'i' }, 'description' : { '$regex': ?2, '$options': 'i' }, 'descriptionShort' : { '$regex': ?3, '$options': 'i' } }")
    List<Type> findByFills(String management, String divisionId, String description, String descriptionShort);
}

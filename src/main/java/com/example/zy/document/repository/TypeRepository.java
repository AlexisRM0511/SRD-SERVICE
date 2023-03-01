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

    @Query("{ 'description' : { '$regex': ?0, '$options': 'i' }, 'descriptionShort' : { '$regex': ?1, '$options': 'i' } }")
    List<Type> findByFills(String description, String descriptionShort);
}

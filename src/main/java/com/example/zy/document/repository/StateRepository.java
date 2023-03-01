package com.example.zy.document.repository;

import com.example.zy.document.document.State;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StateRepository extends MongoRepository<State, String> {

    @Override
    <S extends State> S save(S entity);

    @Override
    <S extends State> List<S> findAll(Example<S> example);

    @Override
    void deleteById(String s);

    @Override
    Optional<State> findById(String s);

    @Query("{ 'description' : { '$regex': ?0, '$options': 'i' }, 'descriptionShort' : { '$regex': ?1, '$options': 'i' } }")
    List<State> findByFills(String description, String descriptionShort);
}

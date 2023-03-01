package com.example.zy.document.repository;

import com.example.zy.document.document.Client;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends MongoRepository<Client, String> {

    @Override
    <S extends Client> S save(S entity);

    @Override
    <S extends Client> List<S> findAll(Example<S> example);

    @Override
    void deleteById(String s);

    @Override
    Optional<Client> findById(String s);

    @Query("{ 'description' : { '$regex': ?0, '$options': 'i' }, 'descriptionShort' : { '$regex': ?1, '$options': 'i' }, 'nickname' : { '$regex': ?2, '$options': 'i' }, 'statusId' : ?3 }")
    List<Client> findByFills(String description, String descriptionShort, String nickname, String statusId);
}

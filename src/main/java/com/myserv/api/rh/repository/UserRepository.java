package com.myserv.api.rh.repository;

import com.myserv.api.rh.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends MongoRepository <User, String> {

    Optional<User> findByUsername (String username);


    Boolean existsByUsername(String username);

    Boolean existsByEmail (String email);
}
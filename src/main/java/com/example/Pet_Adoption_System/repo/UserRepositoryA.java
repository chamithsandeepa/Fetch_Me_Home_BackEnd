package com.example.Pet_Adoption_System.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.Pet_Adoption_System.Model.UserA;

public interface UserRepositoryA extends MongoRepository<UserA, String> {
    Optional<UserA> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}

package com.example.Pet_Adoption_System.Repository;

import com.example.Pet_Adoption_System.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
    User findByName(String name); // Added method to find by name
    Boolean existsByName(String name);
    Boolean existsByEmail(String email);
}
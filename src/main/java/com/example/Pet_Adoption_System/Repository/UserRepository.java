package com.example.Pet_Adoption_System.Repository;

import com.example.Pet_Adoption_System.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    
    Optional<User> findByUserName(String userName);
    
    User findByEmail(String email);

    Boolean existsByUserName(String username);
  
    Boolean existsByEmail(String email);
}

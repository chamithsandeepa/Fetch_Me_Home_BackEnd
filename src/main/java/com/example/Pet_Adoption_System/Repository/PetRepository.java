package com.example.Pet_Adoption_System.Repository;

import com.example.Pet_Adoption_System.Model.Pet;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;


public interface PetRepository extends MongoRepository<Pet, String> {
    
    List<Pet> findBySex(String sex);
    
    List<Pet> findByBreed(String breed);
    
    List<Pet> findByAdopted(boolean adopted);


}



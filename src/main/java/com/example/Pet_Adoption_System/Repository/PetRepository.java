package com.example.Pet_Adoption_System.Repository;

import com.example.Pet_Adoption_System.Model.Pet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface PetRepository extends MongoRepository<Pet, Integer> {
    
    Pet findBySex(String sex);
    
    Pet findByBreed(String breed);
    
    List<Pet> findByAdopted(boolean adopted);

}


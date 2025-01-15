package com.example.Pet_Adoption_System.Repository;

import com.example.Pet_Adoption_System.Model.Pet;
import org.springframework.data.mongodb.repository.MongoRepository;


<<<<<<< HEAD
@Repository
public interface PetRepository extends MongoRepository<Pet, Integer> {
    
    List<Pet> findBySex(String sex);
    
    List<Pet> findByBreed(String breed);
    
    List<Pet> findByAdopted(boolean adopted);

=======
public interface PetRepository extends MongoRepository<Pet, String> {
    // Additional custom queries can be added here if needed
>>>>>>> main
}



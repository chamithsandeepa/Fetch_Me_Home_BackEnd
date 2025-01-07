package com.example.Pet_Adoption_System.Repository;

import com.example.Pet_Adoption_System.Model.PetSearch;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PetSearchRepository extends MongoRepository<PetSearch, String>{
    List<PetSearch> findBySpecies(String species);
}

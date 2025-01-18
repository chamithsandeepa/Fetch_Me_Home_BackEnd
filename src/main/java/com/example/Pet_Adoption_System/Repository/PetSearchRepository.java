package com.example.Pet_Adoption_System.Repository;

import com.example.Pet_Adoption_System.Model.PetSearch;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PetSearchRepository extends MongoRepository<PetSearch, Long> {
}

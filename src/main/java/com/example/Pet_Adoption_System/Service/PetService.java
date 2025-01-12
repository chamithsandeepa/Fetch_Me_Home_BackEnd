package com.example.Pet_Adoption_System.Service;

import com.example.Pet_Adoption_System.Model.Pet;
import com.example.Pet_Adoption_System.Repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public Pet addPet(Pet pet) {
        // Log the pet details before saving
        System.out.println("Saving Pet: " + pet);

        // Save the pet to the database
        return petRepository.save(pet);
    }

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public Pet getPetById(String id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pet not found"));
    }

    public void deletePet(String id) {
        petRepository.deleteById(id);
    }
}

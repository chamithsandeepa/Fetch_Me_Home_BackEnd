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

<<<<<<< HEAD
    Pet addPet(Pet pet);
    Pet getPetById(Integer id);
    List<Pet> getAllPets();
    Pet updatePet(Integer id, Pet pet);
    void  deletePet(Integer id);
    List<Pet> getAvailablePets(Boolean adopted);
    Pet adoptPet(Integer id);
    List<Pet> getPetsBySex(String sex);
    List<Pet> getPetsByBreed(String breed);
=======
    public Pet addPet(Pet pet) {
        // Log the pet details before saving
        System.out.println("Saving Pet: " + pet);
>>>>>>> main

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

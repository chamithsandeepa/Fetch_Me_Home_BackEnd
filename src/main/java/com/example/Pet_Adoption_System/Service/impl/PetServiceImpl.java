package com.example.Pet_Adoption_System.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Pet_Adoption_System.Model.Pet;
import com.example.Pet_Adoption_System.Repository.PetRepository;
import com.example.Pet_Adoption_System.Service.PetService; 

import java.util.Optional;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetRepository petRepository;

    @Override
    public Pet addPet(Pet pet) {
        // Save the pet as a document in the MongoDB collection
        return petRepository.save(pet);
    }

    @Override
    public List<Pet> getAllPets() {
        // Retrieve all pet documents from the collection
        return petRepository.findAll();
    }

    @Override
    public Pet getPetById(String id) {
        Optional<Pet> pet = petRepository.findById(id);
       return pet.orElse(null);
    }

    @Override
    public Pet updatePet(String id, Pet pet) {
        if(petRepository.existsById(id)){
            pet.setId(id);
            return petRepository.save(pet);
        }
        return null;
    }

    @Override
    public void deletePet(String id) {
        petRepository.deleteById(id);
    }

    @Override
    public List<Pet> getAvailablePets(Boolean adopted) {
        return petRepository.findByAdopted(false);
    }

    @Override
    public Pet adoptPet(String id) {
        Pet pet = getPetById(id);
        pet.setAdopted(true);
        return petRepository.save(pet);
    }

    @Override
    public List<Pet> getPetsBySex(String sex) {
        return petRepository.findBySex(sex);
    }

    @Override
    public List<Pet> getPetsByBreed(String breed) {
        return petRepository.findByBreed(breed);

    }
    
}

package com.example.Pet_Adoption_System.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Pet_Adoption_System.Model.Pet;
import com.example.Pet_Adoption_System.Model.User;
import com.example.Pet_Adoption_System.Repository.PetRepository;
import com.example.Pet_Adoption_System.Service.PetService; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}


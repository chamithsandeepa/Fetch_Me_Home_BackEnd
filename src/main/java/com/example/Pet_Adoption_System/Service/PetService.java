package com.example.Pet_Adoption_System.Service;

import com.example.Pet_Adoption_System.Model.Pet;

import java.util.List;


public interface PetService {

    Pet addPet(Pet pet);
    Pet getPetById(Integer id);
    List<Pet> getAllPets();
    Pet updatePet(Integer id, Pet pet);
    void  deletePet(Integer id);

    
}

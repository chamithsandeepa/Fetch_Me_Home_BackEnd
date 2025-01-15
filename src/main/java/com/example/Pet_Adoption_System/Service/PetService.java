package com.example.Pet_Adoption_System.Service;

import com.example.Pet_Adoption_System.Model.Pet;
import com.example.Pet_Adoption_System.Repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PetService {

    public Pet addPet(Pet pet);
    public List<Pet> getAllPets();

    public Pet getPetById(String id);

    public void deletePet(String id);
}

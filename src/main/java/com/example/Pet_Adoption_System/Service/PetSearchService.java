package com.example.Pet_Adoption_System.Service;

import com.example.Pet_Adoption_System.Model.PetSearch;

import java.util.List;

public interface PetSearchService {
   List<PetSearch> filterBySpecies(String species);
}
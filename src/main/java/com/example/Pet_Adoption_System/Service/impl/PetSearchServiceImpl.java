package com.example.Pet_Adoption_System.Service.impl;

import com.example.Pet_Adoption_System.Model.PetSearch;
import com.example.Pet_Adoption_System.Service.PetSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetSearchServiceImpl implements PetSearchService {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<PetSearch> searchPet(String species, String gender, Integer age, String color) {
        Query query = new Query();

        if (species != null && !species.isEmpty()) {
            query.addCriteria(Criteria.where("species").is(species));
        }
        if (gender != null && !gender.isEmpty()) {
            query.addCriteria(Criteria.where("gender").is(gender));
        }
        if (age != null) { // Fixed duplicate null check
            query.addCriteria(Criteria.where("age").is(age));
        }
        if (color != null && !color.isEmpty()) {
            query.addCriteria(Criteria.where("color").is(color));
        }
        //ghfuiewgfuiohfwiuhf
        return mongoTemplate.find(query, PetSearch.class);
    }
}

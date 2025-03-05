package com.example.Pet_Adoption_System.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.Pet_Adoption_System.Model.Student;

public interface StudentRepo extends MongoRepository<Student, String> {
    List<Student> findByYearOfEnrollment(String yearOfEnrollment);

    void deleteByYearOfEnrollment(String yearOfEnrollment);

}

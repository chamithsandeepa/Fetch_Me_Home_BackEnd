package com.example.Pet_Adoption_System.serviceA.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Pet_Adoption_System.Model.Student;
import com.example.Pet_Adoption_System.repo.StudentRepo;
import com.example.Pet_Adoption_System.serviceA.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    public StudentRepo studentRepo;

    public Student saveStudent(Student student) {
        return studentRepo.save(student);

    }

    @Override
    public Student updateStudent(Student student, String id) {
        Optional<Student> existingStudent = studentRepo.findById(id);
        if (existingStudent.isPresent()) {
            Student newStudent = existingStudent.get();
            newStudent.setFirstName(student.getFirstName());
            newStudent.setLastName(student.getLastName());
            newStudent.setEmail(student.getEmail());
            newStudent.setDepartment(student.getDepartment());
            newStudent.setYearOfEnrollment(student.getYearOfEnrollment());
            return studentRepo.save(newStudent);
        } else {
            throw new RuntimeException("Cannot find any entity according to this id :" + id);
        }

    }

    @Override
    public Student getStudentById(String id) {
        Optional<Student> student = studentRepo.findById(id);
        if (student.isPresent()) {
            return student.get();
        } else {
            throw new RuntimeException("Student not found!");
        }
    }

    @Override
    public boolean DeleteStudent(String id) {
        Optional<Student> student = studentRepo.findById(id);
        if (student.isPresent()) {
            studentRepo.deleteById(id);
            return true;

        } else {
            throw new RuntimeException("Cannot find the student Id : " + id);
        }
    }

    public List<Student> getStudnetsByYearOfEnrollment(String yearOfEnrollment) {
        return studentRepo.findByYearOfEnrollment(yearOfEnrollment);
    }

    public String getDepartmentById(String id) {
        Optional<Student> student = studentRepo.findById(id);
        if (student.isPresent()) {
            return student.get().getDepartment();
        } else {
            return "Cannot find the student";
        }

    }

    public boolean deleteStudentByYearOfEnrollment(String yearOfEnrollment) {
        studentRepo.deleteByYearOfEnrollment(yearOfEnrollment);
        return true;
    }

}

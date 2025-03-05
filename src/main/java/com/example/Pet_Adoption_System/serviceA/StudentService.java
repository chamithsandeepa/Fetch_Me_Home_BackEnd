package com.example.Pet_Adoption_System.serviceA;

import java.util.List;

import com.example.Pet_Adoption_System.Model.Student;

public interface StudentService {
    public Student saveStudent(Student student);

    public Student updateStudent(Student student, String id);

    public Student getStudentById(String id);

    public boolean DeleteStudent(String id);

    public List<Student> getStudnetsByYearOfEnrollment(String yearOfEnrollment);

    public String getDepartmentById(String id);

    public boolean deleteStudentByYearOfEnrollment(String yearOfEnrollment);
}

package com.example.Pet_Adoption_System.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Pet_Adoption_System.Model.Student;
import com.example.Pet_Adoption_System.serviceA.StudentService;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("api/students")
@CrossOrigin("*")
public class StudentController {

    @Autowired
    public StudentService studentService;

    @PostMapping("/addStudent")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.OK);
    }

    @PutMapping("upateStudent/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Student> updateStudent(@PathVariable String id, @RequestBody Student student) {
        return new ResponseEntity<>(studentService.updateStudent(student, id), HttpStatus.OK);
    }

    @GetMapping("getStudentById/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Student> getStudentByID(@PathVariable String id) {
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }

    @DeleteMapping("deleteStudent/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> DeleteStudent(@PathVariable String id) {
        if (studentService.DeleteStudent(id)) {
            return new ResponseEntity<>("Studnet id : " + id + " is deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot find the id number : ", HttpStatus.GONE);
        }

    }

    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    @GetMapping("/getStudentByYearOfEnrollment/{yearOfEnrollment}")
    public ResponseEntity<List<Student>> getStudentByYearOfEnrollment(@PathVariable String yearOfEnrollment) {
        return new ResponseEntity<>(studentService.getStudnetsByYearOfEnrollment(yearOfEnrollment), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    @GetMapping("/getDepartmentById/{id}")
    public ResponseEntity<String> getStudentById(@PathVariable String id) {
        return new ResponseEntity<>(studentService.getDepartmentById(id), HttpStatus.FOUND);

    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/deleteByYearOfEnrollment/{yearOfEnrollment}")
    public ResponseEntity<String> deleteStudnetByYEarOfEnrollment(@PathVariable String yearOfEnrollment) {
        if (studentService.deleteStudentByYearOfEnrollment(yearOfEnrollment)) {
            return new ResponseEntity<>("Deleted all students enrolled  : " + yearOfEnrollment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("cannot find any student enrolled in : " + yearOfEnrollment, HttpStatus.OK);
        }

    }

}


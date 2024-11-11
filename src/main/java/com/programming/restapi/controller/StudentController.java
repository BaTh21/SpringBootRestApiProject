package com.programming.restapi.controller;

import com.programming.restapi.entity.Student;
import com.programming.restapi.respository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentRepository repo;
    //get all the students
    //localhost:8080/students
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        List<Student> students = repo.findAll();
        return students;
    }

    //localhost:8080/students/1
    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id){
        Student student = repo.findById(id).get();
        return student;
    }

    //localhost:8080/students/add
    @PostMapping("/students/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createStudent(@RequestBody Student student){
        repo.save(student);
    }

    //localhost:8080/students/update/{id}
    @PutMapping("/students/update/{id}")
    public Student updateStudents(@PathVariable int id){
        Student student = repo.findById(id).get();
        student.setName("Panha");
        student.setPercentage(100);
        repo.save(student);
        return student;
    }

    //localhost:8080/students/delete/{id}
    @DeleteMapping ("/students/delete/{id}")
    public void removeStudent(@PathVariable int id){
        Student student = repo.findById(id).get();
        repo.delete(student);
    }
}

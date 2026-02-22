package com.example.learningRESTAPIs.controller;

import com.example.learningRESTAPIs.dto.StudentDto;
import com.example.learningRESTAPIs.entity.Student;
import com.example.learningRESTAPIs.repository.StudentRepository;
import com.example.learningRESTAPIs.service.StudentServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentServices studentServices;


    @GetMapping("/students")
    public List<StudentDto> getAllStudents(){
        return studentServices.getAllStudent();
    }
    @GetMapping("/students/{id}")
    public String getStudentById(@PathVariable Long id ){
        return studentServices.getStudentById();
}

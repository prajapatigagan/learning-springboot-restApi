package com.example.learningRESTAPIs.controller;

import com.example.learningRESTAPIs.dto.StudentDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/student")
    public StudentDto getStudent(){
        return new StudentDto(4L,"Gagan","gagan@gmail.com");
    }
}

package com.example.learningRESTAPIs.service;

import com.example.learningRESTAPIs.dto.StudentDto;
import java.util.List;

public interface StudentServices {
    List<StudentDto> getAllStudent();

    StudentDto getStudentById(Long id);
}

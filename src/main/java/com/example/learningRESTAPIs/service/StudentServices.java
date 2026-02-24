package com.example.learningRESTAPIs.service;

import com.example.learningRESTAPIs.dto.AddStudentRequestDto;
import com.example.learningRESTAPIs.dto.StudentDto;
import java.util.List;
import java.util.Map;

public interface StudentServices {


    List<StudentDto> getAllStudent();

    StudentDto getStudentById(Long id);

    StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto);


    void deleteStudentById(Long id);

    StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto);

    StudentDto updatePartialStudent(Long id, Map<String,Object> updates);
}
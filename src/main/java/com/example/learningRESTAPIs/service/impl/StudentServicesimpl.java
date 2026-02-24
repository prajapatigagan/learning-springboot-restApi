package com.example.learningRESTAPIs.service.impl;

import com.example.learningRESTAPIs.dto.AddStudentRequestDto;
import com.example.learningRESTAPIs.dto.StudentDto;
import com.example.learningRESTAPIs.entity.Student;
import com.example.learningRESTAPIs.repository.StudentRepository;
import com.example.learningRESTAPIs.service.StudentServices;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServicesimpl implements StudentServices {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDto> getAllStudent() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map(student ->modelMapper.map(student, StudentDto.class)).toList();

    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student= studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Student not found with id :" +id));
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto) {
        Student newStudent = modelMapper.map(addStudentRequestDto, Student.class);
        Student student = studentRepository.save(newStudent);
        return modelMapper.map(student,StudentDto.class);
    }
}

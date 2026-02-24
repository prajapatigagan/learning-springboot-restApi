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
import java.util.Map;
import java.util.function.BiConsumer;

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

    @Override
    public void deleteStudentById(Long id) {

        if (!studentRepository.existsById(id)) {
            throw new IllegalArgumentException("Student does not exist : " + id);
        }

        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto) {
        Student student= studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Student not found with id :" +id));
        modelMapper.map(addStudentRequestDto,student);
       student = studentRepository.save(student);
       return modelMapper.map(student,StudentDto.class);
    }



    @Override
    public StudentDto updatePartialStudent(Long id, Map<String, Object> updates) {
        Student student= studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Student not found with id :" +id));

        updates.forEach((field,value)->{
            switch(field){
                case "name":student.setName((String) value);
                break;
                case "email":student.setEmail((String) value);
                break;
                default:
                    throw new IllegalArgumentException("fireld is not supported");
            }
        });
        Student savedStudent = studentRepository.save(student);
        return modelMapper.map(savedStudent,StudentDto.class);
    }


}

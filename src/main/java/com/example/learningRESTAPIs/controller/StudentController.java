package com.example.learningRESTAPIs.controller;

import com.example.learningRESTAPIs.dto.AddStudentRequestDto;
import com.example.learningRESTAPIs.dto.StudentDto;
import com.example.learningRESTAPIs.entity.Student;
import com.example.learningRESTAPIs.repository.StudentRepository;
import com.example.learningRESTAPIs.service.StudentServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentServices studentServices;

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents(){
//        return ResponseEntity.status(HttpStatus.OK).body(studentServices.getAllStudent());
        return ResponseEntity.ok(studentServices.getAllStudent());
    }
    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id ){
        return ResponseEntity.ok(studentServices.getStudentById(id));
    }
    @PostMapping
    public ResponseEntity<StudentDto> createNewStudent(@RequestBody AddStudentRequestDto addStudentRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentServices.createNewStudent(addStudentRequestDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {

        studentServices.deleteStudentById(id);

        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id,@RequestBody AddStudentRequestDto addStudentRequestDto)
    {
        return ResponseEntity.ok(studentServices.updateStudent(id,addStudentRequestDto));
    }
}

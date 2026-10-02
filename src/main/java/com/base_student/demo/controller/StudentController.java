package com.base_student.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.base_student.demo.dto.StudentDto;
import com.base_student.demo.dto.StudentRsDto;
import com.base_student.demo.service.StudentService;

@Controller 
@RequestMapping(value = "/student")
public class StudentController {
    
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping    
    public ResponseEntity<?> findAll() {
        List<StudentDto> studentDtos = studentService.findAll();
        return new ResponseEntity<>(studentDtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody StudentDto studentdto){

        StudentRsDto  rsDto = studentService.create(studentdto);
        return new ResponseEntity<>(rsDto, HttpStatus.OK);
    }
}

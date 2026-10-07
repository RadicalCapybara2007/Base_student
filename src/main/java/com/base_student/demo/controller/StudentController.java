package com.base_student.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.base_student.demo.dto.StudentDto;
import com.base_student.demo.dto.StudentRsDto;
import com.base_student.demo.exception.BusinessException;
import com.base_student.demo.service.StudentService;
import com.base_student.demo.util.ValidationUtil;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;
    private final ValidationUtil validationUtil;

    public StudentController(StudentService studentService, ValidationUtil validationUtil) {
        this.studentService = studentService;
        this.validationUtil = validationUtil;
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.findAll());
    }

    @PostMapping
    public ResponseEntity<StudentRsDto> save(@RequestBody StudentDto studentDto) throws BusinessException {
        validationUtil.validate(studentDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentService.create(studentDto));
    }
}

package com.base_student.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.base_student.demo.dto.StudentDto;
import com.base_student.demo.model.StudentModel;
import com.base_student.demo.repository.StudentRepository;

@Service 
public class StudentService {
    
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    
    public List<StudentDto> findAll() {
        return studentRepository.findAll().stream().map(StudentModel::toDto).toList();
        
    }

}

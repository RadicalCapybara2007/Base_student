package com.base_student.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base_student.demo.model.StudentModel;

@Repository 
public interface StudentRepository extends JpaRepository<StudentModel, Integer> {
    
} 
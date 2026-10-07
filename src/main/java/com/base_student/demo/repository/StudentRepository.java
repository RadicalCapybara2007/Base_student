package com.base_student.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.base_student.demo.model.StudentModel;

public interface StudentRepository extends JpaRepository<StudentModel, Integer> {
} 
package com.base_student.demo.dto;

import com.base_student.demo.model.StudentModel;

public record StudentDto(Integer id, String name, String lastName, String phone, String email) {

    public StudentModel toModel() {
        return new StudentModel(id, name, lastName, phone, email);
    }
}


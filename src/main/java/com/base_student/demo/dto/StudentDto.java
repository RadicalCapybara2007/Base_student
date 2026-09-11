package com.base_student.demo.dto;

import com.base_student.demo.model.StudentModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tools.jackson.databind.ObjectMapper;

@Data
@Builder 
@NoArgsConstructor 
@AllArgsConstructor 

public class StudentDto {
    private Integer id;
    private String name;
    private String lastName;
    private String phone;
    private String email;

    public StudentModel toModel() {
    return StudentModel.builder()
    .id(this.id)
    .name(this.name)
    .lastName(this.lastName)
    .phone(this.phone)
    .email(this.email)
    .build();
    }

    @Override
    public String toString() {
        return new ObjectMapper().writeValueAsString(this);
    }
}


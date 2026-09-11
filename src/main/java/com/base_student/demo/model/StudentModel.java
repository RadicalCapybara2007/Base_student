package com.base_student.demo.model;

import com.base_student.demo.dto.StudentDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tools.jackson.databind.ObjectMapper;

@Data
@Builder 
@NoArgsConstructor 
@AllArgsConstructor 
@Entity
@Table(name = "student")

public class StudentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    @Column(name = "name", columnDefinition = "VARCHAR(80)")
    private String name;
    @Column(name = "last_name", columnDefinition = "VARCHAR(50)")
    private String lastName;
    @Column(name = "phone", columnDefinition = "VARCHAR(20)")
    private String phone;
    @Column(name = "email", columnDefinition = "VARCHAR(80)")
    private String email;

    // Getters and Setters

    public StudentDto toDto() {
        return StudentDto.builder()
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


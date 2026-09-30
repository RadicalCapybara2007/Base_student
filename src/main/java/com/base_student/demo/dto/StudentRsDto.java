package com.base_student.demo.dto;

import com.base_student.demo.model.StudentModel;

public record StudentRsDto (String message, Integer id){

    public StudentRsDto(String string, StudentModel id2) {
        this(string, id2 == null ? null : id2.getId());
    }
    
}

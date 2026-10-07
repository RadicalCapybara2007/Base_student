package com.base_student.demo.util;

import org.springframework.stereotype.Component;

import com.base_student.demo.dto.StudentDto;
import com.base_student.demo.exception.BusinessException;

@Component
public class ValidationUtil {

    public void validate(StudentDto studentDto) throws BusinessException {
        if (studentDto == null || studentDto.name() == null || studentDto.name().isBlank()) {
            throw new BusinessException("El nombre no debe estar vacío");
        }
        if (studentDto.lastName() == null || studentDto.lastName().isBlank()) {
            throw new BusinessException("El apellido no debe estar vacío");
        }
    }
}
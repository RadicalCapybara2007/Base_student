package com.base_student.demo.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;

import com.base_student.demo.dto.StudentDto;
import com.base_student.demo.exception.BusinessException;

class ValidationUtilTest {

    private final ValidationUtil validationUtil = new ValidationUtil();

    @Test
    void rejectsStudentWithoutName() {
        StudentDto student = new StudentDto(
                null, null, "Doe", "1234567890", "john.doe@example.com");

        assertThatThrownBy(() -> validationUtil.validate(student))
                .isInstanceOf(BusinessException.class)
                .hasMessage("El nombre no debe estar vacío");
    }

    @Test
    void rejectsStudentWithoutLastName() {
        StudentDto student = new StudentDto(
                null, "John", null, "1234567890", "john.doe@example.com");

        assertThatThrownBy(() -> validationUtil.validate(student))
                .isInstanceOf(BusinessException.class)
                .hasMessage("El apellido no debe estar vacío");
    }

    @Test
    void acceptsCompleteStudent() throws BusinessException {
        StudentDto student = new StudentDto(
                null, "John", "Doe", "1234567890", "john.doe@example.com");

        validationUtil.validate(student);
    }
}

package com.base_student.exception;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.base_student.dto.ErrorMessageDto;

class ExceptionHandlerTest {

    private final ExceptionHandler exceptionHandler = new ExceptionHandler();

    @Test
    void convertsBusinessExceptionToBadRequest() {
        BusinessException exception = new BusinessException("El nombre no debe estar vacío");

        ResponseEntity<ErrorMessageDto> response = exceptionHandler.businessExceptionHandler(exception);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(response.getBody()).isInstanceOf(ErrorMessageDto.class);
        ErrorMessageDto body = response.getBody();
        assertThat(body.getHttpStatus()).isEqualTo(HttpStatus.BAD_REQUEST.toString());
        assertThat(body.getMessage()).isEqualTo("El nombre no debe estar vacío");
    }

    @Test
    void convertsStudentNotFoundExceptionToNotFound() {
        StudentNotFoundException exception = new StudentNotFoundException(42);

        ResponseEntity<ErrorMessageDto> response =
                exceptionHandler.studentNotFoundExceptionHandler(exception);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(response.getBody().getHttpStatus()).isEqualTo(HttpStatus.NOT_FOUND.toString());
        assertThat(response.getBody().getMessage()).isEqualTo("Usuario no encontrado con id: 42");
    }
}

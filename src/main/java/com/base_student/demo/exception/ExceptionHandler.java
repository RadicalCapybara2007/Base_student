package com.base_student.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.base_student.demo.dto.ErrorMessageDto;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorMessageDto> businessExceptionHandler(BusinessException businessException) {
        ErrorMessageDto errorMessageDto = new ErrorMessageDto(
                HttpStatus.BAD_REQUEST.toString(),
                businessException.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessageDto);
    }
}
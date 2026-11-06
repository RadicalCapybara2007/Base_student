package com.base_student.dto;

public record ErrorMessageDto(String message, String httpStatus) {

    public String getMessage() {
        return message;
    }

    public String getHttpStatus() {
        return httpStatus;
    }
}
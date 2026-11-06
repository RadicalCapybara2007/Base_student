package com.base_student.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(Integer id) {
        super("Usuario no encontrado con id: " + id);
    }
}

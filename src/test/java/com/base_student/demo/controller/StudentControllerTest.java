package com.base_student.demo.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.base_student.demo.dto.StudentDto;
import com.base_student.demo.dto.StudentRsDto;
import com.base_student.demo.service.StudentService;
import com.base_student.demo.util.ValidationUtil;

class StudentControllerTest {

    @Mock
    private StudentService studentService;

    @Mock
    private ValidationUtil validationUtil;

    private StudentController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        controller = new StudentController(studentService, validationUtil);
    }

    @Test
    void returnsAllStudents() {
        StudentDto student = new StudentDto(
                1, "John", "Doe", "1234567890", "john.doe@example.com");
        when(studentService.findAll()).thenReturn(List.of(student));

        ResponseEntity<?> response = controller.findAll();

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(List.of(student));
        verify(studentService).findAll();
    }

    @Test
    void createsStudent() throws Exception {
        StudentDto student = new StudentDto(
                null, "John", "Doe", "1234567890", "john.doe@example.com");
        StudentRsDto created = new StudentRsDto("Student added", 1);
        when(studentService.create(student)).thenReturn(created);

        ResponseEntity<StudentRsDto> response = controller.save(student);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isEqualTo(created);
        verify(validationUtil).validate(student);
        verify(studentService).create(student);
    }
}

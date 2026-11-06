package com.base_student.service;// Ajusta esto al paquete real de tu proyecto

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.base_student.dto.StudentDto;
import com.base_student.dto.StudentRsDto;
import com.base_student.model.StudentModel;
import com.base_student.repository.StudentRepository;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    public void testFindAll() {
        // 1. Preparar el entorno (Arrange)
        StudentModel s1 = new StudentModel(1, "Juan", "Pérez", "555-1234", "juan@example.com");
        StudentModel s2 = new StudentModel(2, "María", "Gómez", "555-5678", "maria@example.com");

        when(studentRepository.findAll()).thenReturn(Arrays.asList(s1, s2));

        // 2. Ejecutar el servicio (Act)
        List<StudentDto> resultado = studentService.findAll();

        // 3. Validar (Assert)
        assertThat(resultado).isNotNull();
        assertThat(resultado.size()).isEqualTo(2);
        assertThat(resultado.get(0).name()).isEqualTo("Juan");
        
        // Verificar que el repositorio fue llamado exactamente una vez
        verify(studentRepository, times(1)).findAll();
    }

    @Test
    public void testCreate() {
        // 1. Preparar el entorno (Arrange)
        StudentDto nuevoEstudianteDto = new StudentDto(null, "Ana", "Torres", "555-0000", "ana@example.com");
        StudentModel estudianteGuardado = new StudentModel(3, "Ana", "Torres", "555-0000", "ana@example.com");

        when(studentRepository.save(any(StudentModel.class))).thenReturn(estudianteGuardado);
        
        // 2. Ejecutar el servicio (Act)
        StudentRsDto resultado = studentService.create(nuevoEstudianteDto);

        // 3. Validar (Assert)
        assertThat(resultado).isNotNull();
        assertThat(resultado.id()).isEqualTo(3);
        assertThat(resultado.message()).isEqualTo("Student added");

        // Verificar que el método save() del repositorio se ejecutó una vez
        verify(studentRepository, times(1)).save(any(StudentModel.class));
    }
}
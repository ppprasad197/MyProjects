package com.junitandmockito.poc.Service;

import com.junitandmockito.poc.Entity.Student;
import com.junitandmockito.poc.Repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockMultipartFile;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class StudentServiceTest {

    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    public StudentServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getById_shouldReturnStudent() {
        Student student = new Student(1L, "Prasad");
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));

        Optional<Student> result = studentService.findById(1L);

        assertTrue(result.isPresent(), "Student not found against asked student id");
        assertEquals("Prasad", result.get().getName());

        verify(studentRepository).findById(1L);
    }


    @Test
    void testValidFile() {
        MockMultipartFile file = new MockMultipartFile(
                "file", "test.png", "image/png", "data".getBytes()
        );

        String result = studentService.handleFile(file);

        assertEquals("File uploaded: test.png", result);
    }

    @Test
    void testInvalidFile() {
        MockMultipartFile file = new MockMultipartFile(
                "file", "test.txt", "text/plain", "data".getBytes()
        );

        assertThrows(RuntimeException.class, () -> studentService.handleFile(file));
    }
}
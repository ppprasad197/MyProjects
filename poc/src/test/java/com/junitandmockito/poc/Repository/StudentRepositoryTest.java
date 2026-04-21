package com.junitandmockito.poc.Repository;

import com.junitandmockito.poc.Entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DataJpaTest
@Rollback(false)
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void getStudentById_shouldReturnStudent() {

        Student student = new Student(1L, "Prasad");
        studentRepository.save(student);

        Optional<Student> optionalStudent = studentRepository.findById(1L);

        assertTrue(optionalStudent.isPresent());
//        assertFalse(optionalStudent.isPresent()); //This is wrong as optional is null as no student present against id 10
        assertEquals("Prasad", optionalStudent.get().getName());
//        assertTrue(optionalStudent.isEmpty());
    }


}
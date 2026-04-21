package com.junitandmockito.poc.Controller;

import com.junitandmockito.poc.Entity.Student;
import com.junitandmockito.poc.Service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StudentController.class)
class StudentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    StudentService studentService;

    @Test
    public void getStudentById_shouldReturnStudent() throws Exception {
        Student student = new Student(1L, "Prasad");
//        when(studentService.findById(1L)).thenReturn(Optional.of(student));

//        mockMvc.perform(get("/students/1"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name").value("Prasad"));
//
//        verify(studentService).findById(1L);

//        when(studentService.save(student)).thenReturn(student);//This will not work because both calling servince save but differently

        when(studentService.save(any(Student.class))).thenReturn(student);
        mockMvc.perform(post("/students")
                        .contentType("application/json")
                        .content("{\"id\":1,\"name\":\"Prasad\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Prasad"));
        verify(studentService).save(any(Student.class));
    }


    @Test
    void testFileUpload() throws Exception {
        MockMultipartFile file = new MockMultipartFile(
                "file",
                "test.png",
                "text/png",
                "dummy content".getBytes()
        );

        when(studentService.handleFile(any())).thenReturn("File uploaded: test.png");

//        mockMvc.perform(post("/students/upload")
//                        .contentType(MediaType.ALL_VALUE)
//                        .content(file))
//                .andExpect(status().isOk())
//                .andExpect(content().string("File uploaded: test.png"));

        mockMvc.perform(multipart("/students/upload")
                        .file(file))
                .andExpect(status().isOk())
                .andExpect(content().string("File uploaded: test.png"));

        verify(studentService).handleFile(any());
    }
}
package com.junitandmockito.poc.Controller;

import com.junitandmockito.poc.Service.StudentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
@Sql("/sql/data-student.sql")
public class ControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    StudentService studentService;

    @Test
    public void testGetStudentById() throws Exception {
        mockMvc.perform(get("/students/10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Prasad"));
    }

    @Test
    public void testCreateStudent() throws Exception {
        mockMvc.perform(post("/students")
                        .contentType("application/json")
                        .content("{\"id\":3,\"name\":\"Kalpesh\"}"))
                .andExpect(status().isOk());
//                .andExpect(status().isCreated());
    }

    @Test
    public void fileUploadTest() throws Exception {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("assets/jack.png");
        assertNotNull(inputStream);

        MockMultipartFile file = new MockMultipartFile("file",
                "jack.png",
                "image/jpg",
                inputStream);

        mockMvc.perform(multipart("/students/upload")
                        .file(file))
                .andExpect(status().isOk())
                .andExpect(content().string(("File uploaded : jack.png")));

    }
}

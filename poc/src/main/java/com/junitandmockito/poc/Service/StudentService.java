package com.junitandmockito.poc.Service;

import com.junitandmockito.poc.Entity.Student;
import com.junitandmockito.poc.Repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public String handleFile(MultipartFile file) {

        if (file.isEmpty()) {
            throw new RuntimeException("File is empty");
        }

        String fileName = file.getOriginalFilename();

        // you can add validation
        if (fileName.endsWith(".png") || fileName.endsWith(".jpg") || fileName.endsWith(".xlsx")) {
            System.out.println("filename : " + fileName);
            return "File uploaded: " + fileName;
        }

        throw new RuntimeException("Invalid file type");
    }

}

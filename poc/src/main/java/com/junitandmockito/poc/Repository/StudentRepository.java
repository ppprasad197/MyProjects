package com.junitandmockito.poc.Repository;

import com.junitandmockito.poc.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}

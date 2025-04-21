package com.chirp.registration.repository;

import com.chirp.registration.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent()
    {
        Student student = Student.builder()
                .studentRegistrationNumber("R2")
                .studentName("Student In JPA Repo")
                .studentGender("Gender In JPA Repo")
                .build();

        studentRepository.save(student);
    }
    
    @Test
    public void diplayAllStudents()
    {
        List<Student> students = studentRepository.findAll();

        System.out.println("students = " + students);
    }
}
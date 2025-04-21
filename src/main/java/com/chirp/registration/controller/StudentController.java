package com.chirp.registration.controller;

import com.chirp.registration.model.Student;
import com.chirp.registration.controller.StudentAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController
{
    private final StudentAPIService studentAPIService;

    @Autowired
    public StudentController(StudentAPIService studentAPIService)
    {
        this.studentAPIService = studentAPIService;
    }

    @GetMapping("")
    public List<com.chirp.registration.entity.Student> getAllStudentDetails()
    {
        return studentAPIService.getAllStudentDetails();
    }

    @GetMapping("{studentRegistrationNumber}")
    public Student getStudentDetails(@PathVariable String studentRegistrationNumber)
    {
        return studentAPIService.getStudentDetails( studentRegistrationNumber );
    }

    @GetMapping("{studentRegistrationNumber}/{studentName}")
    public List<Student> getStudentDetailsByRegistrationNumberOrByName(@PathVariable String studentRegistrationNumber, @PathVariable String studentName)
    {
        return studentAPIService.getStudentDetailsByRegistrationNumberOrByName( studentRegistrationNumber, studentName );
    }

    @PostMapping("/add")
    public String saveNewStudent(@RequestBody com.chirp.registration.entity.Student student)
    {
        System.out.println("\n\nNew student = " + student);
        studentAPIService.saveNewStudent(student);

        return "{\"status\":\"added student successfully\"}";
    }


}

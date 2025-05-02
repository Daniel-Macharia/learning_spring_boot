package com.chirp.registration.controller;

import com.chirp.registration.controller.StudentAPIService;
import com.chirp.registration.entity.Student;
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
        List<Student> students = new ArrayList<>();
        try{
            students = studentAPIService.getAllStudentDetails();
        }catch (Exception e) {
            students.add( Student.builder().studentName("{\n\"status\":\"failed\"\n\"reason\":\"" + e + "\"\n}").build() );
            return students;
        }
        return students;
    }

    @GetMapping("{studentRegistrationNumber}")
    public com.chirp.registration.entity.Student getStudentDetails(@PathVariable String studentRegistrationNumber)
    {
        Student student;
        try{
            student = studentAPIService.getStudentDetailsByRegistrationNumber( studentRegistrationNumber );
        }catch (Exception e) {
            return Student.builder().studentName("{\n\"status\":\"failed\"\n\"reason\":\"" + e + "\"\n}").build();
        }
        return student;
    }

    @GetMapping("{studentRegistrationNumber}/{studentName}")
    public List<Student> getStudentDetailsByRegistrationNumberOrByName(@PathVariable String studentRegistrationNumber, @PathVariable String studentName)
    {
        List<Student> students = new ArrayList<>();
        try{
            students = studentAPIService.getStudentDetailsByRegistrationNumberOrByName( studentRegistrationNumber, studentName );
        }catch (Exception e) {
            students.add( Student.builder().studentName("{\n\"status\":\"failed\"\n\"reason\":\"" + e + "\"\n}").build() );
            return students;
        }
        return students;
    }

    @PostMapping("/add")
    public String saveNewStudent(@RequestBody com.chirp.registration.entity.Student student)
    {
        try{
            System.out.println("student = " + student);
            studentAPIService.saveNewStudent(student);
        } catch (Exception e) {
            return "{\n\"status\":\"failed\"\n\"reason\":\"" + e + "\"\n}";
        }

        return "{\n\"status\":\"added student successfully\"\n}";
    }


    @PutMapping("/update/{studentRegistrationNumber}")
    public String updateStudent(@PathVariable String studentRegistrationNumber, @RequestBody Student student)
    {
        try{
            System.out.println("student = " + student);
            studentAPIService.updateStudentName( student.getStudentRegistrationNumber(), student);
        }catch (Exception e) {
            return "{\n\"status\":\"failed\"\n\"reason\":\"" + e + "\"\n}";
        }

        return "{\n\"status\":\"student updated successfully\"\n}";
    }

    @DeleteMapping("/delete/{studentRegistrationNumber}")
    public String deleteStudent(@PathVariable String studentRegistrationNumber)
    {
        try{
            studentAPIService.deleteStudent(studentRegistrationNumber);
        }catch (Exception e) {
            return "{\n\"status\":\"failed\"\n\"reason\":\"" + e + "\"\n}";
        }
        return "{\n\"status\":\"Student successfully deleted\"\n}";
    }


}

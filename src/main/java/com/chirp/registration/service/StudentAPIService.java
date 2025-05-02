package com.chirp.registration.controller;

import com.chirp.registration.model.Student;
import com.chirp.registration.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentAPIService
{
    private List<Student> students = new ArrayList<>();

    @Autowired
    private StudentRepository studentRepository;

    public StudentAPIService()
    {
//        for( int i = 1; i <= 5; i++ )
//        {
//            students.add( new Student("r" + i, "Name " + i, (i % 2 == 0) ? "Male" : "Female") );
//        }
    }

    public List<com.chirp.registration.entity.Student> getAllStudentDetails()
    {
        return studentRepository.findAll();//students;
    }


    public com.chirp.registration.entity.Student getStudentDetailsByRegistrationNumber(String studentRegistrationNumber)
    {
        return studentRepository.getStudentByStudentRegistrationNumber(
                studentRegistrationNumber
        );
    }

    public List<com.chirp.registration.entity.Student> getStudentDetailsByRegistrationNumberOrByName(String studentRegistrationNumber, String studentName)
    {
        return studentRepository.getStudentByStudentRegistrationNumberOrStudentName(
                studentRegistrationNumber,
                studentName
        );
    }

    public void saveNewStudent(com.chirp.registration.entity.Student student)
    {
        studentRepository.save(student);
    }

    public void updateStudentName( String studentRegistrationNumber, com.chirp.registration.entity.Student student)
    {
        studentRepository.updateStudentName( studentRegistrationNumber, student.getStudentName());
    }

    public void deleteStudent( String studentRegistrationNumber )
    {
        studentRepository.deleteStudentByStudentRegistrationNumber( studentRegistrationNumber );
    }

}

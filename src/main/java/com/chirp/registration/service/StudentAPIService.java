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
        for( int i = 1; i <= 5; i++ )
        {
            students.add( new Student("r" + i, "Name " + i, (i % 2 == 0) ? "Male" : "Female") );
        }
    }

    public List<com.chirp.registration.entity.Student> getAllStudentDetails()
    {
        return studentRepository.findAll();//students;
    }


    public Student getStudentDetails(String studentRegistrationNumber)
    {
        Student s = new Student();
        System.out.println("\nReg. NO: " + studentRegistrationNumber + "\n");

        for( Student student : students )
        {
            if( student.getStudentRegistrationNumber().equals( studentRegistrationNumber ) )
            {
                s.setStudentRegistrationNumber( new String( student.getStudentRegistrationNumber() ) );
                s.setStudentName( new String(student.getStudentName() ) );
                s.setStudentGender( new String( student.getStudentGender() ) );
                break;
            }
        }

        return s;
    }

    public List<Student> getStudentDetailsByRegistrationNumberOrByName( String studentRegistrationNumber, String studentName)
    {
        List<Student> studentList = new ArrayList<>();
        System.out.println("\nReg. NO: " + studentRegistrationNumber + "\n");

        for( Student student : students )
        {
            if( student.getStudentRegistrationNumber().equals( studentRegistrationNumber )
                    || student.getStudentName().equals( studentName ) )
            {
                studentList.add(new Student( new String( student.getStudentRegistrationNumber() ),
                        new String(student.getStudentName() ),
                        new String( student.getStudentGender() ) ));
            }
        }

        return studentList;
    }

    public void saveNewStudent(com.chirp.registration.entity.Student student)
    {
        studentRepository.save(student);
    }

}

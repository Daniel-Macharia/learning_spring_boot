package com.chirp.registration.model;

public class Student {

    private String studentRegistrationNumber;
    private String studentName;
    private String studentGender;

    public Student()
    {
        //default constructor
    }

    public Student(String studentRegistrationNumber, String studentName, String studentGender) {
        this.studentRegistrationNumber = studentRegistrationNumber;
        this.studentName = studentName;
        this.studentGender = studentGender;
    }

    public String getStudentRegistrationNumber() {
        return studentRegistrationNumber;
    }

    public void setStudentRegistrationNumber(String studentRegistrationNumber) {
        this.studentRegistrationNumber = studentRegistrationNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }
}

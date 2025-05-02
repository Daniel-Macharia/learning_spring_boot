package com.chirp.registration.repository;

import com.chirp.registration.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> getStudentByStudentRegistrationNumberOrStudentName(
            String studentRegistrationNumber,
            String studentName);

    public Student getStudentByStudentRegistrationNumber(String studentRegistrationNumber);

    //use JPQL native query
    /*
    Entity name and entity attribute names should
    match the database implementation entity and attribute names
    */
    @Modifying
    @Transactional
    @NativeQuery(
            value = "UPDATE student SET student_name = :name " +
                    "WHERE reg_number = :reg"

    )
    public int updateStudentName(
            @Param("reg") String studentRegistrationNumber,
            @Param("name") String newStudentName);

    //use JQL
    /*
    entity name and entity attribute names should
    match the ones defined in the entity model class in java
    */
    @Modifying
    @Transactional
    @NativeQuery(
            "DELETE FROM Student WHERE reg_number = :reg OR student_id = :reg"
    )
    public int deleteStudentByStudentRegistrationNumber( @Param("reg") String registrationNumber);
}

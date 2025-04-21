package com.chirp.registration.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name="student",
        uniqueConstraints = @UniqueConstraint(
                name = "reg_number_unique",
                columnNames = "reg_number"
        )
) //used to specify name of table to be created for this class
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long studentId;

    @Column( name = "reg_number", nullable = false)
    private String studentRegistrationNumber;
    //@Column(name="student_name") //specify the name to give to the column for this attribute in the database
    private String studentName;
    private String studentGender;
}

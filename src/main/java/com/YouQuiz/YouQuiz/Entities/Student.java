package com.YouQuiz.YouQuiz.Entities;

    
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;


@Table(name="student")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Inheritance
//@Inheritance(strategy = InheritanceType.JOINED)
public class Student extends Person{

    @Id
    @GeneratedValue
    private Long student_id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate registrationDate;
    @OneToMany(mappedBy = "student")
    private List<AssignQuiz> assignQuizs;
}

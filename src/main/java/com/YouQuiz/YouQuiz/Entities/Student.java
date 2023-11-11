package com.YouQuiz.YouQuiz.Entities;

    
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
public class Student extends Person{
    @Id
    @GeneratedValue
    private Long student_id;
    @NonNull
    private LocalDate registrationDate;
    @OneToMany(mappedBy = "student")
    private List<AssignQuiz> assignQuizs;

}

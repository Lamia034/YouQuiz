package com.YouQuiz.YouQuiz.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Table(name="formator")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Inheritance
//@Inheritance(strategy = InheritanceType.JOINED)

public class Formator extends Person{

    @Id
    @GeneratedValue
    private Long formator_id;

    private String speciality;
    @OneToMany(mappedBy = "formator", fetch = FetchType.EAGER)
    private List<Quiz> quizs;
}

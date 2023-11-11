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
public class Formator extends Person{

    @Id
    @GeneratedValue
    private Long person_id;
    @NonNull
    private String specialty;
    @OneToMany(mappedBy = "formator")
    private List<Quiz> quizs;
}

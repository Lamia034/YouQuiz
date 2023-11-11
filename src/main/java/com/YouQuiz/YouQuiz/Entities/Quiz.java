package com.YouQuiz.YouQuiz.Entities;
    
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity

@Table(name="quiz")
@NoArgsConstructor
@AllArgsConstructor

public class Quiz {
    @Id
    @GeneratedValue
    private Long quiz_id;
    
    @ManyToOne
    @JoinColumn(name="formator_id")
    private Formator formator;
    
    @ManyToMany(mappedBy = "quizs")
    private List<Question> questions;
    @OneToMany(mappedBy = "quiz")
    private List<AssignQuiz> assignQuizs;

    private int successScore;
    private boolean viewAnswers;
    private boolean viewResult;
    private int maxAttempts;
    private String remarks;
    private String instructions;

}

package com.YouQuiz.YouQuiz.DTOs;

import com.YouQuiz.YouQuiz.Entities.Formator;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizDto {

    private Long quiz_id;


    private Long formator_id;
    private int successScore;
    private boolean viewAnswers;
    private boolean viewResult;
    private int maxAttempts;
    private String remarks;
    private String instructions;
}

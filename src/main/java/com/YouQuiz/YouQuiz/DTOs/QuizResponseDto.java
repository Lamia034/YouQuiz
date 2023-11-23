package com.YouQuiz.YouQuiz.DTOs;

import com.YouQuiz.YouQuiz.Entities.AssignQuiz;
import com.YouQuiz.YouQuiz.Entities.Formator;
import com.YouQuiz.YouQuiz.Entities.Question;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizResponseDto {
    private Long quiz_id;


    private FormatorDto formator;
    private int successScore;
    private boolean viewAnswers;
    private boolean viewResult;
    private int maxAttempts;
    private String remarks;
    private String instructions;

    private List<QuestionDto> questions;

    private List<AssignQuizDto> assignQuizs;
}

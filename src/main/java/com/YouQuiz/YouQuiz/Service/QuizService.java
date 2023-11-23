package com.YouQuiz.YouQuiz.Service;

import com.YouQuiz.YouQuiz.DTOs.AnswerDto;
import com.YouQuiz.YouQuiz.DTOs.AnswerResponseDto;
import com.YouQuiz.YouQuiz.DTOs.QuizDto;
import com.YouQuiz.YouQuiz.DTOs.QuizResponseDto;

import java.util.List;

public interface QuizService {
    List<QuizResponseDto> getAllQuizs();
    QuizDto createQuiz(QuizDto quizDto);
    boolean deleteQuiz(Long quizId);
    QuizResponseDto updateQuiz(Long quizId, QuizDto updatedQuiz);
}

package com.YouQuiz.YouQuiz.Service;

import com.YouQuiz.YouQuiz.DTOs.AnswerDto;
import com.YouQuiz.YouQuiz.DTOs.AnswerResponseDto;
import com.YouQuiz.YouQuiz.DTOs.AssignQuizDto;
import com.YouQuiz.YouQuiz.DTOs.AssignQuizResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AssignQuizService {
    List<AssignQuizResponseDto> getAllAssignQuizs();
    AssignQuizDto createAssignQuiz(AssignQuizDto assignQuizDto);
    boolean deleteAssignQuiz(Long assignQuizId);
    AssignQuizResponseDto updateAssignQuiz(Long assignQuizId, AssignQuizDto updatedAssignQuiz);
}

package com.YouQuiz.YouQuiz.Service;

import com.YouQuiz.YouQuiz.DTOs.AnswerDto;
import com.YouQuiz.YouQuiz.DTOs.AnswerResponseDto;
import com.YouQuiz.YouQuiz.DTOs.FormatorDto;
import com.YouQuiz.YouQuiz.DTOs.FormatorResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface FormatorService {
    List<FormatorResponseDto> getAllFormators();
    FormatorDto createFormator(FormatorDto formatorDto);
    boolean deleteFormator(Long formatorId);
//    FormatorResponseDto updateFormator(Long formatorId, FormatorDto updatedFormator);
}

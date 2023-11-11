package com.YouQuiz.YouQuiz.Mappers;

import com.YouQuiz.YouQuiz.DTOs.AnswerDto;
import com.YouQuiz.YouQuiz.Entities.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
public interface AnswerMapper {
    AnswerDto toDto(Answer answer);
    Answer toEntity(AnswerDto answerDto);
}

//@Mapper
//public interface AnswerMapper {
//    AnswerDto toDto(Answer answer);
//    Answer toEntity(AnswerDto answerDto);
//}


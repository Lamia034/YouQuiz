package com.YouQuiz.YouQuiz.Mappers;

import com.YouQuiz.YouQuiz.DTOs.QuestionDto;
import com.YouQuiz.YouQuiz.DTOs.SubjectDto;
import com.YouQuiz.YouQuiz.Entities.Question;
import com.YouQuiz.YouQuiz.Entities.Subject;
import org.mapstruct.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class QuestionMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public QuestionMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public QuestionDto convertToDto(Question question) {
        return modelMapper.map(question, QuestionDto.class);
    }

    public Question convertToEntity(QuestionDto questionDto) {
        return modelMapper.map(questionDto, Question.class);
    }
}

//@Mapper
//public interface AnswerMapper {
//    AnswerDto toDto(Answer answer);
//    Answer toEntity(AnswerDto answerDto);
//}


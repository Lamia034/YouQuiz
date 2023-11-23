package com.YouQuiz.YouQuiz.Mappers;

import com.YouQuiz.YouQuiz.DTOs.SubjectDto;
import com.YouQuiz.YouQuiz.Entities.Subject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubjectMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public SubjectMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public SubjectDto convertToDto(Subject subject) {
        return modelMapper.map(subject, SubjectDto.class);
    }

    public Subject convertToEntity(SubjectDto subjectDto) {
        return modelMapper.map(subjectDto, Subject.class);
    }
}

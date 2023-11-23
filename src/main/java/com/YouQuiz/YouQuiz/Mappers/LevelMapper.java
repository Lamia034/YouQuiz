package com.YouQuiz.YouQuiz.Mappers;

import com.YouQuiz.YouQuiz.DTOs.LevelDto;
import com.YouQuiz.YouQuiz.DTOs.QuestionDto;
import com.YouQuiz.YouQuiz.Entities.Level;
import com.YouQuiz.YouQuiz.Entities.Question;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LevelMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public LevelMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public LevelDto convertToDto(Level level) {
        return modelMapper.map(level, LevelDto.class);
    }

    public Level convertToEntity(LevelDto levelDto) {
        return modelMapper.map(levelDto, Level.class);
    }

}

package com.YouQuiz.YouQuiz.Mappers;

import com.YouQuiz.YouQuiz.DTOs.LevelDto;
import com.YouQuiz.YouQuiz.DTOs.PointDto;
import com.YouQuiz.YouQuiz.Entities.Level;
import com.YouQuiz.YouQuiz.Entities.Point;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

//@Mapper
//public interface PointMapper {
//    PointMapper INSTANCE = Mappers.getMapper(PointMapper.class);
//
//    @Mapping(source = "question.question_id", target = "question_id")
//    @Mapping(source = "answer.answer_id", target = "answer_id")
//    PointDto pointToDto(Point point);
//}

//@Component
//public class PointMapper {
//    private final ModelMapper modelMapper;
//
//    @Autowired
//    public PointMapper(ModelMapper modelMapper){
//        this.modelMapper = modelMapper;
//    }
//
//    public PointDto convertToDto(Point point) {
//        return modelMapper.map(point, PointDto.class);
//    }
//
//    public Point convertToEntity(PointDto pointDto) {
//        return modelMapper.map(pointDto, Point.class);
//    }
//}

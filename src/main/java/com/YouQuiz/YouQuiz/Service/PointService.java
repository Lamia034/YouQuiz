package com.YouQuiz.YouQuiz.Service;

import com.YouQuiz.YouQuiz.DTOs.*;
import com.YouQuiz.YouQuiz.Entities.Answer;
import com.YouQuiz.YouQuiz.Entities.Level;
import com.YouQuiz.YouQuiz.Entities.Point;
import com.YouQuiz.YouQuiz.Entities.Question;
//import com.YouQuiz.YouQuiz.Mappers.PointMapper;
import com.YouQuiz.YouQuiz.Repositories.PointRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


public interface PointService {
    List<PointResponseDto> getAllPoints();
    PointDto createPoint(PointDto pointDto);
    boolean deletePoint(Long pointId);
    PointResponseDto updatePoint(Long pointId, PointDto updatedPoint);
}
//    private final PointRepository pointRepository;
//   // private final PointMapper pointMapper;
//    private final ModelMapper modelMapper;
//    @Autowired
//    public PointService(PointRepository pointRepository , ModelMapper modelMapper){
//        this.pointRepository = pointRepository;
//       // this.pointMapper = pointMapper;
//        this.modelMapper = modelMapper;
//    }
//    @Transactional
//    public PointDto createPoint(PointDto pointDto) {
//        Point point = modelMapper.map(pointDto, Point.class);
//        Point savedPoint = pointRepository.save(point);
//        return modelMapper.map(savedPoint, PointDto.class);
//    }
//
//    @Transactional
//    public List<PointDto> getAllPoints() {
//        List<Point> points = pointRepository.findAll();
//        return points.stream()
//                .map(point -> modelMapper.map(point, PointDto.class))
//                .collect(Collectors.toList());
//    }
//    @Transactional
//    public PointDto getPointById(Long pointId) {
//        Point point = pointRepository.findById(pointId)
//                .orElseThrow(() -> new EntityNotFoundException("Point not found with id: " + pointId));
//        return modelMapper.map(point, PointDto.class);
//    }
//    public List<PointDto> getAllPoints() {
//        List<Point> points = pointRepository.findAll();
//        return points.stream()
//                .map(pointMapper::convertToDto)
//                .collect(Collectors.toList());
//    }


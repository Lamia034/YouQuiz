package com.YouQuiz.YouQuiz.Service.Impl;

import com.YouQuiz.YouQuiz.DTOs.*;
import com.YouQuiz.YouQuiz.Entities.*;
import com.YouQuiz.YouQuiz.Repositories.AnswerRepository;
import com.YouQuiz.YouQuiz.Repositories.PointRepository;
import com.YouQuiz.YouQuiz.Repositories.QuestionRepository;
import com.YouQuiz.YouQuiz.Service.PointService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class PointServiceImpl implements PointService {
    private final PointRepository pointRepository;
    private final ModelMapper modelMapper;
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;

    public PointServiceImpl(PointRepository pointRepository, ModelMapper modelMapper, AnswerRepository answerRepository,QuestionRepository questionRepository) {
        this.pointRepository = pointRepository;
        this.modelMapper = modelMapper;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    @Transactional
    public List<PointResponseDto> getAllPoints() {
        List<Point> points = pointRepository.findAll();
        return points.stream()
                .map(point -> modelMapper.map(point, PointResponseDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public PointDto createPoint(PointDto pointDto) {
        Point point = modelMapper.map(pointDto, Point.class);
        Point savedPoint = pointRepository.save(point);
        return modelMapper.map(savedPoint, PointDto.class);
    }

    @Transactional
    public boolean deletePoint(Long pointId) {
        Optional<Point> optionalPoint = pointRepository.findById(pointId);

        if (optionalPoint.isPresent()) {
            pointRepository.delete(optionalPoint.get());
            return true;
        } else {
            return false;
        }
    }
    @Transactional
    public PointResponseDto updatePoint(Long pointId, PointDto updatedPointDto) {
        Point existingPoint = pointRepository.findById(pointId)
                .orElseThrow(() -> new EntityNotFoundException("Point not found with id: " + pointId));

        existingPoint.setPoint(updatedPointDto.getPoint());

        if (updatedPointDto.getAnswer_id() != null) {
            Answer answer = answerRepository.findById(updatedPointDto.getAnswer_id())
                    .orElseThrow(() -> new EntityNotFoundException("Answer not found with id: " + updatedPointDto.getAnswer_id()));
            existingPoint.setAnswer(answer);
        }

        if (updatedPointDto.getQuestion_id() != null) {
            Question question = questionRepository.findById(updatedPointDto.getQuestion_id())
                    .orElseThrow(() -> new EntityNotFoundException("Question not found with id: " + updatedPointDto.getQuestion_id()));
            existingPoint.setQuestion(question);
        }

        return modelMapper.map(pointRepository.save(existingPoint), PointResponseDto.class);
    }
}

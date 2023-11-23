package com.YouQuiz.YouQuiz.Service.Impl;

import com.YouQuiz.YouQuiz.DTOs.*;
import com.YouQuiz.YouQuiz.Entities.Answer;
import com.YouQuiz.YouQuiz.Entities.Student;
import com.YouQuiz.YouQuiz.Entities.Subject;
import com.YouQuiz.YouQuiz.Mappers.MappingConfig;
import com.YouQuiz.YouQuiz.Repositories.AnswerRepository;
import com.YouQuiz.YouQuiz.Service.AnswerService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnswerServiceImpl implements AnswerService {
    private final AnswerRepository answerRepository;
    private final ModelMapper modelMapper;

    public AnswerServiceImpl(AnswerRepository answerRepository, ModelMapper modelMapper) {
        this.answerRepository = answerRepository;
        this.modelMapper = modelMapper;
    }

//    @Transactional
//    public List<AnswerResponseDto> getAllAnswers() {
//        List<Answer> answers = answerRepository.findAll();
//        return answers.stream()
//                .map(answer -> modelMapper.map(answer, AnswerResponseDto.class))
//                .collect(Collectors.toList());
//    }

//        @Transactional
//        public AnswerDto createAnswer(AnswerDto answerDto) {
//        Answer answer = modelMapper.map(answerDto, Answer.class);
//        Answer savedAnswer = answerRepository.save(answer);
//        return modelMapper.map(savedAnswer, AnswerDto.class);
//    }
@Override
@Transactional
public AnswerDto createAnswer(AnswerDto answerDto) {
    try {
        Answer answer = modelMapper.map(answerDto, Answer.class);
        Answer savedAnswer = answerRepository.save(answer);
        return modelMapper.map(savedAnswer, AnswerDto.class);
    } catch (Exception e) {

        throw new RuntimeException("Failed to create answer: " + e.getMessage());
    }
}

    @Override
    @Transactional
    public List<AnswerResponseDto> getAllAnswers() {
        List<Answer> answers = answerRepository.findAll();
        return answers.stream()
                .map(answer -> modelMapper.map(answer, AnswerResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public boolean deleteAnswer(Long answerId) {
        Optional<Answer> optionalAnswer = answerRepository.findById(answerId);
        if (optionalAnswer.isPresent()) {
            answerRepository.delete(optionalAnswer.get());
            return true;
        } else {
            throw new RuntimeException("Answer not found");
        }
    }

    @Override
    @Transactional
    public AnswerResponseDto updateAnswer(Long answerId, AnswerDto updatedAnswerDto) {
        Optional<Answer> optionalAnswer = answerRepository.findById(answerId);
        if (optionalAnswer.isPresent()) {
            Answer answer = optionalAnswer.get();
            if (updatedAnswerDto.getText() != null) {
                answer.setText(updatedAnswerDto.getText());
            }
            Answer savedAnswer = answerRepository.save(answer);
            return modelMapper.map(savedAnswer, AnswerResponseDto.class);
        } else {
            throw new RuntimeException("Answer not found");
        }
    }

//        @Transactional
//    public boolean deleteAnswer(Long answerId) {
//        Optional<Answer> optionalAnswer = answerRepository.findById(answerId);
//
//        if (optionalAnswer.isPresent()) {
//            answerRepository.delete(optionalAnswer.get());
//            return true;
//        } else {
//            return false;
//        }
//    }
//@Transactional
//    public AnswerResponseDto updateAnswer(Long answerId, AnswerDto updatedAnswerDto) {
//        Optional<Answer> optionalAnswer = answerRepository.findById(answerId);
//        if (optionalAnswer.isPresent()) {
//            Answer answer = optionalAnswer.get();
//            answer.setText(updatedAnswerDto.getText());
//            Answer savedAnswer = answerRepository.save(answer);
//            return modelMapper.map(savedAnswer, AnswerResponseDto.class);
//        }
//        return null; // Answer not found
//    }
}
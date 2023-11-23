package com.YouQuiz.YouQuiz.Service.Impl;

import com.YouQuiz.YouQuiz.DTOs.AnswerDto;
import com.YouQuiz.YouQuiz.DTOs.QuizDto;
import com.YouQuiz.YouQuiz.DTOs.AnswerResponseDto;
import com.YouQuiz.YouQuiz.DTOs.QuizResponseDto;
import com.YouQuiz.YouQuiz.Entities.Answer;
import com.YouQuiz.YouQuiz.Entities.Formator;
import com.YouQuiz.YouQuiz.Entities.Quiz;
import com.YouQuiz.YouQuiz.Repositories.AnswerRepository;
import com.YouQuiz.YouQuiz.Repositories.FormatorRepository;
import com.YouQuiz.YouQuiz.Repositories.QuizRepository;
import com.YouQuiz.YouQuiz.Service.QuizService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {
    private final QuizRepository quizRepository;
    private final FormatorRepository formatorRepository;
    private final ModelMapper modelMapper;

    public QuizServiceImpl(QuizRepository quizRepository, ModelMapper modelMapper, FormatorRepository formatorRepository) {
        this.quizRepository = quizRepository;
        this.modelMapper = modelMapper;
        this.formatorRepository = formatorRepository;
    }

    @Override
    @Transactional
    public QuizDto createQuiz(QuizDto quizDto) {
        try {
            Quiz quiz = modelMapper.map(quizDto, Quiz.class);
            Quiz savedQuiz = quizRepository.save(quiz);
            return modelMapper.map(savedQuiz, QuizDto.class);
        } catch (Exception e) {

            throw new RuntimeException("Failed to create quiz: " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<QuizResponseDto> getAllQuizs() {
        List<Quiz> quizs = quizRepository.findAll();
        return quizs.stream()
                .map(quiz -> modelMapper.map(quiz, QuizResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public boolean deleteQuiz(Long quizId) {
        Optional<Quiz> optionalQuiz = quizRepository.findById(quizId);
        if (optionalQuiz.isPresent()) {
            quizRepository.delete(optionalQuiz.get());
            return true;
        } else {
            throw new RuntimeException("Quiz not found");
        }
    }

    @Override
    @Transactional
    public QuizResponseDto updateQuiz(Long quizId, QuizDto updatedQuizDto) {
        Optional<Quiz> optionalQuiz = quizRepository.findById(quizId);
        if (optionalQuiz.isPresent()) {
            Quiz quiz = optionalQuiz.get();
            if (updatedQuizDto.getFormator_id() != null) {
                Long formatorId = updatedQuizDto.getFormator_id();
                Formator formator = formatorRepository.findById(formatorId).orElseThrow(() -> new RuntimeException("Formator not found with ID: " + formatorId));
                quiz.setFormator(formator);
            }
            if (updatedQuizDto.getSuccessScore() != 0) {
                quiz.setSuccessScore(updatedQuizDto.getSuccessScore());
            }
            if (updatedQuizDto.getMaxAttempts() != 0) {
                quiz.setMaxAttempts(updatedQuizDto.getMaxAttempts());
            }
            if (updatedQuizDto.getRemarks() != null) {
                quiz.setRemarks(updatedQuizDto.getRemarks());
            }
            if (updatedQuizDto.getInstructions() != null) {
                quiz.setInstructions(updatedQuizDto.getInstructions());
            }
            quiz.setViewAnswers(true);
            quiz.setViewResult(true);

            Quiz savedQuiz = quizRepository.save(quiz);
            return modelMapper.map(savedQuiz, QuizResponseDto.class);
        } else {
            throw new RuntimeException("Quiz not found");
        }
    }

//    @Transactional
//    public List<QuizResponseDto> getAllQuizs() {
//        List<Quiz> quizs = quizRepository.findAll();
//        return quizs.stream()
//                .map(quiz -> modelMapper.map(quiz, QuizResponseDto.class))
//                .collect(Collectors.toList());
//    }
//
//    @Transactional
//    public QuizDto createQuiz(QuizDto quizDto) {
//        Quiz quiz = modelMapper.map(quizDto, Quiz.class);
//        Quiz savedQuiz = quizRepository.save(quiz);
//        return modelMapper.map(savedQuiz, QuizDto.class);
//    }
//
//    @Transactional
//    public boolean deleteQuiz(Long quizId) {
//        Optional<Quiz> optionalQuiz = quizRepository.findById(quizId);
//
//        if (optionalQuiz.isPresent()) {
//            quizRepository.delete(optionalQuiz.get());
//            return true;
//        } else {
//            return false;
//        }
//    }
//    @Transactional
//    public QuizResponseDto updateQuiz(Long quizId, QuizDto updatedQuizDto) {
//        Optional<Quiz> optionalQuiz = quizRepository.findById(quizId);
//        if (optionalQuiz.isPresent()) {
//            Quiz quiz = optionalQuiz.get();
//            quiz.set(updatedQuizDto.getText());
//            Quiz savedQuiz = quizRepository.save(quiz);
//            return modelMapper.map(savedQuiz, QuizResponseDto.class);
//        }
//        return null; // Quiz not found
//    }
}

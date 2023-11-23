package com.YouQuiz.YouQuiz.Service.Impl;

import com.YouQuiz.YouQuiz.DTOs.AssignQuizDto;
import com.YouQuiz.YouQuiz.DTOs.AssignQuizDto;
import com.YouQuiz.YouQuiz.DTOs.AnswerResponseDto;
import com.YouQuiz.YouQuiz.DTOs.AssignQuizResponseDto;
import com.YouQuiz.YouQuiz.Entities.Answer;
import com.YouQuiz.YouQuiz.Entities.AssignQuiz;
import com.YouQuiz.YouQuiz.Entities.Quiz;
import com.YouQuiz.YouQuiz.Entities.Student;
import com.YouQuiz.YouQuiz.Repositories.AnswerRepository;
import com.YouQuiz.YouQuiz.Repositories.AssignQuizRepository;
import com.YouQuiz.YouQuiz.Repositories.QuizRepository;
import com.YouQuiz.YouQuiz.Repositories.StudentRepository;
import com.YouQuiz.YouQuiz.Service.AssignQuizService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class AssignQuizServiceImpl implements AssignQuizService {
    private final AssignQuizRepository assignQuizRepository;
    private final QuizRepository quizRepository;
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    public AssignQuizServiceImpl(AssignQuizRepository assignQuizRepository, ModelMapper modelMapper, QuizRepository quizRepository,StudentRepository studentRepository) {
        this.assignQuizRepository = assignQuizRepository;
        this.modelMapper = modelMapper;
        this.quizRepository = quizRepository;
        this.studentRepository = studentRepository;
    }
    @Override
    @Transactional
    public AssignQuizDto createAssignQuiz(AssignQuizDto assignQuizDto) {
        try {
            AssignQuiz assignQuiz = modelMapper.map(assignQuizDto, AssignQuiz.class);
            AssignQuiz savedAssignQuiz = assignQuizRepository.save(assignQuiz);
            return modelMapper.map(savedAssignQuiz, AssignQuizDto.class);
        } catch (Exception e) {

            throw new RuntimeException("Failed to create assignQuiz: " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<AssignQuizResponseDto> getAllAssignQuizs() {
        List<AssignQuiz> assignQuizs = assignQuizRepository.findAll();
        return assignQuizs.stream()
                .map(assignQuiz -> modelMapper.map(assignQuiz, AssignQuizResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public boolean deleteAssignQuiz(Long assignQuizId) {
        Optional<AssignQuiz> optionalAssignQuiz = assignQuizRepository.findById(assignQuizId);
        if (optionalAssignQuiz.isPresent()) {
            assignQuizRepository.delete(optionalAssignQuiz.get());
            return true;
        } else {
            throw new RuntimeException("AssignQuiz not found");
        }
    }

    @Override
    @Transactional
    public AssignQuizResponseDto updateAssignQuiz(Long assignQuizId, AssignQuizDto updatedAssignQuizDto) {
        Optional<AssignQuiz> optionalAssignQuiz = assignQuizRepository.findById(assignQuizId);
        if (optionalAssignQuiz.isPresent()) {
            AssignQuiz assignQuiz = optionalAssignQuiz.get();

            if (updatedAssignQuizDto.getQuiz_id() != null) {
                Long quizId = updatedAssignQuizDto.getQuiz_id();
                Quiz quiz = quizRepository.findById(quizId).orElseThrow(() -> new RuntimeException("Quiz not found with ID: " + quizId));
                assignQuiz.setQuiz(quiz);
            }
            if (updatedAssignQuizDto.getStudent_id() != null) {
                Long studentId = updatedAssignQuizDto.getStudent_id();
                Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found with ID: " + studentId));
                assignQuiz.setStudent(student);
            }
            if (updatedAssignQuizDto.getStartInDate() != null) {
                assignQuiz.setStartInDate(updatedAssignQuizDto.getStartInDate());
            }
            if (updatedAssignQuizDto.getStartInTime() != null) {
                assignQuiz.setStartInTime(updatedAssignQuizDto.getStartInTime());
            }
            if (updatedAssignQuizDto.getEndInDate() != null) {
                assignQuiz.setEndInDate(updatedAssignQuizDto.getEndInDate());
            }
            if (updatedAssignQuizDto.getEndInTime() != null) {
                assignQuiz.setEndInTime(updatedAssignQuizDto.getEndInTime());
            }

            AssignQuiz savedAssignQuiz = assignQuizRepository.save(assignQuiz);
            return modelMapper.map(savedAssignQuiz, AssignQuizResponseDto.class);
        } else {
            throw new RuntimeException("AssignQuiz not found");
        }
    }
//    @Transactional
//    public List<AssignQuizResponseDto> getAllAssignQuizs() {
//        List<AssignQuiz> assignQuizs = assignQuizRepository.findAll();
//        return assignQuizs.stream()
//                .map(assignQuiz -> modelMapper.map(assignQuiz, AssignQuizResponseDto.class))
//                .collect(Collectors.toList());
//    }
//
//    @Transactional
//    public AssignQuizDto createAssignQuiz(AssignQuizDto assignQuizDto) {
//        AssignQuiz assignQuiz = modelMapper.map(assignQuizDto, AssignQuiz.class);
//        AssignQuiz savedAssignQuiz = assignQuizRepository.save(assignQuiz);
//        return modelMapper.map(savedAssignQuiz, AssignQuizDto.class);
//    }
//
//    @Transactional
//    public boolean deleteAssignQuiz(Long assignQuizId) {
//        Optional<AssignQuiz> optionalAssignQuiz = assignQuizRepository.findById(assignQuizId);
//
//        if (optionalAssignQuiz.isPresent()) {
//            assignQuizRepository.delete(optionalAssignQuiz.get());
//            return true;
//        } else {
//            return false;
//        }
//    }
//    @Transactional
//    public AssignQuizResponseDto updateAssignQuiz(Long assignQuizId, AssignQuizDto updatedAssignQuizDto) {
//        Optional<AssignQuiz> optionalAssignQuiz = assignQuizRepository.findById(assignQuizId);
//        if (optionalAssignQuiz.isPresent()) {
//            AssignQuiz assignQuiz = optionalAssignQuiz.get();
//            assignQuiz.setText(updatedAssignQuizDto.getText());
//            AssignQuiz savedAssignQuiz = assignQuizRepository.save(assignQuiz);
//            return modelMapper.map(savedAssignQuiz, AssignQuizResponseDto.class);
//        }
//        return null; // AssignQuiz not found
//    }
}

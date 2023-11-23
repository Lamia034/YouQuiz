package com.YouQuiz.YouQuiz.Controller;

import com.YouQuiz.YouQuiz.DTOs.QuizDto;
import com.YouQuiz.YouQuiz.DTOs.QuizResponseDto;
import com.YouQuiz.YouQuiz.DTOs.QuizDto;
import com.YouQuiz.YouQuiz.DTOs.QuizResponseDto;
import com.YouQuiz.YouQuiz.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/quizs")
public class QuizController {


        private final QuizService quizService;


        @Autowired
        public QuizController(QuizService quizService) {
            this.quizService = quizService;

        }

    @PostMapping
    public ResponseEntity<Object> createQuiz(@RequestBody QuizDto quizDto) {
        try {
            QuizDto createdQuiz = quizService.createQuiz(quizDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdQuiz);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create quiz: " + e.getMessage());
        }
    }

    @GetMapping
    public List<QuizResponseDto> getAllQuizs() {
        return quizService.getAllQuizs();
    }

    @DeleteMapping("/{quizId}")
    public ResponseEntity<String> deleteQuiz(@PathVariable Long quizId) {
        try {
            boolean deleted = quizService.deleteQuiz(quizId);
            if (deleted) {
                return ResponseEntity.ok("Quiz deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Quiz not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete quiz: " + e.getMessage());
        }
    }

    @PutMapping("/{quizId}")
    public ResponseEntity<Object> updateQuiz(@PathVariable Long quizId, @RequestBody QuizDto updatedQuizDto) {
        try {
            QuizResponseDto updatedQuiz = quizService.updateQuiz(quizId, updatedQuizDto);
            return ResponseEntity.ok(updatedQuiz);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update quiz: " + e.getMessage());
        }
    }
//        @PostMapping
//        public QuizDto createQuiz(@RequestBody QuizDto quizDto) {
//            return quizService.createQuiz(quizDto);
//        }
//        @GetMapping
//        public List<QuizResponseDto> getAllQuizs() {
//            return quizService.getAllQuizs();
//        }
//
//        @DeleteMapping("/{quizId}")
//        public ResponseEntity<String> deleteQuiz(@PathVariable Long quizId) {
//            boolean deleted = quizService.deleteQuiz(quizId);
//
//            if (deleted) {
//                return new ResponseEntity<>("Quiz deleted successfully", HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>("Quiz not found", HttpStatus.NOT_FOUND);
//            }
//        }
//        @PutMapping("/{quizId}")
//        public QuizResponseDto updateQuiz(@PathVariable Long quizId, @RequestBody QuizDto updatedQuiz) {
//            return quizService.updateQuiz(quizId, updatedQuiz);
//        }
    }
package com.YouQuiz.YouQuiz.Controller;

import com.YouQuiz.YouQuiz.DTOs.*;
import com.YouQuiz.YouQuiz.Entities.Question;
import com.YouQuiz.YouQuiz.Entities.Level;
import com.YouQuiz.YouQuiz.Entities.Question;
import com.YouQuiz.YouQuiz.Service.QuestionService;
import com.YouQuiz.YouQuiz.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/questions")
public class QuestionController {
    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

//    @PostMapping
//    public Question createQuestion(@RequestBody Question question) {
//        return questionService.createQuestion(question);
//    }
@PostMapping
public ResponseEntity<Object> createQuestion(@RequestBody QuestionDto questionDto) {
    try {
        QuestionDto createdQuestion = questionService.createQuestion(questionDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdQuestion);
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create question: " + e.getMessage());
    }
}

    @GetMapping
    public List<QuestionResponseDto> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @DeleteMapping("/{questionId}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Long questionId) {
        try {
            boolean deleted = questionService.deleteQuestion(questionId);
            if (deleted) {
                return ResponseEntity.ok("Question deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Question not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete question: " + e.getMessage());
        }
    }

    @PutMapping("/{questionId}")
    public ResponseEntity<Object> updateQuestion(@PathVariable Long questionId, @RequestBody QuestionDto updatedQuestionDto) {
        try {
            QuestionResponseDto updatedQuestion = questionService.updateQuestion(questionId, updatedQuestionDto);
            return ResponseEntity.ok(updatedQuestion);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update question: " + e.getMessage());
        }
    }
//@PostMapping
//public QuestionDto createQuestion(@RequestBody QuestionDto questionDto) {
//    return questionService.createQuestion(questionDto);
//}
//    @GetMapping
////    public List<Question> getAllQuestions() {
////        return questionService.getAllQuestions();
////    }
//    public List<QuestionResponseDto> getAllQuestions() {
//        return questionService.getAllQuestions();
//    }
//
//
//    @DeleteMapping("/{questionId}")
//    public ResponseEntity<String> deleteQuestion(@PathVariable Long questionId) {
//        boolean deleted = questionService.deleteQuestion(questionId);
//
//        if (deleted) {
//            return new ResponseEntity<>("Question deleted successfully", HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("Question not found", HttpStatus.NOT_FOUND);
//        }
//    }
//    @PutMapping("/{questionId}")
//    public QuestionResponseDto updateQuestion(@PathVariable Long questionId, @RequestBody QuestionDto updatedQuestion) {
//        return questionService.updateQuestion(questionId, updatedQuestion);
//    }
//    @DeleteMapping("/{questionId}")
//    public ResponseEntity<String> deleteQuestion(@PathVariable Long questionId) {
//        boolean deleted = questionService.deleteQuestion(questionId);
//
//        if (deleted) {
//            return new ResponseEntity<>("Question deleted successfully", HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("Question not found", HttpStatus.NOT_FOUND);
//        }
//    }
//    @PutMapping("/{questionId}")
//    public QuestionDto updateQuestion(@PathVariable Long questionId, @RequestBody QuestionDto updatedQuestionDto) {
//        return questionService.updateQuestion(questionId, updatedQuestionDto);
//    }






//    public Question updateQuestion(@PathVariable Long questionId, @RequestBody Question updatedQuestion) {
//        return questionService.updateQuestion(questionId, updatedQuestion);
//    }
}
package com.YouQuiz.YouQuiz.Controller;

import com.YouQuiz.YouQuiz.DTOs.*;
import com.YouQuiz.YouQuiz.DTOs.AnswerDto;
import com.YouQuiz.YouQuiz.Entities.Answer;
import com.YouQuiz.YouQuiz.Repositories.AnswerRepository;
import com.YouQuiz.YouQuiz.Service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answers")
public class AnswerController {
    private final AnswerService answerService;


    @Autowired
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;

    }

    //        @PostMapping
//    public AnswerDto createAnswer(@RequestBody AnswerDto answerDto) {
//        return answerService.createAnswer(answerDto);
//    }
    @PostMapping
    public ResponseEntity<Object> createAnswer(@RequestBody AnswerDto answerDto) {
        try {
            AnswerDto createdAnswer = answerService.createAnswer(answerDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdAnswer);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create answer: " + e.getMessage());
        }
    }

    @GetMapping
    public List<AnswerResponseDto> getAllAnswers() {
        return answerService.getAllAnswers();
    }

    @DeleteMapping("/{answerId}")
    public ResponseEntity<String> deleteAnswer(@PathVariable Long answerId) {
        try {
            boolean deleted = answerService.deleteAnswer(answerId);
            if (deleted) {
                return ResponseEntity.ok("Answer deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Answer not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete answer: " + e.getMessage());
        }
    }

    @PutMapping("/{answerId}")
    public ResponseEntity<Object> updateAnswer(@PathVariable Long answerId, @RequestBody AnswerDto updatedAnswerDto) {
        try {
            AnswerResponseDto updatedAnswer = answerService.updateAnswer(answerId, updatedAnswerDto);
            return ResponseEntity.ok(updatedAnswer);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update answer: " + e.getMessage());
        }
    }
}
//    @GetMapping
//    public List<AnswerResponseDto> getAllAnswers() {
//        return answerService.getAllAnswers();
//    }
//
//    @DeleteMapping("/{answerId}")
//    public ResponseEntity<String> deleteAnswer(@PathVariable Long answerId) {
//        boolean deleted = answerService.deleteAnswer(answerId);
//
//        if (deleted) {
//            return new ResponseEntity<>("Answer deleted successfully", HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("Answer not found", HttpStatus.NOT_FOUND);
//        }
//    }
//    @PutMapping("/{answerId}")
//    public AnswerResponseDto updateAnswer(@PathVariable Long answerId, @RequestBody AnswerDto updatedAnswer) {
//        return answerService.updateAnswer(answerId, updatedAnswer);
//    }
//}
//}





//    @Autowired
//    public AnswerController(AnswerService answerService) {
//        this.answerService = answerService;
//    }
//

//
//    @GetMapping("/{answerId}")
//    public AnswerDto getAnswerById(@PathVariable Integer answerId) {
//        return answerService.getAnswerById(answerId);
//    }
//

//
//    @PutMapping("/{answerId}")
//    public AnswerDto updateAnswer(@PathVariable Integer answerId, @RequestBody AnswerDto answerDto) {
//        return answerService.updateAnswer(answerId, answerDto);
//    }
//
//    @DeleteMapping("/{answerId}")
//    public void deleteAnswer(@PathVariable Integer answerId) {
//        answerService.deleteAnswer(answerId);
//    }

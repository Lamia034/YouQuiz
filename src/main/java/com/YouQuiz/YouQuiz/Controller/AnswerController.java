package com.YouQuiz.YouQuiz.Controller;

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

    @PostMapping
    public Answer createAnswer(@RequestBody Answer answer) {
        return answerService.createAnswer(answer);
    }
    @GetMapping
    public List<Answer> getAllAnswers() {
        return answerService.getAllAnswers();
    }
    @DeleteMapping("/{answerId}")
    public ResponseEntity<String> deleteAnswer(@PathVariable Long answerId) {
        boolean deleted = answerService.deleteAnswer(answerId);

        if (deleted) {
            return new ResponseEntity<>("Answer deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Answer not found", HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{answerId}")
    public Answer updateAnswer(@PathVariable Long answerId, @RequestBody Answer updatedAnswer) {
        return answerService.updateAnswer(answerId, updatedAnswer);
    }

}

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

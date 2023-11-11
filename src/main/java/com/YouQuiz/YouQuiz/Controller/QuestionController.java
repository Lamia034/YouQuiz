package com.YouQuiz.YouQuiz.Controller;

import com.YouQuiz.YouQuiz.Entities.Answer;
import com.YouQuiz.YouQuiz.Entities.Level;
import com.YouQuiz.YouQuiz.Entities.Question;
import com.YouQuiz.YouQuiz.Service.AnswerService;
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

    @PostMapping
    public Question createQuestion(@RequestBody Question question) {
        return questionService.createQuestion(question);
    }
    @GetMapping
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }
    @DeleteMapping("/{questionId}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Long questionId) {
        boolean deleted = questionService.deleteQuestion(questionId);

        if (deleted) {
            return new ResponseEntity<>("Question deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Question not found", HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{questionId}")
    public Question updateQuestion(@PathVariable Long questionId, @RequestBody Question updatedQuestion) {
        return questionService.updateQuestion(questionId, updatedQuestion);
    }
}
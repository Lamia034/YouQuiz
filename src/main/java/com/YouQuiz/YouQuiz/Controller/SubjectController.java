package com.YouQuiz.YouQuiz.Controller;

import com.YouQuiz.YouQuiz.Entities.Question;
import com.YouQuiz.YouQuiz.Entities.Subject;
import com.YouQuiz.YouQuiz.Service.QuestionService;
import com.YouQuiz.YouQuiz.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping
    public Subject createSubject(@RequestBody Subject subject) {
        return subjectService.createSubject(subject);
    }
    @GetMapping
    public List<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();
    }
    @DeleteMapping("/{subjectId}")
    public ResponseEntity<String> deleteSubject(@PathVariable Long subjectId) {
        boolean deleted = subjectService.deleteSubject(subjectId);

        if (deleted) {
            return new ResponseEntity<>("Subject deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Subject not found", HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{subjectId}")
    public Subject updateSubject(@PathVariable Long subjectId, @RequestBody Subject updatedSubject) {
        return subjectService.updateSubject(subjectId, updatedSubject);
    }
}

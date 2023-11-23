package com.YouQuiz.YouQuiz.Controller;

import com.YouQuiz.YouQuiz.DTOs.*;
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


//    public Subject createSubject(@RequestBody Subject subject) {
//        return subjectService.createSubject(subject);
//    }
//   @PostMapping
//   public ResponseEntity<Object> createSubject(@RequestBody SubjectDto subjectDto) {
//       try {
//           SubjectDto createdSubject = subjectService.createSubject(subjectDto);
//           return ResponseEntity.status(HttpStatus.CREATED).body(createdSubject);
//       } catch (Exception e) {
//           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create subject: " + e.getMessage());
//       }
//   }
    @PostMapping
    public SubjectDto createSubject(@RequestBody SubjectDto subjectDto) {
        return subjectService.createSubject(subjectDto);
    }
    @GetMapping
//    public List<Subject> getAllSubjects() {
//        return subjectService.getAllSubjects();
//    }
    public List<SubjectResponseDto> getAllSubjects() {
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
    public SubjectResponseDto updateSubject(@PathVariable Long subjectId, @RequestBody SubjectDto updatedSubject) {
        return subjectService.updateSubject(subjectId, updatedSubject);
    }
//    @DeleteMapping("/{subjectId}")
//    public ResponseEntity<String> deleteSubject(@PathVariable Long subjectId) {
//        boolean deleted = subjectService.deleteSubject(subjectId);
//
//        if (deleted) {
//            return new ResponseEntity<>("Subject deleted successfully", HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("Subject not found", HttpStatus.NOT_FOUND);
//        }
//    }
//    @PutMapping("/{subjectId}")
//    public Subject updateSubject(@PathVariable Long subjectId, @RequestBody Subject updatedSubject) {
//        return subjectService.updateSubject(subjectId, updatedSubject);
//    }
//@PutMapping("/{subjectId}")
//public SubjectDto updateSubject(@PathVariable Long subjectId, @RequestBody SubjectDto updatedSubjectDto) {
//    return subjectService.updateSubject(subjectId, updatedSubjectDto);
//}
//@PutMapping("/{subjectId}")
//public SubjectDto updateSubject(@PathVariable Long subjectId, @RequestBody SubjectDto updatedSubjectDto) {
//    return subjectService.updateSubject(subjectId, updatedSubjectDto);
//}


}

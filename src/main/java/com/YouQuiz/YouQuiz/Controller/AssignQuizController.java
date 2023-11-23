package com.YouQuiz.YouQuiz.Controller;

import com.YouQuiz.YouQuiz.DTOs.*;
import com.YouQuiz.YouQuiz.DTOs.AssignQuizDto;
import com.YouQuiz.YouQuiz.DTOs.AssignQuizResponseDto;
import com.YouQuiz.YouQuiz.Service.AnswerService;
import com.YouQuiz.YouQuiz.Service.AssignQuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/assignQuizs")
public class AssignQuizController {
    private final AssignQuizService assignQuizService;

    @Autowired
    public AssignQuizController(AssignQuizService assignQuizService) {
        this.assignQuizService = assignQuizService;

    }

    @PostMapping
    public ResponseEntity<Object> createAssignQuiz(@RequestBody AssignQuizDto assignQuizDto) {
        try {
            AssignQuizDto createdAssignQuiz = assignQuizService.createAssignQuiz(assignQuizDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdAssignQuiz);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create assignQuiz: " + e.getMessage());
        }
    }

    @GetMapping
    public List<AssignQuizResponseDto> getAllAssignQuizs() {
        return assignQuizService.getAllAssignQuizs();
    }

    @DeleteMapping("/{assignQuizId}")
    public ResponseEntity<String> deleteAssignQuiz(@PathVariable Long assignQuizId) {
        try {
            boolean deleted = assignQuizService.deleteAssignQuiz(assignQuizId);
            if (deleted) {
                return ResponseEntity.ok("AssignQuiz deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("AssignQuiz not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete assignQuiz: " + e.getMessage());
        }
    }

    @PutMapping("/{assignQuizId}")
    public ResponseEntity<Object> updateAssignQuiz(@PathVariable Long assignQuizId, @RequestBody AssignQuizDto updatedAssignQuizDto) {
        try {
            AssignQuizResponseDto updatedAssignQuiz = assignQuizService.updateAssignQuiz(assignQuizId, updatedAssignQuizDto);
            return ResponseEntity.ok(updatedAssignQuiz);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update assignQuiz: " + e.getMessage());
        }
    }

//    @PostMapping
//    public AssignQuizDto createAssignQuiz(@RequestBody AssignQuizDto assignQuizDto) {
//        return assignQuizService.createAssignQuiz(assignQuizDto);
//    }
//    @GetMapping
//    public List<AssignQuizResponseDto> getAllAssignQuizs() {
//        return assignQuizService.getAllAssignQuizs();
//    }
//
//    @DeleteMapping("/{assignQuizId}")
//    public ResponseEntity<String> deleteAssignQuiz(@PathVariable Long assignQuizId) {
//        boolean deleted = assignQuizService.deleteAssignQuiz(assignQuizId);
//
//        if (deleted) {
//            return new ResponseEntity<>("AssignQuiz deleted successfully", HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("AssignQuiz not found", HttpStatus.NOT_FOUND);
//        }
//    }
//    @PutMapping("/{assignQuizId}")
//    public AssignQuizResponseDto updateAssignQuiz(@PathVariable Long assignQuizId, @RequestBody AssignQuizDto updatedAssignQuiz) {
//        return assignQuizService.updateAssignQuiz(assignQuizId, updatedAssignQuiz);
//    }
}
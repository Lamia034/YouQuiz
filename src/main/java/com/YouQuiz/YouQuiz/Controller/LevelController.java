package com.YouQuiz.YouQuiz.Controller;

import com.YouQuiz.YouQuiz.DTOs.*;
import com.YouQuiz.YouQuiz.Entities.Level;
import com.YouQuiz.YouQuiz.Entities.Level;
import com.YouQuiz.YouQuiz.Entities.Question;
import com.YouQuiz.YouQuiz.Service.LevelService;
import com.YouQuiz.YouQuiz.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/levels")
public class LevelController {
    private final LevelService levelService;

    @Autowired
    public LevelController(LevelService levelService) {
        this.levelService = levelService;
    }
    @PostMapping
    public ResponseEntity<Object> createLevel(@RequestBody LevelDto levelDto) {
        try {
            LevelDto createdLevel = levelService.createLevel(levelDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdLevel);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create level: " + e.getMessage());
        }
    }

    @GetMapping
    public List<LevelResponseDto> getAllLevels() {
        return levelService.getAllLevels();
    }

    @DeleteMapping("/{levelId}")
    public ResponseEntity<String> deleteLevel(@PathVariable Long levelId) {
        try {
            boolean deleted = levelService.deleteLevel(levelId);
            if (deleted) {
                return ResponseEntity.ok("Level deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Level not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete level: " + e.getMessage());
        }
    }

    @PutMapping("/{levelId}")
    public ResponseEntity<Object> updateLevel(@PathVariable Long levelId, @RequestBody LevelDto updatedLevelDto) {
        try {
            LevelResponseDto updatedLevel = levelService.updateLevel(levelId, updatedLevelDto);
            return ResponseEntity.ok(updatedLevel);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update level: " + e.getMessage());
        }
    }

//    @PostMapping
//    public LevelDto createLevel(@RequestBody LevelDto levelDto) {
//        return levelService.createLevel(levelDto);
//    }
//
//    @GetMapping
////    public List<Level> getAllLevels() {
////        return levelService.getAllLevels();
////    }
//    public List<LevelResponseDto> getAllLevels() {
//        return levelService.getAllLevels();
//    }
//
//    @DeleteMapping("/{levelId}")
//    public ResponseEntity<String> deleteLevel(@PathVariable Long levelId) {
//        boolean deleted = levelService.deleteLevel(levelId);
//
//        if (deleted) {
//            return new ResponseEntity<>("Level deleted successfully", HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("Level not found", HttpStatus.NOT_FOUND);
//        }
//    }
//    @PutMapping("/{levelId}")
//    public LevelResponseDto updateLevel(@PathVariable Long levelId, @RequestBody LevelDto updatedLevel) {
//        return levelService.updateLevel(levelId, updatedLevel);
//    }
//    @DeleteMapping("/{levelId}")
//    public ResponseEntity<String> deleteLevel(@PathVariable Long levelId) {
//        boolean deleted = levelService.deleteLevel(levelId);
//
//        if (deleted) {
//            return new ResponseEntity<>("Level deleted successfully", HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("Level not found", HttpStatus.NOT_FOUND);
//        }
//    }
//    @PutMapping("/{levelId}")
//    public Level updateLevel(@PathVariable Long levelId, @RequestBody Level updatedLevel) {
//        return levelService.updateLevel(levelId, updatedLevel);
//    }
}
package com.YouQuiz.YouQuiz.Controller;

import com.YouQuiz.YouQuiz.Entities.Answer;
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
    public Level createLevel(@RequestBody Level level) {
        return levelService.createLevel(level);
    }

    @GetMapping
    public List<Level> getAllLevels() {
        return levelService.getAllLevels();
    }
    @DeleteMapping("/{levelId}")
    public ResponseEntity<String> deleteLevel(@PathVariable Long levelId) {
        boolean deleted = levelService.deleteLevel(levelId);

        if (deleted) {
            return new ResponseEntity<>("Level deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Level not found", HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{levelId}")
    public Level updateLevel(@PathVariable Long levelId, @RequestBody Level updatedLevel) {
        return levelService.updateLevel(levelId, updatedLevel);
    }
}
package com.YouQuiz.YouQuiz.Service;

import com.YouQuiz.YouQuiz.Entities.Answer;
import com.YouQuiz.YouQuiz.Entities.Level;
import com.YouQuiz.YouQuiz.Entities.Question;
import com.YouQuiz.YouQuiz.Repositories.LevelRepository;
import com.YouQuiz.YouQuiz.Repositories.QuestionRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LevelService {
    private final LevelRepository levelRepository;

    @Autowired
    public LevelService(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }

    @Transactional
    public Level createLevel(Level level) {
        return levelRepository.save(level);
    }
    public List<Level> getAllLevels() {
        return levelRepository.findAll();
    }
    @Transactional
    public boolean deleteLevel(Long levelId) {
        Optional<Level> optionalLevel = levelRepository.findById(levelId);

        if (optionalLevel.isPresent()) {
            levelRepository.delete(optionalLevel.get());
            return true;
        } else {
            return false;
        }
    }
    @Transactional
    public Level updateLevel(Long levelId, Level updatedLevel) {
        Level existingLevel = levelRepository.findById(levelId)
                .orElseThrow(() -> new EntityNotFoundException("Level not found with id: " + levelId));

        existingLevel.setDescription(updatedLevel.getDescription());
        existingLevel.setMaxPoints(updatedLevel.getMaxPoints());
        existingLevel.setMinPoints(updatedLevel.getMinPoints());

        return levelRepository.save(existingLevel);
    }
}

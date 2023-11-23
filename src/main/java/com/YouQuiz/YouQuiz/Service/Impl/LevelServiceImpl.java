package com.YouQuiz.YouQuiz.Service.Impl;

import com.YouQuiz.YouQuiz.DTOs.LevelDto;
import com.YouQuiz.YouQuiz.DTOs.AnswerResponseDto;
import com.YouQuiz.YouQuiz.DTOs.LevelDto;
import com.YouQuiz.YouQuiz.DTOs.LevelResponseDto;
import com.YouQuiz.YouQuiz.Entities.Answer;
import com.YouQuiz.YouQuiz.Entities.Level;
import com.YouQuiz.YouQuiz.Repositories.AnswerRepository;
import com.YouQuiz.YouQuiz.Repositories.LevelRepository;
import com.YouQuiz.YouQuiz.Service.LevelService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class LevelServiceImpl implements LevelService {
    private final LevelRepository levelRepository;
    private final ModelMapper modelMapper;

    public LevelServiceImpl(LevelRepository levelRepository, ModelMapper modelMapper) {
        this.levelRepository = levelRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    @Transactional
    public LevelDto createLevel(LevelDto levelDto) {
        try {
            Level level = modelMapper.map(levelDto, Level.class);
            Level savedLevel = levelRepository.save(level);
            return modelMapper.map(savedLevel, LevelDto.class);
        } catch (Exception e) {

            throw new RuntimeException("Failed to create level: " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<LevelResponseDto> getAllLevels() {
        List<Level> levels = levelRepository.findAll();
        return levels.stream()
                .map(level -> modelMapper.map(level, LevelResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public boolean deleteLevel(Long levelId) {
        Optional<Level> optionalLevel = levelRepository.findById(levelId);
        if (optionalLevel.isPresent()) {
            levelRepository.delete(optionalLevel.get());
            return true;
        } else {
            throw new RuntimeException("Level not found");
        }
    }

    @Override
    @Transactional
    public LevelResponseDto updateLevel(Long levelId, LevelDto updatedLevelDto) {
        Optional<Level> optionalLevel = levelRepository.findById(levelId);
        if (optionalLevel.isPresent()) {
            Level level = optionalLevel.get();
            if (updatedLevelDto.getDescription() != null) {
                level.setDescription(updatedLevelDto.getDescription());
            }
            Level savedLevel = levelRepository.save(level);
            return modelMapper.map(savedLevel, LevelResponseDto.class);
        } else {
            throw new RuntimeException("Level not found");
        }
    }
//    @Transactional
//    public List<LevelResponseDto> getAllLevels() {
//        List<Level> levels = levelRepository.findAll();
//        return levels.stream()
//                .map(level -> modelMapper.map(level, LevelResponseDto.class))
//                .collect(Collectors.toList());
//    }
//
//    @Transactional
//    public LevelDto createLevel(LevelDto levelDto) {
//        Level level = modelMapper.map(levelDto, Level.class);
//        Level savedLevel = levelRepository.save(level);
//        return modelMapper.map(savedLevel, LevelDto.class);
//    }
//
//    @Transactional
//    public boolean deleteLevel(Long levelId) {
//        Optional<Level> optionalLevel = levelRepository.findById(levelId);
//
//        if (optionalLevel.isPresent()) {
//            levelRepository.delete(optionalLevel.get());
//            return true;
//        } else {
//            return false;
//        }
//    }
//    @Transactional
//    public LevelResponseDto updateLevel(Long levelId, LevelDto updatedLevelDto) {
//        Optional<Level> optionalLevel = levelRepository.findById(levelId);
//        if (optionalLevel.isPresent()) {
//            Level level = optionalLevel.get();
//
//            level.setDescription(updatedLevelDto.getDescription());
//
//            level.setMaxPoints(updatedLevelDto.getMaxPoints());
//
//            level.setMinPoints(updatedLevelDto.getMinPoints());
//
//            Level savedLevel = levelRepository.save(level);
//            return modelMapper.map(savedLevel, LevelResponseDto.class);
//        }
//        return null; // Level not found
//    }
}

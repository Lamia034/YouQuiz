package com.YouQuiz.YouQuiz.Service.Impl;

import com.YouQuiz.YouQuiz.DTOs.*;
import com.YouQuiz.YouQuiz.Entities.*;
import com.YouQuiz.YouQuiz.Repositories.*;
import com.YouQuiz.YouQuiz.Service.QuestionService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;
    private final ModelMapper modelMapper;
    private final SubjectRepository subjectRepository;
    private final LevelRepository levelRepository;
    private final MediaRepository mediaRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository, ModelMapper modelMapper , SubjectRepository subjectRepository,LevelRepository levelRepository, MediaRepository mediaRepository) {
        this.questionRepository = questionRepository;
        this.modelMapper = modelMapper;
        this.subjectRepository  = subjectRepository;
        this.levelRepository = levelRepository;
        this.mediaRepository = mediaRepository;
    }

    @Override
    @Transactional
    public List<QuestionResponseDto> getAllQuestions() {
        List<Question> questions = questionRepository.findAll();
        return questions.stream()
                .map(question -> modelMapper.map(question, QuestionResponseDto.class))
                .collect(Collectors.toList());
    }


    @Override
    @Transactional
    public QuestionDto createQuestion(QuestionDto questionDto) {
        try {
            Question question = modelMapper.map(questionDto, Question.class);
            Question savedQuestion = questionRepository.save(question);
            return modelMapper.map(savedQuestion, QuestionDto.class);
        } catch (Exception e) {

            throw new RuntimeException("Failed to create question: " + e.getMessage());
        }
    }
//@Transactional
//public QuestionDto createQuestion(QuestionDto questionDto, MediaDto mediaDto, Long selectedMediaId) {
//    Question question = modelMapper.map(questionDto, Question.class);
//
//    // Case 1: Associate existing media
//    if (selectedMediaId != null) {
//        Optional<Media> optionalMedia = mediaRepository.findById(selectedMediaId);
//        if (optionalMedia.isPresent()) {
//            Media media = optionalMedia.get();
//            media.getQuestions().add(question);
//            question.getMedias().add(media);
//        } else {
//            throw new IllegalArgumentException("Media with ID " + selectedMediaId + " not found");
//        }
//    }
//
//    // Case 2: Create new media and associate it
//    if (mediaDto != null) {
//        Media media = modelMapper.map(mediaDto, Media.class);
//        // Save the new media
//        Media savedMedia = mediaRepository.save(media);
//        savedMedia.getQuestions().add(question);
//        question.getMedias().add(savedMedia);
//    }
//
//    // Save the question
//    Question savedQuestion = questionRepository.save(question);
//    return modelMapper.map(savedQuestion, QuestionDto.class);
//}






    @Transactional
    public boolean deleteQuestion(Long questionId) {
        Optional<Question> optionalQuestion = questionRepository.findById(questionId);

        if (optionalQuestion.isPresent()) {
            questionRepository.delete(optionalQuestion.get());
            return true;
        } else {
            return false;
        }
    }
    @Transactional
    public QuestionResponseDto updateQuestion(Long questionId, QuestionDto updatedQuestionDto) {
        Question existingQuestion = questionRepository.findById(questionId)
                .orElseThrow(() -> new EntityNotFoundException("Question not found with id: " + questionId));

        existingQuestion.setText(updatedQuestionDto.getText());

        if (updatedQuestionDto.getSubject_id() != null) {
            Subject subject = subjectRepository.findById(updatedQuestionDto.getSubject_id())
                    .orElseThrow(() -> new EntityNotFoundException("Subject not found with id: " + updatedQuestionDto.getSubject_id()));
            existingQuestion.setSubject(subject);
        }

        if (updatedQuestionDto.getLevel_id() != null) {
            Level level = levelRepository.findById(updatedQuestionDto.getLevel_id())
                    .orElseThrow(() -> new EntityNotFoundException("Level not found with id: " + updatedQuestionDto.getLevel_id()));
            existingQuestion.setLevel(level);
        }

        return modelMapper.map(questionRepository.save(existingQuestion), QuestionResponseDto.class);
    }
}

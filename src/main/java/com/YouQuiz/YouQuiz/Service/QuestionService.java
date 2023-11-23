package com.YouQuiz.YouQuiz.Service;

import com.YouQuiz.YouQuiz.DTOs.*;
import com.YouQuiz.YouQuiz.Entities.*;
import com.YouQuiz.YouQuiz.Mappers.QuestionMapper;
import com.YouQuiz.YouQuiz.Mappers.SubjectMapper;
import com.YouQuiz.YouQuiz.Repositories.AnswerRepository;
import com.YouQuiz.YouQuiz.Repositories.LevelRepository;
import com.YouQuiz.YouQuiz.Repositories.QuestionRepository;
import com.YouQuiz.YouQuiz.Repositories.SubjectRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public interface QuestionService{
        List<QuestionResponseDto> getAllQuestions();
        QuestionDto createQuestion(QuestionDto questionDto);
        boolean deleteQuestion(Long questionId);
        QuestionResponseDto updateQuestion(Long questionId, QuestionDto updatedQuestion);
        }
//    private final QuestionRepository questionRepository;
//    private final LevelRepository questionRepository;
//
//    private final SubjectRepository subjectRepository;
//   // private final QuestionMapper questionMapper;
//   private final ModelMapper modelMapper;
//    @Autowired
//    public QuestionService(QuestionRepository questionRepository, ModelMapper modelMapper , LevelRepository levelRepository , SubjectRepository subjectRepository) {
//        this.questionRepository = questionRepository;
//        this.modelMapper = modelMapper;
//        this.levelRepository = levelRepository;
//        this.subjectRepository = subjectRepository;
//    }

//    @Transactional
//    public QuestionDto createQuestion(Question question) {
//        return questionRepository.save(question);
//    }
//@Transactional
//public QuestionDto createQuestion(QuestionDto questionDto) {
//    Question question = questionMapper.convertToEntity(questionDto);
//    Question savedQuestion = questionRepository.save(question);
//    return questionMapper.convertToDto(savedQuestion);
//}
//@Transactional
//public QuestionDto createQuestion(QuestionDto questionDto) {
//    Question question = modelMapper.map(questionDto, Question.class);
//    Question savedQuestion = questionRepository.save(question);
//    return modelMapper.map(savedQuestion, QuestionDto.class);
//}


//    public List<Question> getAllQuestions() {
//        return questionRepository.findAll();
//    }





//
//    @Transactional
//    public List<QuestionDto> getAllQuestions() {
//        List<Question> questions = questionRepository.findAll();
//        return questions.stream()
//                .map(question -> modelMapper.map(question, QuestionDto.class))
//                .collect(Collectors.toList());
//    }
//
//
//    @Transactional
//    public boolean deleteQuestion(Long questionId) {
//        Optional<Question> optionalQuestion = questionRepository.findById(questionId);
//
//        if (optionalQuestion.isPresent()) {
//            questionRepository.delete(optionalQuestion.get());
//            return true;
//        } else {
//            return false;
//        }
//    }
//

//    @Transactional
//    public QuestionDto updateQuestion(Long questionId, QuestionDto updatedQuestionDto) {
//        Question existingQuestion = questionRepository.findById(questionId)
//                .orElseThrow(() -> new EntityNotFoundException("Question not found with id: " + questionId));
//
//        existingQuestion.setText(updatedQuestionDto.getText());
//
//        if (updatedQuestionDto.getSubject_id() != null) {
//            Subject subject = subjectRepository.findById(updatedQuestionDto.getSubject_id())
//                    .orElseThrow(() -> new EntityNotFoundException("Subject not found with id: " + updatedQuestionDto.getSubject_id()));
//            existingQuestion.setSubject(subject);
//        }
//
//        // Set Level if level_id is not null
//        if (updatedQuestionDto.getLevel_id() != null) {
//            Level level = levelRepository.findById(updatedQuestionDto.getLevel_id())
//                    .orElseThrow(() -> new EntityNotFoundException("Level not found with id: " + updatedQuestionDto.getLevel_id()));
//            existingQuestion.setLevel(level);
//        }
//
//        return questionMapper.convertToDto(questionRepository.save(existingQuestion));
//    }
















//    public Question updateQuestion(Long questionId, Question updatedQuestion) {
//        Question existingQuestion = questionRepository.findById(questionId)
//                .orElseThrow(() -> new EntityNotFoundException("Question not found with id: " + questionId));
//
//        existingQuestion.setText(updatedQuestion.getText());
//        existingQuestion.setSubject(updatedQuestion.getSubject());
//        existingQuestion.setLevel(updatedQuestion.getLevel());
//
//        return questionRepository.save(existingQuestion);
//    }

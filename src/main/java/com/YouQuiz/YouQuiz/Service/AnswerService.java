package com.YouQuiz.YouQuiz.Service;

import com.YouQuiz.YouQuiz.DTOs.AnswerDto;
import com.YouQuiz.YouQuiz.DTOs.AnswerResponseDto;
import com.YouQuiz.YouQuiz.DTOs.PointDto;
import com.YouQuiz.YouQuiz.Entities.Answer;
import com.YouQuiz.YouQuiz.Entities.Point;
import com.YouQuiz.YouQuiz.Mappers.MappingConfig;
import com.YouQuiz.YouQuiz.Repositories.AnswerRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service

    public interface AnswerService {
         List<AnswerResponseDto> getAllAnswers();
         AnswerDto createAnswer(AnswerDto answerDto);
         boolean deleteAnswer(Long answerId);
         AnswerResponseDto updateAnswer(Long answerId, AnswerDto updatedAnswer);
}



//    private final AnswerRepository answerRepository;
//    private final MappingConfig mappingConfig;
//
//    public AnswerService(AnswerRepository answerRepository, MappingConfig mappingConfig) {
//        this.answerRepository = answerRepository;
//        this.mappingConfig = mappingConfig;
//    }
//
//    @Transactional
//    public List<AnswerDto> getAllAnswers() {
//        List<Answer> answers = answerRepository.findAll();
//        return answers.stream()
//                .map(mappingConfig::mapToDto)
//                .collect(Collectors.toList());
//    }

//    @Transactional
//    public AnswerDto createAnswer(AnswerDto answerDto) {
//        Answer answer = modelMapper.map(answerDto, Answer.class);
//        Answer savedAnswer = answerRepository.save(answer);
//        return modelMapper.map(savedAnswer, AnswerDto.class);
//    }

//    @Transactional
//    public List<AnswerDto> getAllAnswers() {
//        List<Answer> answers = answerRepository.findAll();
//        return answers.stream()
//                .map(answer -> modelMapper.map(answer, AnswerDto.class))
//                .collect(Collectors.toList());
//    }



//    public List<Answer> getAllAnswers() {
//        return answerRepository.findAll();
//    }
//    @Transactional
//    public Answer createAnswer(Answer answer) {
//        return answerRepository.save(answer);
//    }
//    @Transactional
//    public boolean deleteAnswer(Long answerId) {
//        Optional<Answer> optionalAnswer = answerRepository.findById(answerId);
//
//        if (optionalAnswer.isPresent()) {
//            answerRepository.delete(optionalAnswer.get());
//            return true;
//        } else {
//            return false;
//        }
//    }
//    @Transactional
//    public Answer updateAnswer(Long answerId, Answer updatedAnswer) {
//        Answer existingAnswer = answerRepository.findById(answerId)
//                .orElseThrow(() -> new EntityNotFoundException("Answer not found with id: " + answerId));
//
//        existingAnswer.setText(updatedAnswer.getText());
//
//        return answerRepository.save(existingAnswer);
//    }
//
//}
//@Service
//public class AnswerService {
//    private final AnswerRepository answerRepository;
//    private final AnswerMapper answerMapper;
//
//    @Autowired
//    public AnswerService(AnswerRepository answerRepository, AnswerMapper answerMapper) {
//        this.answerRepository = answerRepository;
//        this.answerMapper = answerMapper;
//    }
//
//    public AnswerDto createAnswer(AnswerDto answerDto) {
//        Answer answer = answerMapper.toEntity(answerDto);
//        Answer savedAnswer = answerRepository.save(answer);
//        return answerMapper.toDto(savedAnswer);
//    }
//}
//    AnswerDto updateAnswer(Integer answerId, AnswerDto answerDto);
//    AnswerDto getAnswerById(Integer answerId);
//    void deleteAnswer(Integer answerId);


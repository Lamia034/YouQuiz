package com.YouQuiz.YouQuiz.Service.Impl;

import com.YouQuiz.YouQuiz.DTOs.AnswerDto;
import com.YouQuiz.YouQuiz.DTOs.AnswerResponseDto;
import com.YouQuiz.YouQuiz.Entities.Answer;
import com.YouQuiz.YouQuiz.Repositories.AnswerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@Transactional
public class AnswerServiceTest {

    @Mock
    private AnswerRepository answerRepository;

    @Mock
    private ModelMapper modelMapper;
    private AnswerDto answerDto;
    @InjectMocks
    private AnswerServiceImpl answerService;

    @BeforeEach
    public void setUp() {
      //  MockitoAnnotations.initMocks(this);
        answerDto = new AnswerDto();
        answerDto.setText("Test answer");
    }

    @Test
    public void testCreateAnswer() {
        Answer answer = new Answer();
        answer.setText("Test answer");
        Answer savedAnswer = new Answer();
        savedAnswer.setText("Test answer");

        when(modelMapper.map(answerDto, Answer.class)).thenReturn(answer);
        when(answerRepository.save(answer)).thenReturn(savedAnswer);
        when(modelMapper.map(savedAnswer, AnswerDto.class)).thenReturn(answerDto);

        AnswerDto result = answerService.createAnswer(answerDto);

        assertNotNull(result);
        assertEquals("Test answer", result.getText());

        verify(modelMapper).map(answerDto, Answer.class);
        verify(answerRepository).save(answer);
        verify(modelMapper).map(savedAnswer, AnswerDto.class);
    }

    @Test
    public void testDeleteAnswer() {
        Long answerId = 102L;
        Answer answer = new Answer();
        answer.setAnswer_id(answerId);

        when(answerRepository.findById(answerId)).thenReturn(Optional.of(answer));

        boolean result = answerService.deleteAnswer(answerId);

        assertTrue(result);

        verify(answerRepository).findById(answerId);
        verify(answerRepository).delete(answer);
    }

}
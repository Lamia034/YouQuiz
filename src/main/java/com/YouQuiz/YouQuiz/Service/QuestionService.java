package com.YouQuiz.YouQuiz.Service;

import com.YouQuiz.YouQuiz.Entities.Answer;
import com.YouQuiz.YouQuiz.Entities.Level;
import com.YouQuiz.YouQuiz.Entities.Question;
import com.YouQuiz.YouQuiz.Repositories.AnswerRepository;
import com.YouQuiz.YouQuiz.Repositories.QuestionRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Transactional
    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }
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
    public Question updateQuestion(Long questionId, Question updatedQuestion) {
        Question existingQuestion = questionRepository.findById(questionId)
                .orElseThrow(() -> new EntityNotFoundException("Question not found with id: " + questionId));

        existingQuestion.setText(updatedQuestion.getText());
        existingQuestion.setSubject(updatedQuestion.getSubject());
        existingQuestion.setLevel(updatedQuestion.getLevel());

        return questionRepository.save(existingQuestion);
    }
}

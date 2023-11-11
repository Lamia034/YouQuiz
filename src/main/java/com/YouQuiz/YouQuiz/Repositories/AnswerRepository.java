package com.YouQuiz.YouQuiz.Repositories;

import com.YouQuiz.YouQuiz.Entities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

}

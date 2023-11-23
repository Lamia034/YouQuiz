package com.YouQuiz.YouQuiz.Repositories;

import com.YouQuiz.YouQuiz.Entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}

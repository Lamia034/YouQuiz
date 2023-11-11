package com.YouQuiz.YouQuiz.Repositories;
import com.YouQuiz.YouQuiz.Entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}

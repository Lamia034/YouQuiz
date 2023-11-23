package com.YouQuiz.YouQuiz.Repositories;
import com.YouQuiz.YouQuiz.Entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}

package com.YouQuiz.YouQuiz.Repositories;

import com.YouQuiz.YouQuiz.DTOs.AssignQuizDto;
import com.YouQuiz.YouQuiz.Entities.AssignQuiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignQuizRepository extends JpaRepository<AssignQuiz, Long> {
}

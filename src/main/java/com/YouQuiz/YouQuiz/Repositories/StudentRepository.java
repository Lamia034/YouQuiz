package com.YouQuiz.YouQuiz.Repositories;

import com.YouQuiz.YouQuiz.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}

package com.YouQuiz.YouQuiz.Repositories;

import com.YouQuiz.YouQuiz.Entities.Point;
import com.YouQuiz.YouQuiz.Entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointRepository extends JpaRepository<Point, Long> {
}

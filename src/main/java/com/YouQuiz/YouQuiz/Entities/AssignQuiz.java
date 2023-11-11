package com.YouQuiz.YouQuiz.Entities;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name="assignquiz")
@NoArgsConstructor
@AllArgsConstructor
public class AssignQuiz {
    @Id
    @GeneratedValue
    private Long assignquiz_id;
    @ManyToOne
    @JoinColumn(name ="quiz_id")
    private Quiz quiz;
    @ManyToOne
    @JoinColumn(name= "student_id")
    private Student student;

    private LocalDateTime startIn;
    private LocalDateTime endIn;
    @ManyToMany
            //(mappedBy = "assignQuizs")
    private List<Point> points;
}

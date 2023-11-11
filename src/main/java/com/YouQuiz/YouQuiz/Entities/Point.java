package com.YouQuiz.YouQuiz.Entities;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity

@Table(name="point")
@NoArgsConstructor
@AllArgsConstructor
public class Point {
    @Id
    @GeneratedValue
    private Long point_id;
    private Integer point;
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "answer_id")
    private Answer answer;
    @ManyToMany
         //   (mappedBy = "points")
    private List<AssignQuiz> assignQuizs;
}


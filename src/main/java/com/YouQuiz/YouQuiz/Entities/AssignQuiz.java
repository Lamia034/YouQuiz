package com.YouQuiz.YouQuiz.Entities;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startInDate;

    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime startInTime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endInDate;

    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime endInTime;
    @ManyToMany
            //(mappedBy = "assignQuizs")
    private List<Point> points;
}

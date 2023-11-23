package com.YouQuiz.YouQuiz.DTOs;
import com.YouQuiz.YouQuiz.Entities.Point;
import com.YouQuiz.YouQuiz.Entities.Quiz;
import com.YouQuiz.YouQuiz.Entities.Student;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssignQuizResponseDto {
    private Long assignquiz_id;

    private QuizDto quiz;

    private StudentDto student;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startInDate;

    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime startInTime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endInDate;

    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime endInTime;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    private LocalDateTime startIn;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    private LocalDateTime endIn;
    private List<PointDto> points;
}

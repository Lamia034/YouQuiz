package com.YouQuiz.YouQuiz.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PointResponseDto {
    private Long point_id;
    private AnswerDto answer;
    private QuestionDto question;
    private Integer point;
}

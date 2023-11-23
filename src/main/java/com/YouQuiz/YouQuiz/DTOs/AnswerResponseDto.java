package com.YouQuiz.YouQuiz.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerResponseDto {
    private Long answer_id;
    private String text;
    private List<PointDto> points;
}

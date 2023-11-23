package com.YouQuiz.YouQuiz.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LevelResponseDto {
    private Long level_id;
    private String description;
    private Integer maxPoints;
    private Integer minPoints;
    private List<QuestionDto> questions;
}

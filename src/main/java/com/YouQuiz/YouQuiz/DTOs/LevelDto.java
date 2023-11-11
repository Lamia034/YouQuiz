package com.YouQuiz.YouQuiz.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LevelDto {
    private Long level_id;

    private String description;

    private Integer maxPoints;

    private Integer minPoints;
}

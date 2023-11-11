package com.YouQuiz.YouQuiz.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {
    private Long question_id;
    private String text;
    private Long subject_id;
    private Long level_id;
}

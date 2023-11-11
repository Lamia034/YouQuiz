package com.YouQuiz.YouQuiz.DTOs;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerDto {
    private Long answer_id;
    private String text;
}

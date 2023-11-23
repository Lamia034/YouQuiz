package com.YouQuiz.YouQuiz.DTOs;

import com.YouQuiz.YouQuiz.Enum.QuestionType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
    @Enumerated(EnumType.STRING)
    private QuestionType question_type;
 //   private Long media_id;
 //   private Long selectedMediaId;
  //  private SubjectResponseDto subject;
//    private LevelDto level;
}

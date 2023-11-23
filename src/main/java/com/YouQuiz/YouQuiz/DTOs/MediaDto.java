package com.YouQuiz.YouQuiz.DTOs;

import com.YouQuiz.YouQuiz.Entities.Question;
import com.YouQuiz.YouQuiz.Enum.MediaType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MediaDto {
    @Id
    @GeneratedValue
    private Long media_id;
    private String title;
private Long question_id;
  //  private List<QuestionDto> questions;
    @Enumerated(EnumType.STRING)
    private MediaType media_type;

}

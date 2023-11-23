package com.YouQuiz.YouQuiz.DTOs;

import com.YouQuiz.YouQuiz.Enum.MediaType;
import com.YouQuiz.YouQuiz.Enum.QuestionType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionResponseDto {
    private Long question_id;
    private String text;
    private SubjectDto subject;
    private LevelDto level;
//private MediaDto media;
    @Enumerated(EnumType.STRING)
    private QuestionType question_type;
    private List<MediaDto> medias;
}

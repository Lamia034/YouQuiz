package com.YouQuiz.YouQuiz.DTOs;

import com.YouQuiz.YouQuiz.Enum.MediaType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MediaResponseDto {
    @Id
    @GeneratedValue
    private Long media_id;
    private String title;

    @Enumerated(EnumType.STRING)
    private MediaType media_type;
    private QuestionDto question;
   // private List<QuestionDto> questions;
}

package com.YouQuiz.YouQuiz.DTOs;

import com.YouQuiz.YouQuiz.Entities.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class SubjectResponseDto {
        private Long subject_id;
        private String title;
        private SubjectResponseDto parent;
        private List<SubjectDto> children;
}


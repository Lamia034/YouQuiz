package com.YouQuiz.YouQuiz.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDto {
    private Long subject_id;
    private String title;
    private Long parent_id;
}

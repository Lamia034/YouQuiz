package com.YouQuiz.YouQuiz.DTOs;

import java.time.LocalDate;

import com.YouQuiz.YouQuiz.Entities.AssignQuiz;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponseDto {
    private Long student_id;
    private String name;
    private String prenoun;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    private String address;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate registrationDate;
    private List<AssignQuizDto> assignQuizs;
}

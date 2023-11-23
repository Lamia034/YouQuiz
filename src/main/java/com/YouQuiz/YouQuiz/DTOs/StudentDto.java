package com.YouQuiz.YouQuiz.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto{
    private Long student_id;
    private String name;
    private String prenoun;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    private String address;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate registrationDate;
}

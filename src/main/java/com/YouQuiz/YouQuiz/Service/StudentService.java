package com.YouQuiz.YouQuiz.Service;

import com.YouQuiz.YouQuiz.DTOs.FormatorDto;
import com.YouQuiz.YouQuiz.DTOs.FormatorResponseDto;
import com.YouQuiz.YouQuiz.DTOs.StudentDto;
import com.YouQuiz.YouQuiz.DTOs.StudentResponseDto;

import java.util.List;

public interface StudentService {
    List<StudentResponseDto> getAllStudents();
    StudentDto createStudent(StudentDto studentDto);
    boolean deleteStudent(Long studentId);
    StudentResponseDto updateStudent(Long studentId, StudentDto updatedStudent);
}

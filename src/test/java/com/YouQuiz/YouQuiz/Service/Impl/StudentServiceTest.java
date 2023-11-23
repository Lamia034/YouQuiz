package com.YouQuiz.YouQuiz.Service.Impl;

import com.YouQuiz.YouQuiz.DTOs.StudentDto;
import com.YouQuiz.YouQuiz.DTOs.StudentResponseDto;
import com.YouQuiz.YouQuiz.Entities.Student;
import com.YouQuiz.YouQuiz.Repositories.StudentRepository;
import com.YouQuiz.YouQuiz.Service.Impl.StudentServiceImpl;
import com.YouQuiz.YouQuiz.Service.StudentService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private StudentServiceImpl studentService;

    @Test
    void createStudent() {

        StudentDto studentDTO = new StudentDto(1L, "John Doe", "Mr.", LocalDate.of(2000, 1, 1), "123 Main St", LocalDate.now());
        Student student = new Student();
        when(modelMapper.map(studentDTO, Student.class)).thenReturn(student);
        when(studentRepository.save(student)).thenReturn(student);
        when(modelMapper.map(student, StudentDto.class)).thenReturn(studentDTO);


        StudentDto result = studentService.createStudent(studentDTO);

        assertSame(studentDTO, result);
        verify(studentRepository, times(1)).save(student);
        verify(modelMapper, times(1)).map(studentDTO, Student.class);
        verify(modelMapper, times(1)).map(student, StudentDto.class);
    }
}
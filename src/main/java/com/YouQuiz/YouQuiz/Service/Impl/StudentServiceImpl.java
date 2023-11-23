package com.YouQuiz.YouQuiz.Service.Impl;

import com.YouQuiz.YouQuiz.DTOs.StudentDto;
import com.YouQuiz.YouQuiz.DTOs.FormatorResponseDto;
import com.YouQuiz.YouQuiz.DTOs.StudentResponseDto;
import com.YouQuiz.YouQuiz.Entities.Formator;
import com.YouQuiz.YouQuiz.Entities.Student;
import com.YouQuiz.YouQuiz.Repositories.FormatorRepository;
import com.YouQuiz.YouQuiz.Repositories.StudentRepository;
import com.YouQuiz.YouQuiz.Service.StudentService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    public StudentServiceImpl(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }



//    @Transactional
//    public StudentDto createStudent(StudentDto studentDto) {
//        Student student = modelMapper.map(studentDto, Student.class);
//        Student savedStudent = studentRepository.save(student);
//        return modelMapper.map(savedStudent, StudentDto.class);
//    }
@Override
@Transactional
public StudentDto createStudent(StudentDto studentDto) {
    try {
        Student student = modelMapper.map(studentDto, Student.class);
        Student savedStudent = studentRepository.save(student);
        return modelMapper.map(savedStudent, StudentDto.class);
    } catch (Exception e) {

        throw new RuntimeException("Failed to create student: " + e.getMessage());
    }
}
    @Override
    @Transactional
    public List<StudentResponseDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(student -> modelMapper.map(student, StudentResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public boolean deleteStudent(Long studentId) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if (optionalStudent.isPresent()) {
            studentRepository.delete(optionalStudent.get());
            return true;
        } else {
            throw new RuntimeException("Student not found");
        }
    }

    @Override
    @Transactional
    public StudentResponseDto updateStudent(Long studentId, StudentDto updatedStudentDto) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            if (updatedStudentDto.getName() != null) {
                student.setName(updatedStudentDto.getName());
            }
            if (updatedStudentDto.getAddress() != null) {
                student.setAddress(updatedStudentDto.getAddress());
            }
            if (updatedStudentDto.getPrenoun() != null) {
                student.setPrenoun(updatedStudentDto.getPrenoun());
            }
            if (updatedStudentDto.getBirthDate() != null) {
                student.setBirthDate(updatedStudentDto.getBirthDate());
            }
            if (updatedStudentDto.getRegistrationDate() != null) {
                student.setRegistrationDate(updatedStudentDto.getRegistrationDate());
            }
            Student savedStudent = studentRepository.save(student);
            return modelMapper.map(savedStudent, StudentResponseDto.class);
        } else {
            throw new RuntimeException("Student not found");
        }
    }
//    @Transactional
//    public List<StudentResponseDto> getAllStudents() {
//        List<Student> students = studentRepository.findAll();
//        return students.stream()
//                .map(student -> modelMapper.map(student, StudentResponseDto.class))
//                .collect(Collectors.toList());
//    }
//
//    @Transactional
//    public boolean deleteStudent(Long studentId) {
//        Optional<Student> optionalStudent = studentRepository.findById(studentId);
//
//        if (optionalStudent.isPresent()) {
//            studentRepository.delete(optionalStudent.get());
//            return true;
//        } else {
//            return false;
//        }
//    }
//    @Transactional
//    public StudentResponseDto updateStudent(Long studentId, StudentDto updatedStudentDto) {
//        Optional<Student> optionalStudent = studentRepository.findById(studentId);
//        if (optionalStudent.isPresent()) {
//            Student student = optionalStudent.get();
//            student.setName(updatedStudentDto.getName());
//            student.setAddress(updatedStudentDto.getAddress());
//            student.setPrenoun(updatedStudentDto.getPrenoun());
//            student.setBirthDate(updatedStudentDto.getBirthDate());
//            student.setRegistrationDate(updatedStudentDto.getRegistrationDate());
//            Student savedStudent = studentRepository.save(student);
//            return modelMapper.map(savedStudent, StudentResponseDto.class);
//        }
//        return null; // Student not found
//    }
}

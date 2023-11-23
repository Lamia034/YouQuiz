package com.YouQuiz.YouQuiz.Controller;

import com.YouQuiz.YouQuiz.DTOs.FormatorDto;
import com.YouQuiz.YouQuiz.DTOs.FormatorResponseDto;
import com.YouQuiz.YouQuiz.DTOs.StudentDto;
import com.YouQuiz.YouQuiz.DTOs.StudentResponseDto;
import com.YouQuiz.YouQuiz.Service.FormatorService;
import com.YouQuiz.YouQuiz.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


    @RestController
    @RequestMapping("/students")
    public class StudentController {
        private final StudentService studentService;


        @Autowired
        public StudentController(StudentService studentService) {
            this.studentService = studentService;

        }

//        @PostMapping
//        public StudentDto createStudent(@RequestBody StudentDto studentDto) {
//            return studentService.createStudent(studentDto);
//        }
@PostMapping
public ResponseEntity<Object> createStudent(@RequestBody StudentDto studentDto) {
    try {
        StudentDto createdStudent = studentService.createStudent(studentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create student: " + e.getMessage());
    }
}
        @GetMapping
        public List<StudentResponseDto> getAllStudents() {
            return studentService.getAllStudents();
        }

        @DeleteMapping("/{studentId}")
        public ResponseEntity<String> deleteStudent(@PathVariable Long studentId) {
            try {
                boolean deleted = studentService.deleteStudent(studentId);
                if (deleted) {
                    return ResponseEntity.ok("Student deleted successfully");
                } else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
                }
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete student: " + e.getMessage());
            }
        }

        @PutMapping("/{studentId}")
        public ResponseEntity<Object> updateStudent(@PathVariable Long studentId, @RequestBody StudentDto updatedStudentDto) {
            try {
                StudentResponseDto updatedStudent = studentService.updateStudent(studentId, updatedStudentDto);
                return ResponseEntity.ok(updatedStudent);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update student: " + e.getMessage());
            }
        }
    }
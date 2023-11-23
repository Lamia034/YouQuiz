package com.YouQuiz.YouQuiz.Controller;

import com.YouQuiz.YouQuiz.DTOs.FormatorDto;
import com.YouQuiz.YouQuiz.DTOs.FormatorResponseDto;
import com.YouQuiz.YouQuiz.Service.FormatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/formators")
public class FormatorController {
    private final FormatorService formatorService;


    @Autowired
    public FormatorController(FormatorService formatorService) {
        this.formatorService = formatorService;

    }

    @PostMapping
    public FormatorDto createFormator(@RequestBody FormatorDto formatorDto) {
        return formatorService.createFormator(formatorDto);
    }
    @GetMapping
    public List<FormatorResponseDto> getAllFormators() {
        return formatorService.getAllFormators();
    }

    @DeleteMapping("/{formatorId}")
    public ResponseEntity<String> deleteFormator(@PathVariable Long formatorId) {
        boolean deleted = formatorService.deleteFormator(formatorId);

        if (deleted) {
            return new ResponseEntity<>("Formator deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Formator not found", HttpStatus.NOT_FOUND);
        }
    }
//    @PutMapping("/{formatorId}")
//    public FormatorResponseDto updateFormator(@PathVariable Long formatorId, @RequestBody FormatorDto updatedFormator) {
//        return formatorService.updateFormator(formatorId, updatedFormator);
//    }
}

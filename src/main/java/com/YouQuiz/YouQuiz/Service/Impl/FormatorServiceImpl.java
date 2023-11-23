package com.YouQuiz.YouQuiz.Service.Impl;

import com.YouQuiz.YouQuiz.DTOs.AnswerDto;
import com.YouQuiz.YouQuiz.DTOs.AnswerResponseDto;
import com.YouQuiz.YouQuiz.DTOs.FormatorDto;
import com.YouQuiz.YouQuiz.DTOs.FormatorResponseDto;
import com.YouQuiz.YouQuiz.Entities.Answer;
import com.YouQuiz.YouQuiz.Entities.Formator;
import com.YouQuiz.YouQuiz.Repositories.AnswerRepository;
import com.YouQuiz.YouQuiz.Repositories.FormatorRepository;
import com.YouQuiz.YouQuiz.Service.FormatorService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class FormatorServiceImpl implements FormatorService {
    private final FormatorRepository formatorRepository;
    private final ModelMapper modelMapper;

    public FormatorServiceImpl(FormatorRepository formatorRepository, ModelMapper modelMapper) {
        this.formatorRepository = formatorRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public List<FormatorResponseDto> getAllFormators() {
        List<Formator> formators = formatorRepository.findAll();
        return formators.stream()
                .map(formator -> modelMapper.map(formator, FormatorResponseDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public FormatorDto createFormator(FormatorDto formatorDto) {
        Formator formator = modelMapper.map(formatorDto, Formator.class);
        Formator savedFormator = formatorRepository.save(formator);
        return modelMapper.map(savedFormator, FormatorDto.class);
    }

    @Transactional
    public boolean deleteFormator(Long formatorId) {
        Optional<Formator> optionalFormator = formatorRepository.findById(formatorId);

        if (optionalFormator.isPresent()) {
            formatorRepository.delete(optionalFormator.get());
            return true;
        } else {
            return false;
        }
    }
//    @Transactional
//    public FormatorResponseDto updateFormator(Long formatorId, FormatorDto updatedFormatorDto) {
//        Optional<Formator> optionalFormator = formatorRepository.findById(formatorId);
//        if (optionalFormator.isPresent()) {
//            Formator formator = optionalFormator.get();
//            formator.setName(updatedFormatorDto.getName());
//            formator.setAddress(updatedFormatorDto.getAddress());
//            formator.setPrenoun(updatedFormatorDto.getPrenoun());
//            formator.setBirthDate(updatedFormatorDto.getBirthDate());
//            formator.setSpecialty(updatedFormatorDto.getSpecialty());
//            Formator savedFormator = formatorRepository.save(formator);
//            return modelMapper.map(savedFormator, FormatorResponseDto.class);
//        }
//        return null; // Formator not found
//    }
}

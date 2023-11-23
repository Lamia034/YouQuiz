package com.YouQuiz.YouQuiz.Service;

import com.YouQuiz.YouQuiz.DTOs.*;
import com.YouQuiz.YouQuiz.Entities.Answer;
import com.YouQuiz.YouQuiz.Entities.Question;
import com.YouQuiz.YouQuiz.Entities.Subject;
import com.YouQuiz.YouQuiz.Mappers.SubjectMapper;
import com.YouQuiz.YouQuiz.Repositories.QuestionRepository;
import com.YouQuiz.YouQuiz.Repositories.SubjectRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public interface SubjectService {
    List<SubjectResponseDto> getAllSubjects();
    SubjectDto createSubject(SubjectDto subjectDto);
    boolean deleteSubject(Long subjectId);
    SubjectResponseDto updateSubject(Long subjectId, SubjectDto updatedSubject);
}
//    private final SubjectRepository subjectRepository;
//    private final ModelMapper modelMapper;
//
//    public SubjectService(SubjectRepository subjectRepository, ModelMapper modelMapper) {
//        this.subjectRepository = subjectRepository;
//        this.modelMapper = modelMapper;
//    }
//@Transactional
//public List<SubjectResponseDto> getAllSubjects() {
//    List<Subject> subjects = subjectRepository.findAll();
//    return subjects.stream()
//            .map(subject -> modelMapper.map(subject, SubjectResponseDto.class))
//            .collect(Collectors.toList());
//}

//    public Subject createSubject(Subject subject) {
//        return subjectRepository.save(subject);
//    }

//    public SubjectDto createSubject(SubjectDto subjectDto) {
//        Subject subject = subjectMapper.convertToEntity(subjectDto);
//        Subject savedSubject = subjectRepository.save(subject);
//        return subjectMapper.convertToDto(savedSubject);
//    }
//    public List<Subject> getAllSubjects() {
//        return subjectRepository.findAll();
//
//    }


//    @Transactional
//    public boolean deleteSubject(Long subjectId) {
//        Optional<Subject> optionalSubject = subjectRepository.findById(subjectId);
//
//        if (optionalSubject.isPresent()) {
//            subjectRepository.delete(optionalSubject.get());
//            return true;
//        } else {
//            return false;
//        }
//    }
//    @Transactional
//    public Subject updateSubject(Long subjectId, Subject updatedSubject) {
//        Subject existingSubject = subjectRepository.findById(subjectId)
//                .orElseThrow(() -> new EntityNotFoundException("Subject not found with id: " + subjectId));
//
//        existingSubject.setTitle(updatedSubject.getTitle());
//        existingSubject.setSubject_id(updatedSubject.getSubject_id());
//        existingSubject.setParent(updatedSubject.getParent());
//
//        return subjectRepository.save(existingSubject);
//    }

//    @Transactional
//    public SubjectDto updateSubject(Long subjectId, SubjectDto updatedSubjectDto) {
//        Subject existingSubject = subjectRepository.findById(subjectId)
//                .orElseThrow(() -> new EntityNotFoundException("Subject not found with id: " + subjectId));
//
//        existingSubject.setTitle(updatedSubjectDto.getTitle());
//
//        Long parent_id = updatedSubjectDto.getParent_id();
//        if (parent_id != null) {
//
//            Subject parent = subjectRepository.findById(parent_id)
//                    .orElseThrow(() -> new EntityNotFoundException("Parent Subject not found with id: " + parent_id));
//
//            existingSubject.setParent(parent);
//        }
//        return subjectMapper.convertToDto(subjectRepository.save(existingSubject));
//    }



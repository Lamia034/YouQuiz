package com.YouQuiz.YouQuiz.Service.Impl;

import com.YouQuiz.YouQuiz.DTOs.*;
import com.YouQuiz.YouQuiz.Entities.Answer;
import com.YouQuiz.YouQuiz.Entities.Level;
import com.YouQuiz.YouQuiz.Entities.Question;
import com.YouQuiz.YouQuiz.Entities.Subject;
import com.YouQuiz.YouQuiz.Repositories.AnswerRepository;
import com.YouQuiz.YouQuiz.Repositories.SubjectRepository;
import com.YouQuiz.YouQuiz.Service.SubjectService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepository subjectRepository;
    private final ModelMapper modelMapper;

    public SubjectServiceImpl(SubjectRepository subjectRepository, ModelMapper modelMapper) {
        this.subjectRepository = subjectRepository;
        this.modelMapper = modelMapper;
    }
    @Transactional
//    public SubjectDto createSubject(SubjectDto subjectDto) {
//        Subject subject = modelMapper.map(subjectDto, Subject.class);
//        Subject savedSubject = subjectRepository.save(subject);
//        return modelMapper.map(savedSubject, SubjectDto.class);
//    }
    public SubjectDto createSubject(SubjectDto subjectDto) {
        Subject subject = modelMapper.map(subjectDto, Subject.class);
        if(subjectDto.getParent_id() != 0)
            subject.setParent(subjectRepository.findById(
                    subjectDto.getParent_id()
            ).get());
        return modelMapper.map(subjectRepository.save(subject), SubjectDto.class);
    }

    //@Override
//@Transactional
//public SubjectDto createSubject(SubjectDto subjectDto) {
//    try {
//        Subject subject = modelMapper.map(subjectDto, Subject.class);
//        Subject savedSubject = subjectRepository.save(subject);
//        return modelMapper.map(savedSubject, SubjectDto.class);
//    } catch (Exception e) {
//
//        throw new RuntimeException("Failed to create subject: " + e.getMessage());
//    }
//}
    @Transactional
    public List<SubjectResponseDto> getAllSubjects() {
        List<Subject> subjects = subjectRepository.findAll();
        return subjects.stream()
                .map(subject -> modelMapper.map(subject, SubjectResponseDto.class))
                .collect(Collectors.toList());
    }
    @Transactional
    public boolean deleteSubject(Long subjectId) {
        Optional<Subject> optionalSubject = subjectRepository.findById(subjectId);

        if (optionalSubject.isPresent()) {
            subjectRepository.delete(optionalSubject.get());
            return true;
        } else {
            return false;
        }
    }
    @Transactional
    public SubjectResponseDto updateSubject(Long subjectId, SubjectDto updatedSubjectDto) {
        Subject existingSubject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new EntityNotFoundException("Subject not found with id: " + subjectId));

        existingSubject.setTitle(updatedSubjectDto.getTitle());

        if (updatedSubjectDto.getSubject_id() != null) {
            Subject subject = subjectRepository.findById(updatedSubjectDto.getParent_id())
                    .orElseThrow(() -> new EntityNotFoundException("Subject parent not found with id: " + updatedSubjectDto.getParent_id()));
            existingSubject.setParent(subject);
        }



        return modelMapper.map(subjectRepository.save(existingSubject), SubjectResponseDto.class);
    }


}

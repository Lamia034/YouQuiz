package com.YouQuiz.YouQuiz.Service;

import com.YouQuiz.YouQuiz.Entities.Question;
import com.YouQuiz.YouQuiz.Entities.Subject;
import com.YouQuiz.YouQuiz.Repositories.QuestionRepository;
import com.YouQuiz.YouQuiz.Repositories.SubjectRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Transactional
    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
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
    public Subject updateSubject(Long subjectId, Subject updatedSubject) {
        Subject existingSubject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new EntityNotFoundException("Subject not found with id: " + subjectId));

        existingSubject.setTitle(updatedSubject.getTitle());
        existingSubject.setSubject_id(updatedSubject.getSubject_id());
        existingSubject.setParent(updatedSubject.getParent());

        return subjectRepository.save(existingSubject);
    }
}

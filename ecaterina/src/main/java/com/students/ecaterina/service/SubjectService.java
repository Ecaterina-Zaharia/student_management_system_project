package com.students.ecaterina.service;

import com.students.ecaterina.models.dtos.SubjectDTO;
import com.students.ecaterina.models.entities.Subject;
import com.students.ecaterina.repositories.SubjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public SubjectDTO getSubjectById(Long id){
        Subject subject = subjectRepository.getReferenceById(id);

        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setName(subject.getName());

        return subjectDTO;
    }


    public void createSubject(SubjectDTO subjectDTO){
        Subject subject = new Subject();

        subject.setName(subjectDTO.getName());

        subjectRepository.save(subject);
    }

    public void updateSubjectName(Long id, String newName){
        Optional<Subject> optionalSubject = subjectRepository.findById(id);
        if(optionalSubject.isPresent()){
            Subject subject = optionalSubject.get();
            subject.setName(newName);
            subjectRepository.save(subject);
        } else {
            throw new IllegalArgumentException("Subject with id " + id + " not found");
        }
    }

    public void deleteSubjectById(Long id){
        this.subjectRepository.deleteById(id);
    }

}

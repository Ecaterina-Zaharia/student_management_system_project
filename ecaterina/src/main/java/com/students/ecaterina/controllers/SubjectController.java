package com.students.ecaterina.controllers;

import com.students.ecaterina.models.dtos.SubjectDTO;
import com.students.ecaterina.models.entities.Teacher;
import com.students.ecaterina.service.SubjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//http://localhost:8080/api/v1/subjects
@RestController
@RequestMapping("/subjects")
public class SubjectController {

    public final SubjectService subjectService;


    public SubjectController(SubjectService subjectService) {

        this.subjectService = subjectService;
    }

    @GetMapping("/{id}") //http://localhost:8080/api/v1/subjects/{id}
    public SubjectDTO getSubjectById(@PathVariable("id")long id){

        return subjectService.getSubjectById(id);
    }

    @PostMapping("/new") //http://localhost:8080/api/v1/subjects/new
    public ResponseEntity<?> createSubject(@RequestBody SubjectDTO subjectDTO){
        subjectService.createSubject(subjectDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}") // http://localhost:8080/api/v1/subjects/delete/{id}
    public ResponseEntity<?> deleteSubjectById(@PathVariable("id") Long id){
        subjectService.deleteSubjectById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/edit/{id}") // http://localhost:8080/api/v1/subjects/edit/{id}
    public ResponseEntity<?> updateSubjectName(@PathVariable("id") Long id,
                                               @RequestBody SubjectDTO subjectDTO){
        subjectService.updateSubjectName(id, subjectDTO.getName());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

package com.students.ecaterina.service;

import com.students.ecaterina.models.entities.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    void saveStudents(Student student);

    Student getStudentById(long id);

    void deleteStudentById(long id);
}

package com.students.ecaterina.service;

import com.students.ecaterina.models.entities.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> getAllTeachers();

    void saveTeacher(Teacher teacher);


    Teacher getTeacherById(long id);


    void deleteTeacherById(long id);
}

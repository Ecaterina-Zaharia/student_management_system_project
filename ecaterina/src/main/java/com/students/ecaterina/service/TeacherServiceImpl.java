package com.students.ecaterina.service;

import com.students.ecaterina.models.entities.Teacher;
import com.students.ecaterina.repositories.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public void saveTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    public Teacher getTeacherById(long id) {
        Optional<Teacher> optional = teacherRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        } else {
            throw  new RuntimeException("Teacher is not found with id: " + id);
        }
    }

    @Override
    public void deleteTeacherById(long id) {
        teacherRepository.deleteById(id);
    }
}

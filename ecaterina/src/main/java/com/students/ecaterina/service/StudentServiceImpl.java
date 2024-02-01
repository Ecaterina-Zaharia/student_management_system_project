package com.students.ecaterina.service;

import com.students.ecaterina.models.entities.Student;
import com.students.ecaterina.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void saveStudents(Student student) {
        this.studentRepository.save(student);
    }

    @Override
    public Student getStudentById(long id) {
        Optional<Student> optional = studentRepository.findById(id);
        Student student = null;
        if(optional.isPresent()){
            student = optional.get();
        } else {
            throw  new RuntimeException("Student is not found with id: " + id);
        }
        return student;
    }

    @Override
    public void deleteStudentById(long id) {
        this.studentRepository.deleteById(id);
    }


//    public  StudentDTO getUserById(Long id){
//        Student student = studentRepository.getReferenceById(id);
//
//        StudentDTO studentDTO = new StudentDTO();
//        studentDTO.setFirstName(student.getFirstName());
//        studentDTO.setLastName(student.getLastName());
//        studentDTO.setEmail(student.getEmail());
//        return studentDTO;
//    }

//    public void createStudent(StudentDTO studentDTO){
//        Student student = new Student();
//        student.setFirstName(studentDTO.getFirstName());
//        student.setLastName(studentDTO.getLastName());
//        student.setEmail(studentDTO.getEmail());
//
//        studentRepository.save(student);
//    }
}

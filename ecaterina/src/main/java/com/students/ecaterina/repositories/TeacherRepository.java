package com.students.ecaterina.repositories;

import com.students.ecaterina.models.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}

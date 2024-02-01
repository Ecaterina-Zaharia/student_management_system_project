package com.students.ecaterina.repositories;

import com.students.ecaterina.models.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}

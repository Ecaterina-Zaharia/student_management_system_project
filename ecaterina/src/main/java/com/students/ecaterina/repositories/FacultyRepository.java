package com.students.ecaterina.repositories;

import com.students.ecaterina.models.entities.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}

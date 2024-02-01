package com.students.ecaterina;

import com.students.ecaterina.models.entities.Faculty;
import com.students.ecaterina.models.entities.Student;
import com.students.ecaterina.repositories.FacultyRepository;
import com.students.ecaterina.repositories.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class StudentRepositoryTests {

    @Autowired
    private StudentRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void createStudent(){
        Student student = new Student();
        student.setFirstName("John");
        student.setLastName("Smith");
        student.setEmail("john_smith@mail.com");
        student.setPhone("075-456-78-98");

        Student savedStudent = repo.save(student);

        Student retrievedStudent = entityManager.find(Student.class, savedStudent.getId());

        Assertions.assertNotNull(retrievedStudent);
        Assertions.assertEquals(student.getFirstName(), retrievedStudent.getFirstName());
        Assertions.assertEquals(student.getLastName(), retrievedStudent.getLastName());
        Assertions.assertEquals(student.getEmail(), retrievedStudent.getEmail());
        Assertions.assertEquals(student.getPhone(), retrievedStudent.getPhone());

    }

    @Test
    public void testUpdateStudent(){
        Student updateStudent = new Student();
        updateStudent.setId(2l);
        updateStudent.setFirstName("Elena");
        updateStudent.setLastName("Pop");

        repo.save(updateStudent);

    }

    @Test
    public void testRemoveStudent(){
        repo.deleteById(2l);

    }
}

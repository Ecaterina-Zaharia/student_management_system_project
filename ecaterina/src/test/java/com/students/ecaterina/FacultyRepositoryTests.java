package com.students.ecaterina;

import com.students.ecaterina.models.entities.Faculty;
import com.students.ecaterina.repositories.FacultyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class FacultyRepositoryTests {

    @Autowired
    private FacultyRepository repo;

//    @Test
//    public void testCreateFaculty(){
//        Faculty savedFaculty = repo.save(new Faculty("Math"));
//
//        assertThat(savedFaculty.getId()).isGreaterThan(0);
//    }


}

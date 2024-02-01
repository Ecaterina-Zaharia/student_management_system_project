//package com.students.ecaterina;
//
//import com.students.ecaterina.models.entities.Role;
//import com.students.ecaterina.models.entities.AppUser;
//import com.students.ecaterina.repositories.UserRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.annotation.Rollback;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = Replace.NONE)
//@Rollback(false)
//public class AppUserRepositoryTests {
//
//    @Autowired
//    private UserRepository repo;
//
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Test
//    public void test(){
//
//    }
//
//    @Test
//    public void testCreateRoles(){
//        Role roleAdmin = new Role("Administrator");
//        Role roleEditor = new Role("Editor");
//        Role roleVisitor = new Role("Visitor");
//
//        entityManager.persist(roleAdmin);
//        entityManager.persist(roleEditor);
//        entityManager.persist(roleVisitor);
//    }
//
//    @Test
//    public void testCreateNewUserWithOneRole(){
//        Role roleAdmin = entityManager.find(Role.class, 1);
//        AppUser appUser = new AppUser("arnaut@mail.com", "admin44");
//        appUser.addRole(roleAdmin);
//
//        repo.save(appUser);
//    }
//
//    @Test
//    public void testCreateNewUserWithTwoRoles(){
//        Role roleAdmin = entityManager.find(Role.class, 1);
//        Role roleEditor = entityManager.find(Role.class, 3);
//
//        AppUser appUser = new AppUser("grigorescu@mail.com", "editor44");
//        appUser.addRole(roleAdmin);
//        appUser.addRole(roleEditor);
//
//        repo.save(appUser);
//    }
//
//    @Test
//    public void testAssignRoleToExistingUser(){
//        AppUser appUser = repo.findById(1L).get();
//        Role roleEditor = entityManager.find(Role.class, 2);
//        appUser.addRole(roleEditor);
//    }
//
//    @Test
//    public void testRemoveRoleFromExistingUser(){
//        AppUser appUser = repo.findById(1L).get();
//        Role role = new Role(2L);
//        appUser.removeRole(role);
//    }
//
//    @Test
//    public void testCreateNewUserWithNewRole(){
//        Role roleManager =  new Role("Manager");
//        AppUser appUser = new AppUser("selena@mail.com", "manager44");
//        appUser.addRole(roleManager);
//
//        repo.save(appUser);
//    }
//
//    @Test
//    public void testGetUser(){
//        AppUser appUser = repo.findById(1L).get();
//        entityManager.detach(appUser);
//
//        System.out.println(appUser.getEmail());
//        System.out.println(appUser.getRoles());
//    }
//
//    @Test
//    public void testRemoveUser(){
//        repo.deleteById(4l);
//    }
//
//
//}

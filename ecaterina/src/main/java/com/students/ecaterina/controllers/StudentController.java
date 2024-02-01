package com.students.ecaterina.controllers;

import com.students.ecaterina.models.entities.Faculty;
import com.students.ecaterina.models.entities.Student;
import com.students.ecaterina.repositories.FacultyRepository;
import com.students.ecaterina.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//http://localhost:8080/api/v1/
@Controller
//@RestController
//@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;
    private final FacultyRepository facultyRepository;

    public StudentController(StudentService studentService, FacultyRepository facultyRepository) {
        this.studentService = studentService;
        this.facultyRepository = facultyRepository;
    }

    @GetMapping("/menu")
    public String viewMenu(Model model){
        model.addAttribute("listStudents", studentService.getAllStudents());
        return "index_menu";
    }

    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listStudents", studentService.getAllStudents());

        return "index";
    }

    @GetMapping("/showNewStudentForm")
    public String showNewStudentForm(Model model){
        List<Faculty> listFaculties = facultyRepository.findAll();
        Student student = new Student();
        model.addAttribute("stuDent", student);
        model.addAttribute("listFaculties", listFaculties);
        return "new_student";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("stuDent") Student student, BindingResult bindingResult){
        if (student.getFirstName() == null || student.getFirstName().trim().isEmpty()) {
            bindingResult.rejectValue("firstName", "error.firstName", "First name is required");
        }
        if (student.getLastName() == null || student.getLastName().trim().isEmpty()) {
            bindingResult.rejectValue("lastName", "error.lastName", "Last name is required");
        }
        if (student.getEmail() == null || student.getEmail().trim().isEmpty()) {
            bindingResult.rejectValue("email", "error.email", "Email is required");
        }
        if (student.getPhone() == null || student.getPhone().trim().isEmpty()) {
            bindingResult.rejectValue("phone", "error.phone", "Phone number is required");
        }
        if(bindingResult.hasErrors()){
            return "new_student";
        }
        studentService.saveStudents(student);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id")long id, Model model){
        List<Faculty> listFaculties = facultyRepository.findAll();
        Student student = studentService.getStudentById(id);
        model.addAttribute("stuDent", student);
        model.addAttribute("listFaculties", listFaculties);
        return "update_student";
    }

    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable(value = "id")long id){
        Student student = studentService.getStudentById(id);
        this.studentService.deleteStudentById(id);
        return "redirect:/";
    }



//    @GetMapping("/{id}")
//    public StudentDTO getStudentById(@PathVariable("id")long id){
//        return studentService.getUserById(id);
//    }

//    @PostMapping()
//    public ResponseEntity<?> createUser(@RequestBody StudentDTO studentDTO){
//        studentService.createStudent(studentDTO);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }

}

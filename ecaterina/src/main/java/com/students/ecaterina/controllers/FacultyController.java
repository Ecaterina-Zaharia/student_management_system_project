package com.students.ecaterina.controllers;
import com.students.ecaterina.models.entities.Faculty;
import com.students.ecaterina.repositories.FacultyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Controller
public class FacultyController {

    private final FacultyRepository facultyRepository;

    public FacultyController(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @GetMapping("/faculties")
    public String listFaculties(Model model){
        List<Faculty> listFaculties = facultyRepository.findAll();
        model.addAttribute("listFaculties", listFaculties);

        return "faculties";
    }

    @GetMapping("/faculties/new")
    public String showFacultyNewForm(Model model){
        model.addAttribute("faculty", new Faculty());

        return "faculty_form";
    }

    @PostMapping("/faculties/save")
    public String saveFaculty(Faculty faculty){
        facultyRepository.save(faculty);

        return "redirect:/faculties";
    }

}

package com.students.ecaterina.controllers;

import com.students.ecaterina.models.entities.Faculty;
import com.students.ecaterina.models.entities.Subject;
import com.students.ecaterina.models.entities.Teacher;
import com.students.ecaterina.repositories.FacultyRepository;
import com.students.ecaterina.repositories.SubjectRepository;
import com.students.ecaterina.repositories.TeacherRepository;
import com.students.ecaterina.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TeacherController {

    private final TeacherService teacherService;

    private final TeacherRepository teacherRepository;

    private final FacultyRepository facultyRepository;

    private final SubjectRepository subjectRepository;

    public TeacherController(TeacherService teacherService, TeacherRepository teacherRepository, FacultyRepository facultyRepository, SubjectRepository subjectRepository) {
        this.teacherService = teacherService;
        this.teacherRepository = teacherRepository;
        this.facultyRepository = facultyRepository;
        this.subjectRepository = subjectRepository;
    }


//    private final TeacherService teacherService;
//
//    public TeacherController(TeacherService teacherService) {
//        this.teacherService = teacherService;
//    }


    @GetMapping("/teachers")
    public String listTeachers(Model model) {
        List<Teacher> listTeachers = teacherRepository.findAll();
        model.addAttribute("listTeachers", listTeachers);

        return "teachers";
    }

    @GetMapping("/teachers/new")
    public String showCreateNewTeacherForm(Model model) {
        List<Faculty> listFaculties = facultyRepository.findAll();
        List<Subject> listSubjects = subjectRepository.findAll();

        model.addAttribute("listFaculties", listFaculties);
        model.addAttribute("listSubjects", listSubjects);
        model.addAttribute("teacher", new Teacher());

        return "teacher_form";
    }

    @PostMapping("/teachers/save")
    public String saveTeacher(@ModelAttribute("teacher") Teacher teacher) {
        if(teacher.getId() == null){
            teacherRepository.save(teacher);
        } else{
            Teacher existingTeacher = teacherRepository.findById(teacher.getId()).orElse(null);
            if(existingTeacher != null){
                existingTeacher.setTeacherName(teacher.getTeacherName());
//                existingTeacher.setSubjectName(teacher.getSubjectName());
                existingTeacher.setFaculties(teacher.getFaculties());
                existingTeacher.setSubjects(teacher.getSubjects());

                teacherRepository.save(existingTeacher);
            }
        }
        return "redirect:/teachers";
    }

//    @PostMapping("/teachers/save")
//    public String saveTeacher(@ModelAttribute("teacher") Teacher teacher, BindingResult bindingResult){
//        teacherRepository.save(teacher);
//        return "redirect:/teachers";
//    }


    @GetMapping("/teachers/edit/{id}") ///showFormForUpdate/{id}
    public String showEditTeacherForm(@PathVariable("id") Long id, Model model) {
        if(id == null){
            return "error";
        }
        List<Faculty> listFaculties = facultyRepository.findAll();
        List<Subject> listSubjects = subjectRepository.findAll();
        Teacher teacher = teacherRepository.findById(id).orElse(null);
        if(teacher == null){
            return "error";
        }

        model.addAttribute("listFaculties", listFaculties);
        model.addAttribute("listSubjects", listSubjects);
        model.addAttribute("teacher", teacher);

        return "update_teacher";
    }

    @GetMapping("/deleteTeacher/{id}")
    public String deleteTeacher(@PathVariable(value = "id") long id) {
        Teacher teacher = teacherService.getTeacherById(id);
        this.teacherService.deleteTeacherById(id);
        return "redirect:/teachers";
    }
}

package com.example.ThymeleafSpringBootMVCCRUDApplication.controller;

import com.example.ThymeleafSpringBootMVCCRUDApplication.model.Student;
import com.example.ThymeleafSpringBootMVCCRUDApplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listStudents", studentService.getStudents());
        return "index";
    }

    @GetMapping("/showNewStudentForm")
    public String showNewStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "add-student";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.addStudent(student);
        return "redirect:/";
    }

    @GetMapping("/getStudent/{id}")
    public String getStudent(@PathVariable ( value = "id") long id, Model model){
        model.addAttribute("student", studentService.getStudent(id));
        return "showStudent";
    }

    @GetMapping("/showUpdateStudentForm/{id}")
    public String showUpdateStudentForm(@PathVariable ( value = "id") long id, Model model) {

        Student student = studentService.getStudent(id);
        model.addAttribute("student", student);
        return "update-student";
    }

    @PostMapping("/updateStudent")
    public String updateStudent(@ModelAttribute("update_student") Student student) {
        studentService.updateStudent(student);
        return "redirect:/";
    }

    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable long id){
        studentService.deleteStudent(id);
        return "redirect:/";
    }
}

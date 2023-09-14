package com.studentmanagement.StudentManagementApp.Student;

import com.studentmanagement.StudentManagementApp.Services.StudentArrayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentArrayListService studentArrayListService;

    @GetMapping("/add")
    public String addStudent() {

        return "addStudent";
    }

    @PostMapping("/add")
    public String postStudent(@RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName,
                              @RequestParam("age") int age,
                              @RequestParam("degree") String degree)
    {
        studentArrayListService.addStudent(new Student(firstName, lastName, age, degree));

        return "redirect:/student/list";
    }

    @GetMapping("/list")
    public String getStudents(Model model) {
        model.addAttribute("studentArrayList", studentArrayListService.getStudents());
        return "studentList";
    }

    @PostMapping("/list")
    public String deleteStudent(@RequestParam("id") Long id){
        studentArrayListService.deleteStudent(id);
        return "redirect:/student/list";
    }

}

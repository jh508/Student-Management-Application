package com.studentmanagement.StudentManagementApp.Student;

import com.studentmanagement.StudentManagementApp.Services.StudentArrayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        studentArrayListService.addStudent(new Student(1L, firstName, lastName, age, degree));

        return "redirect:/student/list";
    }

    @GetMapping("/list")
    public String getStudents(Model model) {
        model.addAttribute("studentArrayList", studentArrayListService.getStudents());
        return "studentList";
    }


    public String deleteStudent() {
        return null;
    }
}

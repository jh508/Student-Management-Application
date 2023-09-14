package com.studentmanagement.StudentManagementApp.Student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/Student")
public class StudentController {
    List<Student> studentArrayList = new ArrayList<>();
    @GetMapping("/List")
    public String getStudents(Model model){
        studentArrayList.add(new Student(1L, "Bob", "Marley", 22, "Computer Science"));
        studentArrayList.add(new Student(2L, "Jon", "Mcarthy", 28, "Design and Technology"));
        studentArrayList.add(new Student(3L, "Elliot", "Pilkington", 29, "Psychology"));
        model.addAttribute("studentArrayList", studentArrayList);
        return "studentList";
    }


    @PostMapping("/List")
    public String deleteStudent(@RequestBody(required = true) Long id){

        return "studentList";
    }

}

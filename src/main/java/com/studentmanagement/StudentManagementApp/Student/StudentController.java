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

    @GetMapping("/update/")
    public String updateStudents(@RequestParam("idToUpdate") long id, Model model)
    {
        model.addAttribute("idToUpdate", id);
        model.addAttribute("firstName", studentArrayListService.getStudent(id).getFirstName());
        model.addAttribute("lastName", studentArrayListService.getStudent(id).getLastName());
        model.addAttribute("age", studentArrayListService.getStudent(id).getAge());
        model.addAttribute("degree", studentArrayListService.getStudent(id).getDegree());
        return "updateStudent";
    }

    @PostMapping("/update")
    public String updateStudentRequest(@RequestParam("idToUpdate") long id,
                                       @RequestParam("firstName") String firstName,
                                       @RequestParam("lastName") String lastName,
                                       @RequestParam("age") int age,
                                       @RequestParam("degree") String degree){

        studentArrayListService.getStudent(id).setFirstName(firstName);
        studentArrayListService.getStudent(id).setLastName(lastName);
        studentArrayListService.getStudent(id).setAge(age);
        studentArrayListService.getStudent(id).setDegree(degree);
        return "redirect:/student/list";

    }

    @PostMapping("/list")
    public String deleteStudent(@RequestParam("id") Long id){
        studentArrayListService.deleteStudent(id);
        return "redirect:/student/list";
    }

}

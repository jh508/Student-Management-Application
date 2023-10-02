package com.studentmanagement.StudentManagementApp.Student;


import com.studentmanagement.StudentManagementApp.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/add")
    public String addStudent() {

        return "addStudent";
    }

    @PostMapping("/add")
    public String postStudent(@RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName,
                              @RequestParam("age") int age,
                              @RequestParam("degree") String degree,
                              @RequestParam("submitButton") String button)
    {

        if("cancel".equals(button)){
            return "redirect:/student/list";
        }

        studentService.addStudent(new Student(firstName, lastName, age, degree));

        return "redirect:/student/list";
    }

    @GetMapping("/list")
    public String getStudents(Model model) {
        model.addAttribute("studentArrayList", studentService.getStudents());
        return "studentList";
    }

    @GetMapping("/update/")
    public String updateStudents(@RequestParam("idToUpdate") long id, Model model)
    {
        model.addAttribute("idToUpdate", id);
        model.addAttribute("firstName", studentService.getStudent(id).getFirstName());
        model.addAttribute("lastName", studentService.getStudent(id).getLastName());
        model.addAttribute("age", studentService.getStudent(id).getAge());
        model.addAttribute("degree", studentService.getStudent(id).getDegree());
        return "updateStudent";
    }

    @PostMapping("/update")
    public String updateStudentRequest(@RequestParam("idToUpdate") long id,
                                       @RequestParam("firstName") String firstName,
                                       @RequestParam("lastName") String lastName,
                                       @RequestParam("age") int age,
                                       @RequestParam("degree") String degree,
                                       @RequestParam("submitButton") String button){

        if("cancel".equals(button)){
            return "redirect:/student/list";
        }

        studentService.updateStudent(id, firstName, lastName, age, degree);

        return "redirect:/student/list";

    }

    @PostMapping("/list")
    public String deleteStudent(@RequestParam("id") Long id){
        studentService.deleteStudent(id);
        return "redirect:/student/list";
    }

}

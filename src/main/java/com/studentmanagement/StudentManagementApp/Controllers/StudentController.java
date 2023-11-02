package com.studentmanagement.StudentManagementApp.Controllers;


import com.studentmanagement.StudentManagementApp.Services.StudentService;
import com.studentmanagement.StudentManagementApp.Entity.Student;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    /**
     * Handles the GET request by returning a view
     *
     * @return The name of the view template, "addStudent".
     */
    @GetMapping("/new/")
    public String addStudent(Model model) {
        model.addAttribute("student", new Student());
        return "addStudent";
    }

    @PostMapping("/add")
    public String postStudent(@Valid @ModelAttribute("student") Student student,
                              BindingResult bindingResult,
                              @RequestParam("submitButton") String button,
                              Model model, Principal principal)
    {

        if("cancel".equals(button)){
            return "redirect:/student/list";
        }

        if(bindingResult.hasErrors()){
            return "addStudent.html";
        }

        String username = principal.getName();
        student.setUser_id(username);
        studentService.addStudent(student);
        return "redirect:/student/list";
    }

    /**
     * Retrieves a list of students from the database and passes it to the model for display.
     *
     * @param model The Spring model to which the student data is added.
     * @return The name of the view template, "studentList".
     */

    @GetMapping("/list")
    public String getStudents(Model model, Principal principal) {
        String username = principal.getName();
        model.addAttribute("studentArrayList", studentService.getStudentsByUserID(username));
        return "studentList";
    }

    /**
     * Handles a GET request to redirect the user to .
     *
     * @param id       The user ID.
     * @param model       The Spring model to which the student data is added.
     * @return Redirects the user to the student list page.
     */
    @GetMapping("/update/user/{id}")
    public String updateStudents(@PathVariable Long id, Model model)
    {
        model.addAttribute("idToUpdate", id);
        model.addAttribute("firstName", studentService.getStudent(id).getFirstName());
        model.addAttribute("lastName", studentService.getStudent(id).getLastName());
        model.addAttribute("age", studentService.getStudent(id).getAge());
        model.addAttribute("degree", studentService.getStudent(id).getDegree());
        model.addAttribute("student", studentService.getStudent(id));
        return "updateStudent";
    }

    @PostMapping("/update")
    public String updateStudentRequest(@Valid @ModelAttribute("student") Student student,
                                       BindingResult bindingResult,
                                       @RequestParam("submitButton") String button,
                                       @RequestParam("idToUpdate") long id,
                                       Model model) {

        if ("cancel".equals(button)) {
            return "redirect:/student/list";
        }

        if(bindingResult.hasErrors()){
            model.addAttribute("firstName", studentService.getStudent(id).getFirstName());
            model.addAttribute("lastName", studentService.getStudent(id).getLastName());
            model.addAttribute("age", studentService.getStudent(id).getAge());
            model.addAttribute("degree", studentService.getStudent(id).getDegree());
            return "updateStudent.html";
        }

        studentService.updateStudent(id, student.getFirstName(), student.getLastName(), student.getAge(), student.getDegree());

        return "redirect:/student/list";
    }

    /**
     * Handles a POST request to delete a student from the database using the provided ID.
     *
     * @param id The user ID to be deleted.
     * @return Redirects the user to refresh the web page.
     */
    @PostMapping("/list")
    public String deleteStudent(@RequestParam("id") Long id){
        System.out.println("Received ID: " + id);
        studentService.deleteStudent(id);
        return "redirect:/student/list";
    }

}

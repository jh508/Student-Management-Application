package com.studentmanagement.StudentManagementApp.Controllers;


import com.studentmanagement.StudentManagementApp.Services.StudentService;
import com.studentmanagement.StudentManagementApp.Entity.Student;
import com.studentmanagement.StudentManagementApp.Utilities.StudentControllerUtility;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

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
                              Model model)
    {

        if("cancel".equals(button)){
            return "redirect:/student/list";
        }

        if(bindingResult.hasErrors()){
            return "addStudent.html";
        }

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
    public String getStudents(Model model) {
        model.addAttribute("studentArrayList", studentService.getStudents());
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
        model.addAttribute("firstNameOriginal", studentService.getStudent(id).getFirstName());
        model.addAttribute("firstName", studentService.getStudent(id).getFirstName());
        model.addAttribute("lastName", studentService.getStudent(id).getLastName());
        model.addAttribute("age", studentService.getStudent(id).getAge());
        model.addAttribute("degree", studentService.getStudent(id).getDegree());
        return "updateStudent";
    }

    /**
     * Handles a POST request to update student information in the database.
     *
     * @param id       The user ID.
     * @param firstName    The user's first name.
     * @param lastName The user's last name.
     * @param age      The user's age.
     * @param degree   The user's degree.
     * @param button   The button that was pressed (update or cancel).
     * @return Redirects the user to the student list page.
     */
    @PostMapping("/update")
    public String updateStudentRequest(@RequestParam("idToUpdate") long id,
                                       @RequestParam("firstName") String firstName,
                                       @RequestParam("lastName") String lastName,
                                       @RequestParam("age") String age,
                                       @RequestParam("degree") String degree,
                                       @RequestParam("submitButton") String button,
                                       Model model) {

        if ("cancel".equals(button)) {
            return "redirect:/student/list";
        }

        final String first_Name = firstName.trim();
        final String last_Name = lastName.trim();
        final String degree_Name = degree.trim();

        if(first_Name.contains(" ") || first_Name.isBlank() || StudentControllerUtility.containsInvalidCharacters(first_Name)){
            model.addAttribute("invalidFirstName", "Invalid First Name");
            model.addAttribute("idToUpdate", id);
            model.addAttribute("firstNameOriginal", studentService.getStudent(id).getFirstName());
            model.addAttribute("firstName", first_Name);
            model.addAttribute("lastName", last_Name);
            model.addAttribute("age", age);
            model.addAttribute("degree", degree_Name);
            return "updateStudent";
        }

        if(last_Name.contains(" ") || last_Name.isBlank() || StudentControllerUtility.containsInvalidCharacters(lastName)){
            model.addAttribute("invalidLastName", "Invalid Last Name");
            model.addAttribute("idToUpdate", id);
            model.addAttribute("firstNameOriginal", studentService.getStudent(id).getFirstName());
            model.addAttribute("firstName", first_Name);
            model.addAttribute("lastName", last_Name);
            model.addAttribute("age", age);
            model.addAttribute("degree", degree_Name);
            return "updateStudent";
        }

        if(degree_Name.isBlank() || StudentControllerUtility.containsInvalidCharacters(degree_Name)){
            model.addAttribute("invalidDegree", "Invalid Degree Name");
            model.addAttribute("idToUpdate", id);
            model.addAttribute("firstNameOriginal", studentService.getStudent(id).getFirstName());
            model.addAttribute("firstName", first_Name);
            model.addAttribute("lastName", last_Name);
            model.addAttribute("age", age);
            model.addAttribute("degree", degree_Name);
            return "updateStudent";
        }

        try{
            int parsedAge = Integer.parseInt(age);

            studentService.updateStudent(id, first_Name, last_Name, parsedAge, degree_Name);
        }
        catch (NumberFormatException ex){
            model.addAttribute("invalidAge", "Age must be a valid integer.");
            model.addAttribute("idToUpdate", id);
            model.addAttribute("firstNameOriginal", studentService.getStudent(id).getFirstName());
            model.addAttribute("firstName", first_Name);
            model.addAttribute("lastName", last_Name);
            model.addAttribute("age", age);
            model.addAttribute("degree", degree_Name);
            return "updateStudent";
        }

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

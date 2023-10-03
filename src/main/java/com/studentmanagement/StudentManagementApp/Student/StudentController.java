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

    /**
     * Handles the GET request by returning a view
     *
     * @return The name of the view template, "addStudent".
     */
    @GetMapping("/add")
    public String addStudent() {

        return "addStudent";
    }

    /**
     * Handles a POST request to add a new student in the database.
     *
     * @param firstName    The student's first name.
     * @param lastName The student's last name.
     * @param age      The student's age.
     * @param degree   The student's degree.
     * @param button   The button that was pressed (add or cancel).
     * @return Redirects the user to the student list page.
     */

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
                                       @RequestParam("age") int age,
                                       @RequestParam("degree") String degree,
                                       @RequestParam("submitButton") String button) {

        if ("cancel".equals(button)) {
            return "redirect:/student/list";
        }

        studentService.updateStudent(id, firstName, lastName, age, degree);

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
        studentService.deleteStudent(id);
        return "redirect:/student/list";
    }

}

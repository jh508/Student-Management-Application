package com.studentmanagement.StudentManagementApp.Repositories;

import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface IStudentRepository {

    public String addStudent();


    public String postStudent(@RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName,
                              @RequestParam("age") int age,
                              @RequestParam("degree") String degree);


    String getStudents(Model model);


    public String deleteStudent();

}

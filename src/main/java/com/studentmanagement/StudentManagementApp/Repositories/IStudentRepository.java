package com.studentmanagement.StudentManagementApp.Repositories;

import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public interface IStudentRepository {

    String addStudent();


    String postStudent();


    String getStudents(Model model);


    String deleteStudent();

}

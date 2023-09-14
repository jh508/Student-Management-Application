package com.studentmanagement.StudentManagementApp.Repositories;

import com.studentmanagement.StudentManagementApp.Student.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentRepository {

    void addStudent(Student student);

    void deleteStudent(Long id);

    void updateStudent(Student student);

    long generateID();

    List<Student> getStudents();

}

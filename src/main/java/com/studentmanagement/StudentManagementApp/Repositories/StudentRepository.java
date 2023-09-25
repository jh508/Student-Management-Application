package com.studentmanagement.StudentManagementApp.Repositories;

import com.studentmanagement.StudentManagementApp.Student.Student;
import org.springframework.ui.Model;

import java.util.List;

public class StudentRepository implements IStudentRepository{

    @Override
    public void addStudent(Student student) {

    }

    @Override
    public void deleteStudent(Long id) {

    }

    @Override
    public void updateStudent(Long id, String firstName, String lastName, int age, String degree) {

    }

    @Override
    public long generateID() {
        return 0;
    }

    @Override
    public List<Student> getStudents() {
        return null;
    }
}

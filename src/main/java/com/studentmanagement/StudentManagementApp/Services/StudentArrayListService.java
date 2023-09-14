package com.studentmanagement.StudentManagementApp.Services;

import com.studentmanagement.StudentManagementApp.Student.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentArrayListService implements IStudentService {

    private final List<Student> studentList = new ArrayList<>();


   @Override
    public void addStudent(Student student) {
        studentList.add(student);
    }

    @Override
    public void deleteStudent(Student student) {
       studentList.remove(student);
    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public List<Student> getStudents() {
        return this.studentList;
    }
}

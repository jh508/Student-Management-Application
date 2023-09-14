package com.studentmanagement.StudentManagementApp.Services;


import com.studentmanagement.StudentManagementApp.Student.Student;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface IStudentService {

    void addStudent(Student student);

    void deleteStudent(Long id);

    void updateStudent(Student student);

    List<Student> getStudents();



}

package com.studentmanagement.StudentManagementApp.Services;


import com.studentmanagement.StudentManagementApp.Student.Student;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface IStudentService {

    void addStudent(Student student);

    void deleteStudent(Long id);

    void updateStudent(Long id, String firstName, String lastName, int age, String degree);

    Student getStudent(Long id);

    List<Student> getStudents();



}

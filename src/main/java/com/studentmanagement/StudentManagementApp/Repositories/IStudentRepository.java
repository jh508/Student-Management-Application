package com.studentmanagement.StudentManagementApp.Repositories;

import com.studentmanagement.StudentManagementApp.Entity.Student;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IStudentRepository {
    void addStudent(Student student);
    void deleteStudent(Long id);
    void updateStudent(Long id, String firstName, String lastName, int age, String degree);
    Student findbyID(Long id);
    List<Student> getStudents();

    List<Student> getStudentsByUsername(String username);
}

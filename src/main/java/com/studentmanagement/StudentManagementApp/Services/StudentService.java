package com.studentmanagement.StudentManagementApp.Services;

import com.studentmanagement.StudentManagementApp.Repositories.IStudentRepository;
import com.studentmanagement.StudentManagementApp.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService implements IStudentService {

    @Autowired
    @Qualifier("database")
    private IStudentRepository studentRepository;

    @Override
    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteStudent(id);
    }

    @Override
    public void updateStudent(Long id, String firstName, String lastName, int age, String degree) {
        studentRepository.updateStudent(id, firstName, lastName, age, degree);
    }

    @Override
    public Student getStudent(Long id) {
        return studentRepository.findbyID(id);

    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.getStudents();
    }

    @Override
    public List<Student> getStudentsByUserID(String username) {
        return studentRepository.getStudentsByUsername(username);
    }

}

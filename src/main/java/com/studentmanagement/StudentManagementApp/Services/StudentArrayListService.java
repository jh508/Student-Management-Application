package com.studentmanagement.StudentManagementApp.Services;

import com.studentmanagement.StudentManagementApp.Repositories.IStudentRepository;
import com.studentmanagement.StudentManagementApp.Student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class StudentArrayListService implements IStudentService {
    @Autowired
   private IStudentRepository studentRepository;

    @Override
    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.getStudents().removeIf(s -> Objects.equals(s.getId(), id));
    }



    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.getStudents();
    }
}

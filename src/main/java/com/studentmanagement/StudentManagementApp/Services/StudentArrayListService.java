package com.studentmanagement.StudentManagementApp.Services;

import com.studentmanagement.StudentManagementApp.Repositories.IStudentRepository;
import com.studentmanagement.StudentManagementApp.DTOs.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;

@Service
public class StudentArrayListService implements IStudentService {
    @Autowired
    @Qualifier("arraylist")
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
    public void updateStudent(Long id, String firstName, String lastName, int age, String degree) {
        studentRepository.updateStudent(id, firstName, lastName, age, degree);
    }

    @Override
    public Student getStudent(Long id) {
        for(Student s : studentRepository.getStudents()){
            if(s.getId().equals(id)){
                return s;
            }
        }
        return null;
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.getStudents();
    }
}

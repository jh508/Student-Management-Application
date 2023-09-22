package com.studentmanagement.StudentManagementApp.Repositories;

import com.studentmanagement.StudentManagementApp.Student.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentArrayListRepository implements IStudentRepository{
    private final List<Student> studentList = new ArrayList<>();


    @Override
    public void addStudent(Student student) {
        student.setId(generateID());
        studentList.add(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentList.removeIf(s -> s.getId().equals(id));
    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public long generateID() {
        long id = 1;
        if(!studentList.isEmpty()){
            id = studentList.size();
        }

        return id;
    }

    @Override
    public List<Student> getStudents() {
        return this.studentList;
    }
}

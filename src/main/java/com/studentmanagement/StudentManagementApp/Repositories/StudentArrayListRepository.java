package com.studentmanagement.StudentManagementApp.Repositories;

import com.studentmanagement.StudentManagementApp.Entity.Student;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository("arraylist")
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
    public void updateStudent(Long id, String firstName, String lastName, int age, String degree) {
        for(Student s : studentList){
            if(s.getId().equals(id)){
                s.setFirstName(firstName);
                s.setAge(age);
                s.setLastName(lastName);
                s.setDegree(degree);
            }
        }
    }

    @Override
    public Student findbyID(Long id) {
        return null;
    }

    public long generateID() {
        long id = studentList.size();
        if(id != 0){
            id++;
        }

        return id;
    }

    @Override
    public List<Student> getStudents() {
        return this.studentList;
    }
}

package com.studentmanagement.StudentManagementApp.Repositories;

import com.studentmanagement.StudentManagementApp.Student.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository("database")
public class StudentRepository implements IStudentRepository{
    private final EntityManager entityManager;
    @Autowired
    public StudentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void addStudent(Student student) {
        entityManager.persist(student);
    }

    @Override
    @Transactional
    public void deleteStudent(Long id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public void updateStudent(Long id, String firstName, String lastName, int age, String degree) {
       Student student = entityManager.find(Student.class, id);
       student.setFirstName(firstName);
       student.setLastName(lastName);
       student.setAge(age);
       student.setDegree(degree);
    }

    @Override
    public Student findbyID(Long id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> getStudents() {
        String jpql = "SELECT s FROM Student s";

        return entityManager.createQuery(jpql, Student.class).getResultList();
    }
}

package com.studentmanagement.StudentManagementApp.Repositories;

import com.studentmanagement.StudentManagementApp.Entity.Student;
import com.studentmanagement.StudentManagementApp.Entity.User;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UserRepository {

    private final EntityManager entityManager;
    @Autowired
    public UserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Transactional
    public void createUser(User user) {
        entityManager.persist(user);
    }

    public boolean findByUsername(String username) {
        return entityManager.find(User.class, username) != null;
    }

}

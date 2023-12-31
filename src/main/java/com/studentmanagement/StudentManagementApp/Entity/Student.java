package com.studentmanagement.StudentManagementApp.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    @Column(name = "user_id")
    private String user_id;
    @Column(name = "first_name")
    @NotNull(message = "First name is required")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Special characters are not allowed")
    private String firstName;
    @Column(name = "last_name")
    @NotNull(message = "Last name cannot be empty.")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Special characters are not allowed")
    private String lastName;
    @Column(name = "age")
    @Min(value = 18, message = "Must be at least 18 or over")
    private int age;
    @Column(name = "degree")
    @NotNull(message = "Degree title is required")
    @Pattern(regexp = "^[a-zA-Z ]*$", message = "Special characters are not allowed")
    private String degree;

    public Student(){}

    public Student(String firstName, String lastName, int age, String degree) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.degree = degree;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", degree='" + degree + '\'' +
                '}';
    }
}

package com.studentmanagement.StudentManagementApp.Student;

public class Student {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String degree;

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

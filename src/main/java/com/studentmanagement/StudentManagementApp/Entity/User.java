package com.studentmanagement.StudentManagementApp.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
@Entity
@Table(name = "users")
public class User {

    @NotNull(message = "Username is required")
    @Size(min = 3, message = "You must have at least 3 characters in your username")
    @Id
    private String username;

    @NotNull(message = "Username is required")
    @Size(min = 8, message = "You must have at least 8 characters in your password")
    private String password;

    public User(){};

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

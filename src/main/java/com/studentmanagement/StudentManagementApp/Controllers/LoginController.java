package com.studentmanagement.StudentManagementApp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    /**
     * Handles the GET request by returning a view
     *
     * @return The name of the view template, "loginPage".
     */
    @GetMapping("/login")
    public String getLoginPage(){

        return "loginPage.html";
    }

}


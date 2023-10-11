package com.studentmanagement.StudentManagementApp.Controllers;

import com.studentmanagement.StudentManagementApp.DTOs.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @GetMapping("/newuser")
    public String getRegistrationPage(Model model){
        model.addAttribute("user", new User());
        return "register.html";
    }

}

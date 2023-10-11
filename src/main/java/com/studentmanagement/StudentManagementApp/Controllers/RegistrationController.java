package com.studentmanagement.StudentManagementApp.Controllers;

import com.studentmanagement.StudentManagementApp.DTOs.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @GetMapping("/newuser")
    public String getRegistrationPage(Model model){
        model.addAttribute("user", new User());
        return "register.html";
    }

    @PostMapping("/newuser")
    public String getRegistrationPageRequest(@ModelAttribute("user") User user, Model model, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            model.addAttribute("registrationError", "There was an error with your request.");
            return "register.html";
        }

        model.addAttribute("registrationSuccess", "Account Successfully Created");
        return "register.html";
    }

}

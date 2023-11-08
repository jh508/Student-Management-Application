package com.studentmanagement.StudentManagementApp.Controllers;

import com.studentmanagement.StudentManagementApp.Entity.User;
import com.studentmanagement.StudentManagementApp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserService userService;

    @GetMapping("/newuser")
    public String getRegistrationPage(Model model){
        model.addAttribute("user", new User());
        return "register.html";
    }

    @PostMapping("/newuser")
    public String RegistrationRequest(@ModelAttribute("user") User user, Model model, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            model.addAttribute("registrationError", "There was an error with your request.");
            return "register.html";
        }

        userService.registerNewUserAccount(user);

        model.addAttribute("registrationSuccess", "Account Successfully Created");
        return "register.html";
    }

}

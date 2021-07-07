package com.domain.crudapi.controllers;

import com.domain.crudapi.model.entities.User;
import com.domain.crudapi.model.repos.UserRepo;
import com.domain.crudapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public String viewHomePage(){
        return "index";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model){
        userService.addUser(model);
        return "signup_form";
    }

    @PostMapping("/process_register")
    public String processRegister(User user){
        userService.register(user);
        return "register_success";
    }

    @GetMapping("/list_product")
    public String viewUsersList(){
        return "product";
    }
}
//https://www.codejava.net/frameworks/spring-boot/user-registration-and-login-tutorial
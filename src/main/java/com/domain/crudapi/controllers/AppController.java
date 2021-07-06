package com.domain.crudapi.controllers;

import com.domain.crudapi.model.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("")
    public String viewHomePage(){
        return "index";
    }
}
//https://www.codejava.net/frameworks/spring-boot/user-registration-and-login-tutorial
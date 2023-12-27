package com.github.springweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.github.springweb.models.Login;


@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping("")
    public String displayLoginForm(Model model){

        model.addAttribute("loginModel", new Login());
        return "loginpage";
    
    }

    @PostMapping("")
    public String processLogin(Login login, Model model){

        model.addAttribute("loginModel", login);
        return "loginresults";
    
    }

}

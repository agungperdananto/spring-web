package com.github.springweb.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.github.springweb.models.Login;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping("/")
    public String displayLoginForm(Model model){

        model.addAttribute("loginModel", new Login());
        return "loginpage";
    
    }

    @PostMapping("/")
    public String processLogin(@Valid @ModelAttribute("loginModel") Login login, BindingResult bindingResult, Model model){
        
        if (bindingResult.hasErrors()){
            
            return "loginpage.html";
        }
        return "loginresults";
    
    }

}

package com.github.springweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class DummyController {
    
    // string response
    @GetMapping("/hello")
    @ResponseBody
    public String printHello() {

        return "Hello World !";
    }

    // render template
    @GetMapping("/hello-page")
    public String showHello(Model model) {
        model.addAttribute("title", "Good evening");
        model.addAttribute("rating", 99);
        return "hellopage.html";
    }
    
    @GetMapping("/hello-mv")
    public ModelAndView helloMV() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("title", "Good Morning(MV)");
        mv.addObject("rating", 89);
        mv.setViewName("hellopage");
        return mv;
    }
    
    @GetMapping("/hello-param")
    public String getMethodName(@RequestParam(value="title", required = false, defaultValue = "placeholder title") String title, @RequestParam(value="rating", required = false, defaultValue = "50") String rating, Model model) {
        model.addAttribute("title", title);
        model.addAttribute("rating", rating);
        return "hellopage";
    }
    
}

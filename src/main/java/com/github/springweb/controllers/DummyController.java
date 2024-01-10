package com.github.springweb.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.springweb.models.Person;

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
    public String helloParam(@RequestParam(value="title", required = false, defaultValue = "placeholder title") String title, @RequestParam(value="rating", required = false, defaultValue = "50") String rating, Model model) {
        model.addAttribute("title", title);
        model.addAttribute("rating", rating);
        return "hellopage";
    }
    
    @GetMapping("/people")
    public String showPeople(Model model) {

        List<Person> friends = new ArrayList<Person>();

        friends.add(new Person(0, "Allen", 23, 156.4f));
        friends.add(new Person(1, "Bruce", 33, 160.9f));
        friends.add(new Person(2, "Cindy", 21, 141.5f));
        friends.add(new Person(3, "Darren", 31, 149.3f));
        friends.add(new Person(4, "Ethan", 28, 142.4f));
        friends.add(new Person(5, "Frank", 26, 158.2f));
        friends.add(new Person(6, "George", 29, 157.5f));

        model.addAttribute("people", friends);

        return "personlist";
    }

    @GetMapping("/api/people")
    @ResponseBody
    public List<Person> peopleAPI() {

        List<Person> friends = new ArrayList<Person>();

        friends.add(new Person(0, "Allen", 23, 156.4f));
        friends.add(new Person(1, "Bruce", 33, 160.9f));
        friends.add(new Person(2, "Cindy", 21, 141.5f));
        friends.add(new Person(3, "Darren", 31, 149.3f));
        friends.add(new Person(4, "Ethan", 28, 142.4f));
        friends.add(new Person(5, "Frank", 26, 158.2f));
        friends.add(new Person(6, "George", 29, 157.5f));
        return friends;
    }

}


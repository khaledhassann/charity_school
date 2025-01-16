package com.rungroup.controllers;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VolunteerHomeController {

    @GetMapping("/volunteer-home")
    public String homePage(Model model) {
        
        return "volunteer-home"; 
    }
}


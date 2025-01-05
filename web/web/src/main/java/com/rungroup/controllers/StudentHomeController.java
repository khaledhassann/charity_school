package com.rungroup.controllers;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentHomeController {

    // Endpoint for the Student Homepage
    @GetMapping("/")
    public String studentHomePage() {
        return "student-home"; // Name of the HTML file for the homepage (student-home.html)
    }

    
}

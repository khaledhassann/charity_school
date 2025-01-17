package com.rungroup.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentHomeController {

    @GetMapping("/student-home")
    public String studentHomePage() {
        return "student-home"; 
    }

    
}
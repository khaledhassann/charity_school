package com.rungroup.web.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminHomeController {

    // Endpoint for the Student Homepage
    @GetMapping("/")
    public String AdminHomePage() {
        return "adminpage"; 
    }
}
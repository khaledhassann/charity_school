package com.rungroup.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VolunteerHomeController {
        @GetMapping("/volunteer_home")
        public String VolunteerHomePage() {
            return "volunteer_home"; 
        }
    }
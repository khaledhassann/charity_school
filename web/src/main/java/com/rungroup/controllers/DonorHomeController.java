package com.rungroup.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DonorHomeController {

    @GetMapping("/")
    public String AdminHomePage() {
        return "donorHome"; 
    }
}

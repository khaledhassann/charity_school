package com.rungroup.web.controllers;

import com.rungroup.web.models.Donor;
import com.rungroup.web.models.User;
import com.rungroup.web.models.Volunteer;
import com.rungroup.web.repositories.Implementations.DonorRepository;
import com.rungroup.web.repositories.Implementations.VolunteerRepository;
import com.rungroup.web.utils.UserFactory;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignupController {


    @GetMapping("/signup")
    public String showSignupPage(Model model) {
        model.addAttribute("user", new Donor());
        model.addAttribute("user", new Volunteer());
        return "signup"; // Render the signup.html page
    }

    @PostMapping("/signup")
    public String processSignup(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("role") String role,
            @RequestParam(value = "skills", required = false) List<String> skills,
            @RequestParam(value = "availability", required = false) Boolean availability,
            @RequestParam(value = "preferredType", required = false) String preferredType,
            Model model
    ) {
        System.out.println("-------------role: "+role);
        try {
            User user = UserFactory.createUser(
                    0L,
                    role,
                    name,
                    email,
                    password,
                    null, // grade not required
                    null, // enrollmentDate not required
                    preferredType,
                    skills,
                    availability != null && availability
            );
            
            System.out.println("User created: " + user.getName() + " (" + user.getRole() + ")");
            model.addAttribute("message", "User created successfully!");
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
        }
    
        return "signup";
    }
}

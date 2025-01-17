package com.rungroup.web.controllers;

import com.rungroup.web.models.Beneficiary;
import com.rungroup.web.models.User;
import com.rungroup.web.repositories.Implementations.BeneficiaryRepository;
import com.rungroup.web.utils.UserFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BeneficiaryController {
    
    private static List<User> beneficiaries = new ArrayList<>();


    @GetMapping("/register-beneficiary")
    public String showRegisterBeneficiaryPage(Model model) {
        model.addAttribute("message", null);
        model.addAttribute("beneficiaries", beneficiaries);
        return "register-beneficiary";
    }

    @PostMapping("/register-beneficiary")
    public String createAdmin(@RequestParam("name") String name,
                              @RequestParam("email") String email,
                              @RequestParam("password") String password,
                              @RequestParam("grade") String grade,
                              @RequestParam("enrollmentDate") LocalDateTime enrollmentDate,
                              Model model) {
        
        String role = "Beneficiary";
         User user = UserFactory.createUser(0L,role, name, email,password, grade, enrollmentDate,null,null,false);
            System.out.println("User created: " + user.getName() + " (" + user.getRole() + ")");

        // Add the admin to the list
        beneficiaries.add(user);
        
        // Add to db
        new BeneficiaryRepository().insert((Beneficiary)user);
        // Debugging information
        System.out.println("New Beneficiary Created: " + user);

        model.addAttribute("message", "Beneficiary created successfully!");
        model.addAttribute("beneficiaries", beneficiaries); 
        return "register-beneficiary";
    }
}
package com.rungroup.web.controllers;

import com.rungroup.web.models.Admin;
import com.rungroup.web.repositories.Implementations.AdminRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CreateAdminController {

    private List<Admin> admins = new AdminRepository().findAll();



    @GetMapping("/create-admin")
    public String showCreateAdminPage(Model model) {
        model.addAttribute("message", null);
        return "create-admin";
    }

    @PostMapping("/create-admin")
    public String createAdmin(@RequestParam("name") String name,
                              @RequestParam("email") String email,
                              @RequestParam("password") String password,
                              Model model) {
        // Create a new Admin object
        Admin newAdmin = new Admin(name, email, password);

        // Add the admin to the list
        admins.add(newAdmin);
        
        // Add to db
        new AdminRepository().insert(newAdmin);
        
        // Debugging information
        System.out.println("New Admin Created: " + newAdmin);

        model.addAttribute("message", "Admin created successfully!");
        return "create-admin";
    }
}

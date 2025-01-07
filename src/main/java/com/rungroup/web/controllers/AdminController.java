package com.rungroup.web.controllers;

import com.rungroup.web.models.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {

    private List<Admin> admins = new ArrayList<>();
    private int idCounter = 1;

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
        Admin newAdmin = new Admin(idCounter++, name, email, password);

        // Add the admin to the list
        admins.add(newAdmin);

        // Debugging information
        System.out.println("New Admin Created: " + newAdmin);

        model.addAttribute("message", "Admin created successfully!");
        return "create-admin";
    }

    @GetMapping("/admin-list")
    public String showAdminList(Model model) {
        model.addAttribute("admins", admins);
        return "admin-list";
    }
}

package com.rungroup.controllers;

import com.rungroup.models.CurrentUser;
import com.rungroup.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UpdateProfileController {

    @GetMapping("/update_profile")
    public String showUpdateProfilePage(Model model) {
        User currentUser = CurrentUser.getUser();
        System.out.println("This is the user in update: "+currentUser);
        if (currentUser != null) {
            model.addAttribute("donor", currentUser);
            return "update_profile";
        }
        return "redirect:/login";
    }

    @PostMapping("/update_profile")
    public String updateProfile(@RequestParam String name, @RequestParam String email, @RequestParam String password, Model model) {
        User currentUser = CurrentUser.getUser();
        System.out.println("This is the user in update: "+currentUser);
        if (currentUser != null) {
            currentUser.setName(name);
            currentUser.setEmail(email);
            currentUser.setPassword(password);
            model.addAttribute("message", "Profile updated successfully.");
            return "update_profile";
        }
        model.addAttribute("error", "Failed to update profile.");
        return "update_profile";
    }
}

package com.rungroup.controllers;

import com.rungroup.models.User;
import com.rungroup.models.Donor;
import com.rungroup.models.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {
    private List<User> users;

    public LoginController() {
        users = new ArrayList<>();
        users.add(new Donor(1L, "John Doe", "john@example.com", "password123"));
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                CurrentUser.setUser(user);
                return "redirect:/";
            }
        }
        model.addAttribute("error", "Login failed: wrong email or password.");
        return "login";
    }
    @PostMapping("/logout")
    public String logout() {
        CurrentUser.setUser(null);
        return "redirect:/home";
    }

}

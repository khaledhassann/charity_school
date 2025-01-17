package com.rungroup.web.controllers;

import com.rungroup.web.models.User;
import com.rungroup.web.models.UserCollection;
import com.rungroup.web.models.UserIterator;
import com.rungroup.web.repositories.Implementations.AdminRepository;
import com.rungroup.web.repositories.Implementations.BeneficiaryRepository;
import com.rungroup.web.repositories.Implementations.DonorRepository;
import com.rungroup.web.repositories.Implementations.VolunteerRepository;
import com.rungroup.web.utils.UserFactory;
import com.rungroup.web.models.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {
    private UserCollection userCollection;

    public LoginController() {
        userCollection = new UserCollection();
        // Add users from repositories
        userCollection.getUsers().addAll(new DonorRepository().findAll());
        userCollection.getUsers().addAll(new VolunteerRepository().findAll());
        userCollection.getUsers().addAll(new BeneficiaryRepository().findAll());
        userCollection.getUsers().addAll(new AdminRepository().findAll());
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        UserIterator iterator = userCollection.iterator();
        
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                CurrentUser.setUser(user);
                System.out.println("--------user role: "+user.getRole());
                System.out.println("The id of the logged in user: " + user.getId());
                if ("Beneficiary".equalsIgnoreCase(user.getRole())) {
                    return "redirect:/student-home";
                } else if ("Donor".equalsIgnoreCase(user.getRole())) {
                    return "redirect:/donor";
                } else if ("Volunteer".equalsIgnoreCase(user.getRole())) {
                    return "redirect:/volunteer_home";
                }else if ("Admin".equalsIgnoreCase(user.getRole())) {
                    return "redirect:/admin-home";
                } else {
                    throw new IllegalArgumentException("Invalid role: " + user.getRole());
                }
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

package com.rungroup.controllers;

import com.rungroup.models.User;
import com.rungroup.models.UserCollection;
import com.rungroup.models.UserIterator;
import com.rungroup.utils.UserFactory;
import com.rungroup.models.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class LoginController {
    private UserCollection userCollection;

    public LoginController() {
        userCollection = new UserCollection();

        User donor = UserFactory.createUser(1L, "Donor", "Laila", "laila@example.com", "laila123", null, null, "None", null, false);
        userCollection.addUser(donor);

        User volunteer = UserFactory.createUser(2L, "Volunteer", "Mariam", "mariam@example.com", "mariam123", null, null, "none", List.of("Teaching", "Organizing"), true);
        userCollection.addUser(volunteer);

        User beneficiary = UserFactory.createUser(3L, "Beneficiary", "Habiba", "habiba@example.com", "habiba123", "Grade 5", LocalDateTime.now(), null, null, false);
        userCollection.addUser(beneficiary);

        User admin = UserFactory.createUser(4L, "Admin", "Adham", "adham@example.com", "adham123", null, null, null, null, false);
        userCollection.addUser(admin);
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
                System.out.println("--------user role: " + user.getRole());
                switch (user.getRole().toLowerCase()) {
                    case "beneficiary":
                        return "redirect:/student-home";
                    case "donor":
                        return "redirect:/";
                    case "volunteer":
                        return "redirect:/volunteer_home";
                    case "admin":
                        return "redirect:/admin-home";
                    default:
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

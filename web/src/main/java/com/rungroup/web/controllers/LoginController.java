package com.rungroup.web.controllers;

import com.rungroup.web.models.User;
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
    private List<User> users = new ArrayList<>();

    public LoginController() {
        // users = new ArrayList<>();
        // User donor = UserFactory.createUser(1L,"Donor", "Laila", "laila@example.com","laila123", null, null,"None",null,false);
        // users.add(donor);
        users.addAll(new DonorRepository().findAll());    
        // User volunteer = UserFactory.createUser(2L,"Volunteer", "Mariam", "mariam@example.com","mariam123", null, null,"none",List.of("Teaching", "Organizing"),true);
        // users.add(volunteer);
        users.addAll(new VolunteerRepository().findAll()); 
        // User beneficiary = UserFactory.createUser(3L,"Beneficiary", "Habiba", "habiba@example.com","habiba123", "Grade 5", LocalDateTime.now(),null,null,false);
        // users.add(beneficiary);
        users.addAll(new BeneficiaryRepository().findAll()); 
        // User admin = UserFactory.createUser(4L,"Admin", "Adham", "adham@example.com","adham123", null, null,null,null,false);
        // users.add(admin);
        users.addAll(new AdminRepository().findAll()); 
    
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
                System.out.println("--------user role: "+user.getRole());
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

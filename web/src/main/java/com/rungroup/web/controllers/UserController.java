package com.rungroup.web.controllers;

import com.rungroup.web.models.User;
import com.rungroup.web.repositories.Implementations.BeneficiaryRepository;
import com.rungroup.web.repositories.Implementations.DonorRepository;
import com.rungroup.web.repositories.Implementations.VolunteerRepository;
import com.rungroup.web.utils.UserFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private final List<User> users = new ArrayList<>();

    public UserController() {
        //users.add(UserFactory.createUser(1L, "Beneficiary", "Charlie", "charlie@gmail.com", "password", "Grade 5", LocalDateTime.now(),null,null,false));
        users.addAll(new BeneficiaryRepository().findAll());
        //users.add(UserFactory.createUser(2L, "Donor", "Bob", "bob@gmail.com", "password", null, null,"Monthly",null,false));
        users.addAll(new DonorRepository().findAll());
        //users.add(UserFactory.createUser(3L, "Volunteer", "Alice", "alice@gmail.com", "password", null, null,null, List.of("Technical", "Organizing"),true));
        users.addAll(new VolunteerRepository().findAll());
    }

    @GetMapping("/manage-users")
    public String showUsers(Model model) {
        model.addAttribute("users", users);
        return "manage-users";
    }

    @PostMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        User u = users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
        boolean removed = users.remove(u);

        // Delete from database
        u.delete();
        
        if (removed) {
            redirectAttributes.addFlashAttribute("message", "User deleted successfully!");
        } else {
            redirectAttributes.addFlashAttribute("error", "User not found!");
        }
        return "redirect:/manage-users";
    }
}


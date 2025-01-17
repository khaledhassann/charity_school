package com.rungroup.web.controllers;

import com.rungroup.web.models.Admin;
import com.rungroup.web.models.Beneficiary;
import com.rungroup.web.models.CurrentUser;
import com.rungroup.web.models.Donor;
import com.rungroup.web.models.User;
import com.rungroup.web.models.Volunteer;
import com.rungroup.web.repositories.Implementations.AdminRepository;
import com.rungroup.web.repositories.Implementations.BeneficiaryRepository;
import com.rungroup.web.repositories.Implementations.DonorRepository;
import com.rungroup.web.repositories.Implementations.VolunteerRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
        Donor donorUser = (Donor) currentUser;
        System.out.println("This is the user in update: "+donorUser);
        System.out.println("-------------preferred type: "+donorUser.getPreferred_type());
        if (currentUser != null) {
            model.addAttribute("donor", donorUser);
            return "update_profile";
        }
        return "redirect:/login";
    }

    @PostMapping("/update_profile")
    public String updateProfile(@RequestParam String name, @RequestParam String email, @RequestParam String password,@RequestParam String preferred_type, Model model) {
        User currentUser = CurrentUser.getUser();
        System.out.println("This is the user in update: "+currentUser);
        
        if (currentUser != null && currentUser instanceof Donor) {
            Donor donorUser = (Donor) currentUser;
            donorUser.setName(name);
            donorUser.setEmail(email);
            if (password != "") {
                donorUser.setPassword(password);
            } else {
                System.out.println("No changes to pass, keeping the current pass: " + donorUser.getPassword());
            }
            donorUser.setPreferred_type(preferred_type);

            // Update the user in the database
            new DonorRepository().update(donorUser);

            System.out.println("------ updated donor preferred type: "+preferred_type);
            model.addAttribute("donor", donorUser); 
            model.addAttribute("message", "Profile updated successfully.");
            return "update_profile";
        }
        
        // model.addAttribute("error", "Failed to update profile.");
        // return "update_profile";
        else {
            return "redirect:/login";}
    }

    @GetMapping("/update_profile-admin")
    public String showAdminUpdateProfilePage(Model model) {
        User currentUser = CurrentUser.getUser();
        System.out.println("This is the user in update: "+currentUser);
        if (currentUser != null) {
            model.addAttribute("admin", currentUser);
            return "admin_update_profile";
        }
        return "redirect:/login";
    }

    @PostMapping("/update_profile-admin")
    public String updateAdminProfile(@RequestParam String name, @RequestParam String email, @RequestParam String password, Model model) {
        User currentUser = CurrentUser.getUser();
        System.out.println("This is the user in update: "+currentUser);
        if (currentUser != null) {
            currentUser.setName(name);
            currentUser.setEmail(email);
            if (password != "") {
                currentUser.setPassword(password);
            } else {
                System.out.println("No changes to pass, keeping the current pass: " + currentUser.getPassword());
            }

            // Update admin in the db
            new AdminRepository().update((Admin) currentUser);

            model.addAttribute("admin", currentUser);
            model.addAttribute("message", "Profile updated successfully.");
            return "admin_update_profile";
        }
        // model.addAttribute("error", "Failed to update profile.");
        // return "admin_update_profile";
        else {
            return "redirect:/login";}
    }

    @GetMapping("/update_profile-volunteer")
    public String showVolunteerUpdateProfilePage(Model model) {
        User currentUser = CurrentUser.getUser();
        if (currentUser instanceof Volunteer) {
            Volunteer volunteerUser = (Volunteer) currentUser;
        System.out.println("This is the user in update: "+volunteerUser);
        System.out.println("-------------Volunteer skills: "+volunteerUser.getSkills());
        System.out.println("This is the user in update: "+currentUser);
        if (currentUser != null) {
            model.addAttribute("volunteer", volunteerUser);
            return "volunteer_update_profile";
        }}
        return "redirect:/login";
    }

    @PostMapping("/update_profile-volunteer")
    public String updateVolunteerProfile(@RequestParam String name, @RequestParam String email, @RequestParam String password, @RequestParam("skills") List<String> skills, @RequestParam boolean availability, Model model) {
        User currentUser = CurrentUser.getUser();
        if (currentUser == null) {
            return "redirect:/login"; // Redirect if no user is logged in
        }
        System.out.println("This is the user in update: "+currentUser);
        if ((currentUser != null && currentUser instanceof Volunteer) ) {
            Volunteer volunteerUser = (Volunteer) currentUser;
            System.out.println("Volunteer Name: " + volunteerUser.getName());
            System.out.println("Volunteer Skills: " + volunteerUser.getSkills());
            System.out.println("Volunteer updated name: " +name);
            System.out.println("Volunteer updated skills: " +skills);
                    volunteerUser.setName(name);
            System.out.println("---------Volunteer name is updated----- ");
            volunteerUser.setEmail(email);
            if (password != "") {
                volunteerUser.setPassword(password);
            } else {
                System.out.println("No changes to pass, keeping the current pass: " + volunteerUser.getPassword());
            }
            if (skills != null) {
                volunteerUser.setSkills(skills);
            } else {
                System.out.println("No changes to skills, keeping the current skills: " + volunteerUser.getSkills());
            }
            volunteerUser.setAvailability(availability);

            // Update the volunteer in the database
            new VolunteerRepository().update(volunteerUser);

            System.out.println("Final Volunteer Skills: " + volunteerUser.getSkills());
            model.addAttribute("volunteer", volunteerUser);
            model.addAttribute("message", "Profile updated successfully.");
            return "volunteer_update_profile";
                }
                else {
                    return "redirect:/login";}
        // model.addAttribute("error", "Failed to update profile.");
        // return "volunteer_update_profile";
    }

    @GetMapping("/update_profile-beneficiary")
    public String showBeneficiaryUpdateProfilePage(Model model) {
        User currentUser = CurrentUser.getUser();
        System.out.println("This is the user in update: "+currentUser);
        if (currentUser != null) {
            model.addAttribute("beneficiary", currentUser);
            return "beneficiary_update_profile";
        }
        return "redirect:/login";
    }

    @PostMapping("/update_profile-beneficiary")
    public String updateBeneficiaryProfile(@RequestParam String name, @RequestParam String email, @RequestParam String password,Model model) {
        User currentUser = CurrentUser.getUser();
        System.out.println("This is the user in update: "+currentUser);
        if (currentUser != null) {
            currentUser.setName(name);
            currentUser.setEmail(email);
            if (password != "") {
                currentUser.setPassword(password);
            } else {
                System.out.println("No changes to pass, keeping the current pass: " + currentUser.getPassword());
            }

            // Update the db
            new BeneficiaryRepository().update((Beneficiary) currentUser);

            model.addAttribute("beneficiary", currentUser);
            model.addAttribute("message", "Profile updated successfully.");
            return "beneficiary_update_profile";
        }
        // model.addAttribute("error", "Failed to update profile.");
        // return "beneficiary_update_profile";
        else {
            return "redirect:/login";}
    }


}

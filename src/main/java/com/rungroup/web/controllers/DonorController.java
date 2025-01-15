// package com.rungroup.web.controllers;

// import com.rungroup.web.models.Donor;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;

// @Controller
// public class DonorController {

//     @GetMapping("/donor/signup")
//     public String showDonorSignupForm(Model model) {
//         model.addAttribute("donor", new Donor());
//         return "signup"; // Use the same signup.html
//     }

//     @PostMapping("/donor/signup")
//     public String processDonorSignup(
//             @RequestParam("name") String name,
//             @RequestParam("email") String email,
//             @RequestParam("password") String password,
//             Model model) {

//         // Process and save the donor details (mock for now)
//         Donor donor = new Donor(name, email, password);
//         System.out.println("Donor Registered: " + donor.getName() + ", " + donor.getEmail());

//         // Add success message
//         model.addAttribute("message", "Donor registered successfully!");
//         model.addAttribute("user", donor);
//         return "success"; // Redirect to success.html
//     }
// }

// package com.rungroup.web.controllers;

// import com.rungroup.web.models.Volunteer;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;

// @Controller
// public class VolunteerController {

//     @GetMapping("/volunteer/signup")
//     public String showVolunteerSignupForm(Model model) {
//         model.addAttribute("volunteer", new Volunteer());
//         return "signup"; // Use the same signup.html
//     }

//     @PostMapping("/volunteer/signup")
//     public String processVolunteerSignup(
//             @RequestParam("name") String name,
//             @RequestParam("email") String email,
//             @RequestParam("password") String password,
//             Model model) {

//         // Process and save the volunteer details (mock for now)
//         Volunteer volunteer = new Volunteer(name, email, password);
//         System.out.println("Volunteer Registered: " + volunteer.getName() + ", " + volunteer.getEmail());

//         // Add success message
//         model.addAttribute("message", "Volunteer registered successfully!");
//         model.addAttribute("user", volunteer);
//         return "success"; // Redirect to success.html
//     }
// }

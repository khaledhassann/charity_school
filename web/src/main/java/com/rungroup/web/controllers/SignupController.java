// package com.rungroup.web.controllers;

// import com.rungroup.web.models.Donor;
// import com.rungroup.web.models.Volunteer;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;

// @Controller
// public class SignupController {

//     private static long idCounter = 1L; // Counter for generating unique IDs

//     // Synchronized method to generate unique IDs
//     private synchronized long generateId() {
//         return idCounter++;
//     }

//     @GetMapping("/signup")
//     public String showSignupPage() {
//         return "signup"; // Render the signup.html page
//     }

//     @PostMapping("/signup")
//     public String processSignup(
//             @RequestParam("name") String name,
//             @RequestParam("email") String email,
//             @RequestParam("password") String password,
//             @RequestParam("role") String role,
//             Model model) {
//         long generatedId = generateId(); // Generate a unique ID of type long

//         if ("donor".equalsIgnoreCase(role)) {
//             // Create and process a new Donor instance
//             Donor donor = new Donor();
//             donor.setId(generatedId); // Set generated ID
//             donor.setName(name);
//             donor.setEmail(email);
//             donor.setPassword(password);
//             // Save donor (typically, this would involve a repository or service layer)
//             System.out.println("Donor Registered: " + donor.getName() + ", " + donor.getEmail() + ", ID: " + donor.getId());
//             model.addAttribute("message", "Donor registered successfully!");
//             return "signup";
//         } else if ("volunteer".equalsIgnoreCase(role)) {
//             // Create and process a new Volunteer instance
//             Volunteer volunteer = new Volunteer();
//             volunteer.setId(generatedId); // Set generated ID
//             volunteer.setName(name);
//             volunteer.setEmail(email);
//             volunteer.setPassword(password);
//             // Save volunteer (typically, this would involve a repository or service layer)
//             System.out.println("Volunteer Registered: " + volunteer.getName() + ", " + volunteer.getEmail() + ", ID: " + volunteer.getId());
//             model.addAttribute("message", "Volunteer registered successfully!");
//             return "signup";
//         } else {
//             // Handle invalid role
//             model.addAttribute("error", "Invalid role selected. Please choose Donor or Volunteer.");
//             return "signup";
//         }
//     }
//     }
package com.rungroup.web.controllers;

import com.rungroup.web.models.Donor;
import com.rungroup.web.models.Volunteer;
import com.rungroup.web.repositories.Implementations.DonorRepository;
import com.rungroup.web.repositories.Implementations.VolunteerRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignupController {


    @GetMapping("/signup")
    public String showSignupPage(Model model) {
        model.addAttribute("user", new Donor());
        model.addAttribute("user", new Volunteer());
        return "signup"; // Render the signup.html page
    }

    @PostMapping("/signup")
    public String processSignup(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("role") String role,
            Model model
    ) {
  
        if ("donor".equalsIgnoreCase(role)) {
            Donor donor = new Donor();
            donor.setName(name);
            donor.setEmail(email);
            donor.setPassword(password);

            // Save or process the donor object (repository logic can go here)
            System.out.println("Donor Registered: " + donor.getName() + ", " + donor.getEmail() + ", ID: " + donor.getId());

            // Add Donor to database
            DonorRepository donorRepository = new DonorRepository();
            donorRepository.insert(donor);

            model.addAttribute("message", "Donor registered successfully!");
             // Redirect to success or render a success message
      return "signup";
        } else if ("volunteer".equalsIgnoreCase(role)) {
            Volunteer volunteer = new Volunteer();
            volunteer.setName(name);
            volunteer.setEmail(email);
            volunteer.setPassword(password);


            // Save or process the volunteer object (repository logic can go here)
            System.out.println("Volunteer Registered: " + volunteer.getName() + ", " + volunteer.getEmail() + ", ID: " + volunteer.getId());

            // Add Volunteer to database
            VolunteerRepository volunteerRepository = new VolunteerRepository();
            volunteerRepository.insert(volunteer);
            
            model.addAttribute("message", "Volunteer registered successfully!");
             // Redirect to success or render a success message
       return "signup";
        } else {
            // Handle invalid role
            model.addAttribute("error", "Invalid role selected. Please choose Donor or Volunteer.");
            return "signup";
        }

       
    }
}

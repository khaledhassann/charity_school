// package com.rungroup.web.controllers;

// import com.rungroup.web.models.Donor;
// import com.rungroup.web.repositories.Implementations.DonorRepository;

// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;

// @Controller
// public class DonorController {
//     DonorRepository rs = new DonorRepository();

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
//         // we don't provide prefered type
//         Donor donor = new Donor();
//         donor.setName(name);
//         donor.setEmail(email);
//         donor.setPassword(password);
//         System.out.println("Donor Registered: " + donor.getName() + ", " + donor.getEmail());

//         // Save the donor to the database
//         rs.insert(donor);

//         // Add success message
//         model.addAttribute("message", "Donor registered successfully!");
//         model.addAttribute("user", donor);
//         return "success"; // Redirect to success.html
//     }
// }
package com.rungroup.web.controllers;

import com.rungroup.web.models.Donation;
import com.rungroup.web.models.Donor;
import com.rungroup.web.repositories.Implementations.DonationRepository;
import com.rungroup.web.models.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class DonorController {

    private Donor donor;
    private List<Donation> donations = new ArrayList<>();
    private Donation lastDonation;
    private DonationRepository dr = new DonationRepository();

    public DonorController() {
        // donations.add(new Donation(1L, 100.0, 1L, LocalDateTime.now().minusDays(10), "Credit Card"));
        // donations.add(new Donation(2L, 50.0, 1L, LocalDateTime.now().minusDays(5), "PayPal"));
        // donations.add(new Donation(3L, 200.0, 2L, LocalDateTime.now().minusDays(3), "Bank Transfer"));
        donations = dr.findAll();
    }

    @GetMapping("/donate")
    public String showDonationForm(Model model) {
        this.donor = (Donor) CurrentUser.getUser();
        model.addAttribute("lastDonation", lastDonation);
        return "donation";
    }

    @PostMapping("/donate")
    public String makeDonation(
            @RequestParam("amount") Double amount,
            @RequestParam("payment_method") String paymentMethod,
            Model model
    ) {
        this.donor = (Donor) CurrentUser.getUser();

        // Create a new donation
        lastDonation = new Donation();
        lastDonation.setAmount(amount);
        lastDonation.setUser_id(donor.getId());
        lastDonation.setDate(LocalDateTime.now());
        lastDonation.setPayment(paymentMethod);
        


        donations.add(lastDonation);
        dr.insert(lastDonation); // Fix the repo

        donor.makeDonation(lastDonation);   // Currently returns true only


        model.addAttribute("message", "Donation successful!");
        model.addAttribute("lastDonation", lastDonation);
        return "redirect:/successfulDonation";
    }

    @GetMapping("/successfulDonation")
    public String showSuccessPage(Model model) {
        if (lastDonation != null) {
            System.out.println("--------last donation amount: "+lastDonation.getAmount());
            System.out.println("--------last donation payment: "+lastDonation.getPayment());
            System.out.println("--------last donation amount: "+lastDonation.getFormattedDate());
            // Providing the model
            model.addAttribute("lastDonation", lastDonation);
            return "successfulDonation";
        }
        else
        return "donation";
    }

    @PostMapping("/refund")
    public String refundDonation(Model model) {
        if (lastDonation != null) {
            donations.remove(lastDonation);
            // Remove the donation from the databaser
            dr.deleteById(lastDonation.getId());
            System.out.println("Called #############");
            // donor.getDonations().remove(lastDonation);
            model.addAttribute("message", "Donation refunded successfully!");
            lastDonation = null;
        } else {
            model.addAttribute("message", "No donation available for refund.");
        }

        return "redirect:/donate";
    }

    @GetMapping("/donation_history")
    public String viewDonationHistory(Model model) {
        this.donor = (Donor) CurrentUser.getUser();
        List<Donation> userDonations = donations.stream()
                .filter(donation -> donation.getUser_id().equals(donor.getId()))
                .collect(Collectors.toList());

        model.addAttribute("donations", userDonations);
        return "donation_history";
    }
}

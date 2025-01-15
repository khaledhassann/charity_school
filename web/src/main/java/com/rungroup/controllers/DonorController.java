package com.rungroup.controllers;

import com.rungroup.models.Donation;
import com.rungroup.models.Donor;
import com.rungroup.models.CurrentUser;
import com.rungroup.models.User;
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

    public DonorController() {
        donations.add(new Donation(1L, 100.0, 1L, LocalDateTime.now().minusDays(10), "Credit Card"));
        donations.add(new Donation(2L, 50.0, 1L, LocalDateTime.now().minusDays(5), "PayPal"));
        donations.add(new Donation(3L, 200.0, 2L, LocalDateTime.now().minusDays(3), "Bank Transfer"));
    }

    // Show donation form
    @GetMapping("/donate")
    public String showDonationForm() {
        this.donor = (Donor) CurrentUser.getUser(); 
        System.out.println("This is the donor in donate: "+ donor);
        return "donation";
    }

    // Handle donation form submission
    @PostMapping("/donate")
    public String makeDonation(
            @RequestParam("amount") double amount,
            @RequestParam("payment_method") String paymentMethod,
            Model model
    ) {

        this.donor = (Donor) CurrentUser.getUser(); 
        System.out.println("This is the donor in donate: "+ donor);

        // Create a new donation
        Donation newDonation = new Donation(
                (long) (donations.size() + 1),
                amount,
                donor.getId(),
                LocalDateTime.now(),
                paymentMethod
        );

        donations.add(newDonation);
        donor.makeDonation(newDonation);

        model.addAttribute("message", "Donation successful!");
        return "donation";
    }

    // View donation history
    @GetMapping("/donation_history")
    public String viewDonationHistory(Model model) {
        this.donor = (Donor) CurrentUser.getUser();
        System.out.println("This is the donor in view history: "+ donor);

        // Filter donations to include only those made by the current donor
        List<Donation> userDonations = donations.stream()
                .filter(donation -> donation.getUserId().equals(donor.getId()))
                .collect(Collectors.toList());

        System.out.println("Donations for current user: " + userDonations.size());
        model.addAttribute("donations", userDonations);

        return "donation_history";
    }
}

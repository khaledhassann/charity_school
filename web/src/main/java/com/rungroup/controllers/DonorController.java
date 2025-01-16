package com.rungroup.controllers;

import com.rungroup.models.Donation;
import com.rungroup.models.Donor;
import com.rungroup.models.CurrentUser;
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
    private Donation lastDonation = null;

    public DonorController() {
        donations.add(new Donation(1L, 100.0, 1L, LocalDateTime.now().minusDays(10), "Credit Card"));
        donations.add(new Donation(2L, 50.0, 1L, LocalDateTime.now().minusDays(5), "PayPal"));
        donations.add(new Donation(3L, 200.0, 2L, LocalDateTime.now().minusDays(3), "Bank Transfer"));
    }

    @GetMapping("/donate")
    public String showDonationForm(Model model) {
        this.donor = (Donor) CurrentUser.getUser();
        model.addAttribute("lastDonation", lastDonation);
        return "donation";
    }

    @PostMapping("/donate")
    public String makeDonation(
            @RequestParam("amount") double amount,
            @RequestParam("payment_method") String paymentMethod,
            Model model
    ) {
        this.donor = (Donor) CurrentUser.getUser();

        // Create a new donation
        lastDonation = new Donation(
                (long) (donations.size() + 1),
                amount,
                donor.getId(),
                LocalDateTime.now(),
                paymentMethod
        );

        donations.add(lastDonation);
        donor.makeDonation(lastDonation);

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
        return "successfulDonation";}
        else
        return "donation";
    }

    @PostMapping("/refund")
    public String refundDonation(Model model) {
        if (lastDonation != null) {
            donations.remove(lastDonation);
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
                .filter(donation -> donation.getUserId().equals(donor.getId()))
                .collect(Collectors.toList());

        model.addAttribute("donations", userDonations);
        return "donation_history";
    }
}

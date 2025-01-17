package com.rungroup.controllers;

import com.rungroup.models.Donation;
import com.rungroup.models.Donor;
import com.rungroup.models.PayPalPayment;
import com.rungroup.models.Payment;
import com.rungroup.utils.DonateCommand;
import com.rungroup.utils.PaymentStrategy;
import com.rungroup.models.BankTransferPayment;
import com.rungroup.models.CreditCardPayment;
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
        @RequestParam(value = "cc_number", required = false) String ccNumber,
        @RequestParam(value = "cc_holderName", required = false) String ccHolderName,
        @RequestParam(value = "cc_expiration", required = false) String ccExpiration,
        @RequestParam(value = "cc_cvv", required = false) String ccCVV,
        @RequestParam(value = "paypal_email", required = false) String paypalEmail,
        @RequestParam(value = "paypal_pass", required = false) String paypalPassword,
        @RequestParam(value = "bank_account", required = false) String bankAccount,
        @RequestParam(value = "bank_name", required = false) String bankName,
        Model model
) {
    this.donor = (Donor) CurrentUser.getUser();

    // Determine the payment strategy based on the selected method
    PaymentStrategy paymentStrategy = null;
    switch (paymentMethod) {
        case "credit-card":
            paymentStrategy = new CreditCardPayment(ccNumber, ccHolderName, ccExpiration, ccCVV);
            break;
        case "paypal":
            paymentStrategy = new PayPalPayment(paypalEmail, paypalPassword);
            break;
        case "bank-transfer":
            paymentStrategy = new BankTransferPayment(bankAccount, bankName);
            break;
        default:
            model.addAttribute("message", "Invalid payment method selected.");
            return "donation";
    }

    // // Create a new donation
    // lastDonation = new Donation(
    //         (long) (donations.size() + 1),
    //         amount,
    //         donor.getId(),
    //         LocalDateTime.now(),
    //         paymentMethod
    // );

    // Use the strategy in the donation
    Payment payment = new Payment(paymentStrategy);
    // payment.setPaymentStrategy(paymentStrategy);

    if (payment.pay(amount)) {
        // Process the donation using the command pattern
        // DonateCommand donateCommand = new DonateCommand(lastDonation);
        // donor.setCommand(donateCommand);
            // Create a new donation
        lastDonation = new Donation(
            (long) (donations.size() + 1),
            amount,
            donor.getId(),
            LocalDateTime.now(),
            paymentMethod
    );
        donor.makeDonation(lastDonation);
        donations.add(lastDonation);

        model.addAttribute("message", "Donation successful!");
        model.addAttribute("lastDonation", lastDonation);
        System.out.println("donation"+lastDonation);
        return "redirect:/successfulDonation";
    } else {
        model.addAttribute("message", "Payment failed. Please try again.");
        return "donation";
    }
}

    @GetMapping("/successfulDonation")
    public String showSuccessPage(Model model) {
        if (lastDonation != null) {
            System.out.println("--------last donation amount: "+lastDonation.getAmount());
            System.out.println("--------last donation payment: "+lastDonation.getPayment());
            System.out.println("--------last donation date: "+lastDonation.getFormattedDate());
            model.addAttribute("lastDonation", lastDonation);

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
        this.donor = (Donor) CurrentUser.getUser();
         donor.undoDonation(lastDonation);

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

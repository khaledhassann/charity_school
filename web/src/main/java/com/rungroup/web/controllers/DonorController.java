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
import com.rungroup.web.models.PayPalPayment;
import com.rungroup.web.repositories.Implementations.DonationRepository;
import com.rungroup.web.utils.DonateCommand;
import com.rungroup.web.utils.PaymentStrategy;
import com.rungroup.web.models.BankTransferPayment;
import com.rungroup.web.models.CreditCardPayment;
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

        // Create a new donation
        lastDonation = new Donation();
        lastDonation.setAmount(amount);
        lastDonation.setUser_id(donor.getId());
        lastDonation.setDate(LocalDateTime.now());
        lastDonation.setPayment(paymentMethod);

        // Set the payment strategy
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

        // Set the strategy on the donation and prepare the command
        lastDonation.setPaymentStrategy(paymentStrategy);
        DonateCommand donateCommand = new DonateCommand(lastDonation);

        // Assign the command to the donor and execute
        donor.setCommand(donateCommand);
        try {
            donor.makeDonation(lastDonation);
            donations.add(lastDonation);

            // // Save the donation in the database
            // dr.insert(lastDonation);

            model.addAttribute("message", "Donation successful!");
            model.addAttribute("lastDonation", lastDonation);
            return "redirect:/successfulDonation";
        } catch (Exception e) {
            model.addAttribute("message", "Donation failed: " + e.getMessage());
            return "donation";
        }
    }

    @GetMapping("/successfulDonation")
    public String showSuccessPage(Model model) {
        if (lastDonation != null) {
            model.addAttribute("lastDonation", lastDonation);
            return "successfulDonation";
        }
        return "donation";
    }

    @PostMapping("/refund")
    public String refundDonation(Model model) {
        this.donor = (Donor) CurrentUser.getUser();

        if (lastDonation == null) {
            model.addAttribute("message", "No donation available for refund.");
            return "donation";
        }

        try {
            donor.undoDonation(lastDonation);
            donations.remove(lastDonation);
            model.addAttribute("message", "Donation refunded successfully!");
            lastDonation = null;
        } catch (Exception e) {
            model.addAttribute("message", "Refund failed: " + e.getMessage());
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
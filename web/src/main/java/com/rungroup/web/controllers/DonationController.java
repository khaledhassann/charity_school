package com.rungroup.web.controllers;

import com.rungroup.web.models.Donation;
import org.springframework.stereotype.Controller;

@Controller
public class DonationController {

    public boolean processDonation(Donation donation) {
        System.out.println("Processing donation: " + donation.getDetails());
        return true;
    }
}

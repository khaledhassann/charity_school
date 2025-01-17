package com.rungroup.utils;

import com.rungroup.models.Donation;

// Concrete Command
public class DonateCommand implements Command {
    private Donation donation;

    public DonateCommand(Donation donation) {
        this.donation = donation;
    }

    @Override
    public void execute() {
        // Process the donation
        donation.processDonation();
    }

    @Override
    public void undo() {
        // Refund the donation
        donation.refundDonation();
    }
}
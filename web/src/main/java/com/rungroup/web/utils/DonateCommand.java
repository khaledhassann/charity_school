package com.rungroup.web.utils;

import com.rungroup.web.models.Donation;

// Concrete Command
public class DonateCommand implements Command {
    private Donation donation;

    public DonateCommand(Donation donation) {
        this.donation = donation;
    }

    @Override
    public void execute() {
        if (!donation.processDonation()) {
            throw new RuntimeException("Donation processing failed!");
        }
    }

    @Override
    public void undo() {
        if (!donation.refundDonation()) {
            throw new RuntimeException("Refund processing failed!");
        }
    }
}
package com.rungroup.models;

import com.rungroup.utils.Command;

import java.util.ArrayList;
import java.util.List;

public class Donor extends User {
    private String preferredType;
    private List<Donation> donationHistory;
    private Command command;

    public Donor(Long id, String name, String email, String password, String preferredType) {
        super(id, name, email, password);
        this.preferredType = preferredType;
        this.donationHistory = new ArrayList<>();
    }

    public String getPreferredType() {
        return preferredType;
    }

    public void setPreferredType(String preferredType) {
        this.preferredType = preferredType;
    }

    @Override
    public String getRole() {
        return "Donor";
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public boolean makeDonation(Donation donation) {
        if (command != null) {
            command.execute();
            return true;
        }
        throw new IllegalStateException("Command not set.");
    }

    public void undoDonation(Donation donation) {
        if (command != null) {
            command.undo();
        } else {
            throw new IllegalStateException("Command not set.");
        }
    }

    // public List<Donation> viewDonationHistory() {
    //     return new ArrayList<>(donationHistory);
    // }
}
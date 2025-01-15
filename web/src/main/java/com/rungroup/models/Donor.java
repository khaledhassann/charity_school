package com.rungroup.models;
import java.util.ArrayList;
import java.util.List;

public class Donor extends User {
    // private String preferredType;
    private List<Donation> donationHistory;

    public Donor(Long id, String name, String email, String password) {
        super(id, name, email, password);
        // this.preferredType = preferredType;
        this.donationHistory = new ArrayList<>();
    }

    // public String getPreferredType() {
    //     return preferredType;
    // }

    // public void setPreferredType(String preferredType) {
    //     this.preferredType = preferredType;
    // }

    @Override
    public String getRole() {
        return "Donor";
    }

    public boolean makeDonation(Donation donation) {
        return true;
    }

    public List<Donation> viewDonationHistory() {
        return new ArrayList<>(donationHistory);
    }

    public boolean updateProfile(String updatedName, String updatedEmail) {
        if (updatedName != null && !updatedName.isBlank()) {
            setName(updatedName);
        }
        if (updatedEmail != null && !updatedEmail.isBlank()) {
            setEmail(updatedEmail);
        }
        return true; 
    }
}
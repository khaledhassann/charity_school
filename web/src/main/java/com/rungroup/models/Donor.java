package com.rungroup.models;
import java.util.ArrayList;
import java.util.List;

import com.rungroup.utils.Command;

public class Donor extends User {
    private String preferred_type;
    private List<Donation> donationHistory;
    private Command command;

    public Donor(Long id, String name, String email, String password,String preferred_type) {
        super(id, name, email, password);
        this.preferred_type=preferred_type;
        this.donationHistory = new ArrayList<>();
    }

    public String getPreferredType() {
        return preferred_type;
    }

    public void setPreferredType(String preferred_type) {
        this.preferred_type = preferred_type;
    }

    @Override
    public String getRole() {
        return "Donor";
    }
     
    public void setCommand(Command command) {
    this.command = command;
    }
    public boolean makeDonation(Donation donation) {
            // command.execute();
            return true;
    }

    public void undoDonation(Donation donation) {
            command.undo();
        
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
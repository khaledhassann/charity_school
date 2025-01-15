package com.rungroup.models;

import java.time.LocalDateTime;

public class ParticipateDetails extends VerbDetails {
    private String role;

    public ParticipateDetails(User user, Object target, Verb verb,  String role) {
        super(user, target, verb);
        this.role = role;
    }

    // Getters and Setters
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

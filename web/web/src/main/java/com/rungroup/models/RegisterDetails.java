package com.rungroup.models;


import java.time.LocalDateTime;

public class RegisterDetails extends VerbDetails {
    private String status;

    public RegisterDetails(User user, Object target, Verb verb,  String status) {
        super(user, target, verb);
        this.status = status;
    }

    // Getters and Setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}


package com.rungroup.models;

import java.time.LocalDateTime;

public class TeachDetails extends VerbDetails {
    private double hoursTaught;

    public TeachDetails(User user, Object target, Verb verb,  double hoursTaught) {
        super(user, target, verb);
        this.hoursTaught = hoursTaught;
    }

    // Getters and Setters
    public double getHoursTaught() {
        return hoursTaught;
    }

    public void setHoursTaught(double hoursTaught) {
        this.hoursTaught = hoursTaught;
    }
}
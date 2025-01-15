package com.rungroup.models;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.format.annotation.DateTimeFormat;

public class Donation {
    private Long id;
    private double amount;
    private Long userId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime date;
    // private Payment payment; 
    private String payment;

    public Donation(Long id, double amount, Long userId, LocalDateTime date, String payment) {
        this.id = id;
        this.amount = amount;
        this.userId = userId;
        this.date = date;
        this.payment = payment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public boolean processDonation() {
        return true;
    }

    public String getDetails() {
        return "Donation ID: " + id + ", Amount: " + amount + ", User ID: " + userId + ", Date: " + date + ", Payment: " + payment;
    }
    public String getFormattedDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(formatter); 
    }
}

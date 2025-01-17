package com.rungroup.web.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Donation")
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double amount;
    private Long user_id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime date;
    // private String payment_id;      // I edited this 
    private String payment;
    @Column(name = "created_at", updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime created_at;
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updated_at;


    public boolean processDonation() {
        return true;
    }

    public String getFormattedDate(){
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(f);
    }

    public String getDetails() {
        return "Donation ID: " + id + ", Amount: " + amount + ", User ID: " + user_id + ", Date: " + date + ", Payment: " + payment;
    }
}

package com.rungroup.web.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.format.annotation.DateTimeFormat;

import com.rungroup.web.repositories.Implementations.DonationRepository;
import com.rungroup.web.utils.PaymentStrategy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
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
    @Column(name = "created_at", updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime created_at;
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updated_at;
    @Transient
    private PaymentStrategy paymentStrategy; 
    @Transient
    private DonationRepository dr = new DonationRepository(); 
    private String payment;


    public boolean processDonation() {
        if (paymentStrategy == null) {
            throw new IllegalStateException("Payment strategy not set.");
        }

        if (paymentStrategy.pay(amount)) {
            // donations.add(this);
            // Add the donation to the database
            dr.insert(this);
            return true;
        }
        return false;
    }

    public boolean refundDonation() {
        return dr.deleteById(this.getId());
    }

    public String getFormattedDate(){
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(f);
    }

    public String getDetails() {
        return "Donation ID: " + id + ", Amount: " + amount + ", User ID: " + user_id + ", Date: " + date + ", Payment: " + payment;
    }

    
}

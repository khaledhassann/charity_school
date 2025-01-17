package com.rungroup.models;
import com.rungroup.utils.PaymentStrategy;

public class Payment {
    private PaymentStrategy paymentStrategy;

    public Payment(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public boolean pay(double amount) {
        return paymentStrategy.pay(amount);
    }

    // SETTERS AND GETTERS
    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
}
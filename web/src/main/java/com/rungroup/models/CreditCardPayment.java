package com.rungroup.models;

import com.rungroup.utils.PaymentStrategy; // Import the interface

public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolderName;
    private String expiryDate;
    private String cvv;

    public CreditCardPayment(String cardNumber, String cardHolderName, String expiryDate, String ccCVV) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
        this.cvv = ccCVV;
    }

    @Override
    public boolean pay(double amount) {
        return validate(cardNumber, cardHolderName, expiryDate, cvv);
    }

    private boolean validate(String cardNumber, String cardHolderName, String expiryDate, String cvv) {
        // validate card details
        if (cardNumber.length() == 16 && cardHolderName instanceof String && expiryDate.length() == 5
                && cvv.length() ==3) {
            return true;
        } else {
            return false;
        }
    }

    // SETTERS AND GETTERS
    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

}
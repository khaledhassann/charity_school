public class CreditCardPayment implements IPaymentStrategy {
    private String cardNumber;
    private String cardHolderName;
    private String expiryDate;
    private int cvv;

    public CreditCardPayment(String cardNumber, String cardHolderName, String expiryDate, int cvv) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    @Override
    public boolean pay(double amount) {
        return validate(cardNumber, cardHolderName, expiryDate, cvv);
    }

    private boolean validate(String cardNumber, String cardHolderName, String expiryDate, int cvv) {
        // validate card details
        if (cardNumber.length() == 16 && cardHolderName instanceof String && expiryDate.length() == 5
                && cvv >= 100 && cvv <= 999) {
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

    public int getCvv() {
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

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

}

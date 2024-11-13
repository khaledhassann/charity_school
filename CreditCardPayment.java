public class CreditCardPayment implements IPaymentStrategy {
    private String cardNumber;
    private String cardHolderName;
    private String expiryDate;
    private int cvv;

    @Override
    public boolean pay(double amount) {
        return true;
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

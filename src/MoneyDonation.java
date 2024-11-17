public class MoneyDonation implements IDonationStrategy {
    private double amount;
    private String paymentMethod;
    private Payment payment;

    public MoneyDonation(double amount,Payment payment){
        this.amount=amount;
        this.payment=payment;
    }

    public String getPaymentMethod() {
        return payment.getPaymentStrategy().getName();
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public MoneyDonation(double amount, String paymentMethod) {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    @Override
    public boolean donate() {
        if (payment == null || payment.getPaymentStrategy() == null) {
            System.out.println("No payment strategy selected. Donation failed.");
            return false;
        }

        System.out.println("Processing monetary donation of " + amount + " via " + payment.getPaymentStrategy().getName());
        boolean paymentSuccessful = payment.pay(amount);

        if (paymentSuccessful) {
            System.out.println("Payment successful. Thank you for your donation!");
        } else {
            System.out.println("Payment failed. Please try again.");
        }

        return paymentSuccessful; 
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
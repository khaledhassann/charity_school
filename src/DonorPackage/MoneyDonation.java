package DonorPackage;

public class MoneyDonation implements IDonationStrategy {
    private double amount;
    private String paymentMethod;

    public String getPaymentMethod() {
        return paymentMethod;
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
        System.out.println("Processing monetary donation of " + amount + " via " + paymentMethod);
        return true; 
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
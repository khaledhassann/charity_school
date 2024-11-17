package DonorPackage;
public class Payment {
    private IPaymentStrategy paymentStrategy;

    public Payment(IPaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public boolean pay(double amount) {
        return paymentStrategy.pay(amount);
    }

    // SETTERS AND GETTERS
    public IPaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setPaymentStrategy(IPaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
}

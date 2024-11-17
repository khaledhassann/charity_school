public interface IPaymentStrategy {
    String getName();
    public boolean pay(double amount);

}

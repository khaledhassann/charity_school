public class PayPalPayment implements IPaymentStrategy {
    private String email;
    private String password;

    @Override
    public boolean pay(double amount) {
        return true;
    }

    // SETTERS AND GETTERS
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
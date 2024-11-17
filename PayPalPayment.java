public class PayPalPayment implements IPaymentStrategy {
    private String email;
    private String password;

    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean pay(double amount) {
        return validate(email, password);
    }

    private boolean validate(String email, String password) {
        if (email.contains("@") && password.length() > 5) {
            return true;
        } else {
            return false;
        }
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

package Login;

public class LoginContext {
    private ILoginStrategy loginStrategy;

    // Constructor to set the strategy
    public LoginContext(ILoginStrategy loginStrategy) {
        this.loginStrategy = loginStrategy;
    }

    // Method to perform login using the chosen strategy
    public boolean executeLogin(String username, String password) {
        return loginStrategy.login(username, password);
    }

    // Method to change the login strategy if needed
    public void setLoginStrategy(ILoginStrategy loginStrategy) {
        this.loginStrategy = loginStrategy;
    }
}


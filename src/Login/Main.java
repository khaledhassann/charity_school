package Login;

public class Main {

    public static void main(String[] args) {
        
        LoginContext loginContext = new LoginContext(new StudentLoginStrategy());
        loginContext.executeLogin();
        
        loginContext.setLoginStrategy(new VolunteerLoginStrategy());
        loginContext.executeLogin();
        
        loginContext.setLoginStrategy(new DonorLoginStrategy());
        loginContext.executeLogin();
    }
}
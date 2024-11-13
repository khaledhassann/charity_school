package Login;

public class Main {

    public static void main(String[] args) {
        
        LoginContext loginContext = new LoginContext(new StudentLoginStrategy());
        loginContext.executeLogin("userName", "passWord");
        
        loginContext.setLoginStrategy(new VolunteerLoginStrategy());
        loginContext.executeLogin("userName", "passWord");
        
        loginContext.setLoginStrategy(new DonorLoginStrategy());
        loginContext.executeLogin("userName", "passWord");
    }
}
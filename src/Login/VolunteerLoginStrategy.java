package Login;

public class VolunteerLoginStrategy implements ILoginStrategy {
    @Override
    public void login() {
        System.out.println("Logging in as a volunteer...");
        // Redirect to volunteer dashboard
    }
}


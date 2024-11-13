package Login;

public class VolunteerLoginStrategy implements ILoginStrategy {
    @Override
    public boolean login(String username, String password) {
        System.out.println("Logging in as a volunteer...");
        // Redirect to volunteer dashboard
        return true;
    }
}


package Login;

public class DonorLoginStrategy implements ILoginStrategy {
    @Override
    public boolean login(String username, String password) {
        System.out.println("Logging in as a donor...");
        // Redirect to donor dashboard
        return true;
    }
}

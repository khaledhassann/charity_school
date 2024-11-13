package Login;

public class DonorLoginStrategy implements ILoginStrategy {
    @Override
    public void login() {
        System.out.println("Logging in as a donor...");
        // Redirect to donor dashboard
    }
}

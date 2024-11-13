package Login;

public class StudentLoginStrategy implements ILoginStrategy {
    @Override
    public boolean login(String username, String password) {
        System.out.println("Logging in as a student...");
        // Redirect to student dashboard
        return true;
    }
}

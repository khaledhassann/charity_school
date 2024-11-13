package Login;

public class StudentLoginStrategy implements ILoginStrategy {
    @Override
    public void login() {
        System.out.println("Logging in as a student...");
        // Redirect to student dashboard
    }
}

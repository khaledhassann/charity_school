package Login;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StudentLoginStrategy extends ILoginStrategy {


    private final String filePath = "./src/Data/Students.txt";
    @Override
    public boolean login(String username, String password) {
        // System.out.print("Validating credentials..." + username + " " + password);
        if (!validate(username, password, filePath)) {
            System.out.println("Invalid credentials. Please try again.");
            return false;
        }
        // Redirect to student dashboard
        System.out.println("Forward to student menu.");

        // Route to relevant page

        return true;
    }
}

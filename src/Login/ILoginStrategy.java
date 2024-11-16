package Login;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class ILoginStrategy {

    abstract public boolean login(String username, String password);
        // Validate username and password against the file

        
    protected static boolean validate (String username, String password, String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Read each line in the file
            while ((line = reader.readLine()) != null) {
                String[] credentials = line.split("\\s+"); // Split by space (or use "," for comma)
                if (credentials.length == 2) {
                    String fileUsername = credentials[0];
                    String filePassword = credentials[1];

                    // Compare the input credentials with the file data
                    if (fileUsername.equals(username) && filePassword.equals(password)) {
                        return true; // Valid credentials
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the credentials file: " + e.getMessage());
        }
        return false; // Invalid credentials
    }
}

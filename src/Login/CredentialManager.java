package Login;

import java.io.*;
import java.util.*;

public class CredentialManager {
    private static CredentialManager instance; // Singleton instance
    private Map<String, String> credentials;   // Store username-password pairs in memory

    // Private constructor to prevent external instantiation
    private CredentialManager(String filePath) {
        credentials = new HashMap<>();
        loadCredentials(filePath);
    }

    // Public method to get the Singleton instance
    public static CredentialManager getInstance(String filePath) {
        if (instance == null) {
            synchronized (CredentialManager.class) { // Ensure thread safety
                if (instance == null) {
                    instance = new CredentialManager(filePath);
                }
            }
        }
        return instance;
    }

    // Load credentials from the file into memory
    private void loadCredentials(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] credentialsArray = line.split("\\s+"); // Split by space or tab
                if (credentialsArray.length == 2) {
                    credentials.put(credentialsArray[0], credentialsArray[1]); // username -> password
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading credentials file: " + e.getMessage());
        }
    }

    // Validate the username and password
    public boolean validate(String username, String password) {
        if (credentials.containsKey(username)) {
            return credentials.get(username).equals(password);
        }
        return false;
    }
}
package Login;

import VolunteerPackage.VolunteerTest;
public class VolunteerLoginStrategy extends ILoginStrategy {
    private final String filePath = "./src/Data/Volunteers.txt";
    @Override
    public boolean login(String username, String password) {
        // System.out.print("Validating credentials..." + username + " " + password);
        if (!validate(username, password, filePath)) {
            System.out.println("Invalid credentials. Please try again.");
            return false;
        }
        // Redirect to volunteer dashboard
        System.out.println("Forward to volunteer menu.");

        // Route to relevant page
        VolunteerTest.showMenu();
        return true;
    }
}


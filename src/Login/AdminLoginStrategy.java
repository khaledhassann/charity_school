package Login;

import Room.RoomView;
import School.*;
public class AdminLoginStrategy extends ILoginStrategy {
    private final String filePath = "./src/Data/Admins.txt";
    @Override
    public boolean login(String username, String password) {
        // System.out.print("Validating credentials..." + username + " " + password);
        if (!validate(username, password, filePath)) {
            System.out.println("Invalid credentials. Please try again.");
            return false;
        }
        // Redirect to donor dashboard
        System.out.println("Forward to Admin menu");

        // Route to relevant page
        SchoolView mockSchoolView = new SchoolView();
        RoomView roomView = new RoomView();
        DonationView donationView = new DonationView();
        EventView eventView = new EventView();
        // Create the AdminView and set the SchoolView
        AdminView adminView = new AdminView(mockSchoolView, roomView, donationView,
        eventView);
        adminView.showMainMenu();
        
        return true;
    }
}

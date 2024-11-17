package School;

import java.util.List;

import Room.RoomView;

// public class Main {
//     public static void main(String[] args) {
//         List<Subject> subjects = new ArrayList<Subject>() {
//             {
//                 add(new AdvancedModule(new Math()));
//                 add(new Science());
//                 add(new ExtraCurricular(new History()));
//             }
//         };

//         SchoolModel AinShamsLanguageSchool = new SchoolModel("Ain Shams Language School", "Abbaseya", subjects);
//         SchoolController schoolController = new SchoolController(AinShamsLanguageSchool);
//         SchoolView schoolView = new SchoolView(schoolController);

//         schoolView.showMenu();
//     }

// }
public class AdminMain {
    public static void showMenu() {
        // Create a mock SchoolView to pass into AdminView
        SchoolView mockSchoolView = new SchoolView();
        RoomView roomView = new RoomView();
        DonationView donationView = new DonationView();
        EventView eventView = new EventView();
        // Create the AdminView and set the SchoolView
        AdminView adminView = new AdminView(mockSchoolView, roomView, donationView, eventView);

        // Show the main menu for the Admin console
        adminView.showMainMenu();
    }
}

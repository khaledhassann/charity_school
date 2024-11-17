import java.util.Scanner;
import Room.RoomView;

public class AdminView {
    private SchoolView schoolView;
    private RoomView roomView;
    private EventView eventView;
    private DonationView donationView;
    // private ObserverView observerView;
    private Scanner scanner;

    public AdminView(SchoolView schoolView, RoomView roomView, DonationView donationView, EventView eventView) {
        scanner = new Scanner(System.in);
        this.schoolView = schoolView;
        this.roomView = roomView;
        this.donationView = donationView;
        this.eventView = eventView;
    }

    public void showMainMenu() {
        int choice;
        do {
            System.out.println("\nWelcome to the Admin console!");
            System.out.println("1. Manage Subjects");
            System.out.println("2. Manage Events");
            System.out.println("3. Manage Ads");
            System.out.println("4. Manage Rooms");
            System.out.println("0. Back to main menu");

            System.out.print("Your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    schoolView.showMenu();
                    break;

                case 2:
                    eventView.showAdminOptions();
                    break;

                case 3:
                    donationView.Adview();
                    break;

                case 4:
                    roomView.showMenu();
                    break;

                case 0:
                    System.out.println("Returning to main menu...");
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 0);
    }

}
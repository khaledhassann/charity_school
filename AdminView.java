import java.util.Scanner;

public class AdminView {
    private SchoolView schoolView;
    // private EventView eventView;
    // private CharityDonationSystem charityDonationSystem;
    // private ObserverView observerView;
    private Scanner scanner;

    public AdminView(SchoolView schoolView) {
        scanner = new Scanner(System.in);
        this.schoolView = schoolView;
    }

    public void showMainMenu() {
        int choice;
        do {
            System.out.println("\nWelcome to the Admin console!");
            System.out.println("1. Manage Subjects");
            System.out.println("2. Manage Events");
            System.out.println("3. Manage Ads");
            System.out.println("4. Manage Observers");
            System.out.println("0. Back to main menu");

            System.out.print("Your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    schoolView.showMenu();
                    break;

                case 2:
                    // eventView.showAdminOptions();
                    break;

                case 3:
                    // charityDonationSystem.chooseSocialMediaPlatform();
                    break;

                case 4:
                    // observerView.showManageObserversView();
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
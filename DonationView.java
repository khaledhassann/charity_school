import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DonationView {

    private static Scanner scanner = new Scanner(System.in);
    private static DonationTracker donationTracker = new DonationTracker();
    private static List<User> users = new ArrayList<>();
    private static List<Observer> observers = new ArrayList<>();
    private static SocialMediaContext socialMediaContext = new SocialMediaContext();
    static List<String> adsList = new ArrayList<>();

    private static void displayAllAds() {
        if (adsList.isEmpty()) {
            System.out.println(Colors.YELLOW + "No ads have been created yet." + Colors.RESET);
        } else {
            System.out.println(Colors.CYAN + "Displaying All Ads:" + Colors.RESET);
            for (String ad : adsList) {
                System.out.println(ad);
            }
        }
    }

    public void Adview() {
        // Create the system with initial users
        users.add(new AdminModel("9978", "khaledASU", "khaled@email.com", "0100200300", null, false));
        users.add(new AdminModel("9978", "khaledASU", "khaled@email.com", "0100200300", null, false));
        observers.add(config.EXAMPLE_DONOR);
        observers.add(config.EXAMPLE_DONOR);

        // Add observers to donation tracker
        for (Observer observer : observers) {
            donationTracker.addObserver(observer);
        }

        while (true) {
            System.out.println("\nWelcome to the School Charity Donation System!");
            System.out.println("1. Choose Social Media Platform for Ad");
            System.out.println("2. Display All Ads");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    chooseSocialMediaPlatform();
                    break;
                case 2:
                    displayAllAds();
                    break;
                case 3:
                    System.out.println(Colors.RED + "Exiting the system." + Colors.RESET);
                    return;
                default:
                    System.out.println(Colors.YELLOW + "Invalid choice! Please try again." + Colors.RESET);
            }
        }
    }

    private static void donate() {
        System.out.print("Enter your donation amount: ");
        double amount = scanner.nextDouble();
        donationTracker.donate(amount);
    }

    private static void chooseSocialMediaPlatform() {
        System.out.println("Choose a social media platform to run your ad campaign: ");
        System.out.println("1. Twitter");
        System.out.println("2. Facebook");
        System.out.println("3. Instagram");

        int platformChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        switch (platformChoice) {
            case 1:
                socialMediaContext.setStrategy(new TwitterStrategy());
                break;
            case 2:
                socialMediaContext.setStrategy(new FacebookStrategy());
                break;
            case 3:
                socialMediaContext.setStrategy(new InstagramStrategy());
                break;
            default:
                System.out.println(Colors.RED + "Invalid choice!" + Colors.RESET);
                return;
        }

        System.out.print("Enter the content for your ad campaign: ");
        String content = scanner.nextLine();
        socialMediaContext.executeAdCampaign(content);

        socialMediaContext.executeUserInteraction(); // Example of user interaction after ad campaign
    }

}
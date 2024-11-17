package Screens;

import java.util.Scanner;
import Login.*;

public class loginScreen {
    public static void displayLoginScreen() {
        Scanner scanner = new Scanner(System.in);
        String choice;
        String tryAgain;
        LoginContext loginContext; // The login context
        boolean isAuthorized;

        do {
            isAuthorized = false;
            choice = "";
            tryAgain = "";
            System.out.println("\nPlease select your user type:");
            System.out.println("1. Admin");
            System.out.println("2. Donor");
            System.out.println("3. Student");
            System.out.println("4. Volunteer");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("\nAdmin login selected.\n");
                    while (!isAuthorized) {
                        loginContext = new LoginContext(new AdminLoginStrategy());
                        String[] credentiaLoginUtil = LoginUtil.requestCredentials();
                        isAuthorized = loginContext.executeLogin(credentiaLoginUtil[0], credentiaLoginUtil[1]);

                        if (!isAuthorized) { // If not authorized, give the option to retry
                            System.out.print("\nDo you want to try again? (Y/N): ");
                            tryAgain = scanner.nextLine().trim();
                            if (tryAgain.equalsIgnoreCase("N")) break; // Exit loop on "N"
                        }
                    }
                    break;

                case "2":
                    System.out.println("\nDonor login selected.\n");
                    while (!isAuthorized) {
                        loginContext = new LoginContext(new DonorLoginStrategy());
                        String[] credentiaLoginUtil = LoginUtil.requestCredentials();
                        isAuthorized = loginContext.executeLogin(credentiaLoginUtil[0], credentiaLoginUtil[1]);

                        if (!isAuthorized) { // If not authorized, give the option to retry
                            System.out.print("\nDo you want to try again? (Y/N): ");
                            tryAgain = scanner.nextLine().trim();
                            if (tryAgain.equalsIgnoreCase("N")) break; // Exit loop on "N"
                        }
                    }
                    break;

                case "3":
                    System.out.println("\nStudent login selected.\n");
                    while (!isAuthorized) {
                        loginContext = new LoginContext(new StudentLoginStrategy());
                        String[] credentiaLoginUtil = LoginUtil.requestCredentials();
                        isAuthorized = loginContext.executeLogin(credentiaLoginUtil[0], credentiaLoginUtil[1]);

                        if (!isAuthorized) { // If not authorized, give the option to retry
                            System.out.print("\nDo you want to try again? (Y/N): ");
                            tryAgain = scanner.nextLine().trim();
                            if (tryAgain.equalsIgnoreCase("N")) break; // Exit loop on "N"
                        }
                    }
                    break;

                case "4":
                    System.out.println("Volunteer login selected.");
                    while (!isAuthorized) {
                        loginContext = new LoginContext(new VolunteerLoginStrategy());
                        String[] credentiaLoginUtil = LoginUtil.requestCredentials();
                        isAuthorized = loginContext.executeLogin(credentiaLoginUtil[0], credentiaLoginUtil[1]);

                        if (!isAuthorized) { // If not authorized, give the option to retry
                            System.out.print("\nDo you want to try again? (Y/N): ");
                            tryAgain = scanner.nextLine().trim();
                            if (tryAgain.equalsIgnoreCase("N")) break; // Exit loop on "N"
                        }
                    }
                    break;
                case "5":
                    System.out.println("Exiting....Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (!choice.equals("5"));

        scanner.close();
    }
}

package Screens;

import java.util.Scanner;

import Login.*;

public class loginScreen {
    public static void displayLoginScreen() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        LoginContext loginContext; // The login context
        boolean isAuthorized = false;
        do{
            System.out.println("\nPlease select your user type:");
            System.out.println("1. Admin");
            System.out.println("2. Donor");
            System.out.println("3. Student");
            System.out.println("4. Volunteer");
            System.out.println("5. Exit");
    
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
  
            switch (choice) {
                case 1:
                    System.out.println("\nAdmin login selected.\n");
                    // Call admin-specific methods or controllers
                    while(!isAuthorized){
                        loginContext = new LoginContext(new AdminLoginStrategy()); 
                        String[] credentiaLoginUtil = LoginUtil.requestCredentials();
                        isAuthorized = loginContext.executeLogin(credentiaLoginUtil[0], credentiaLoginUtil[1]);
                    
                        if (!isAuthorized){ // If not authorized, give the option to exit
                            System.out.print("\nDo you want to exit (Type 1 to exit)?\n");
                            int exit = scanner.nextInt();
                            if(exit == 1) displayLoginScreen();
                        }
                    }
                    break;
                case 2:
                    System.out.println("\nDonor login selected.\n");
                    // Call teacher-specific methods or controllers
                    while(!isAuthorized){
                        loginContext = new LoginContext(new DonorLoginStrategy());
                        String[] credentiaLoginUtil = LoginUtil.requestCredentials();
                        isAuthorized = loginContext.executeLogin(credentiaLoginUtil[0], credentiaLoginUtil[1]);
                    
                        if (!isAuthorized){ // If not authorized, give the option to exit
                            System.out.print("\nDo you want to exit (Type 1 to exit)?\n");
                            int exit = scanner.nextInt();
                            if(exit == 1) displayLoginScreen();
                        }
                    }
                    break;

                case 3:
                    System.out.println("\nStudent login selected.\n");
                    // Call login function with studentLogin strategy
                    while(!isAuthorized){
                        loginContext = new LoginContext(new StudentLoginStrategy());
                        String[] credentiaLoginUtil = LoginUtil.requestCredentials();
                        isAuthorized = loginContext.executeLogin(credentiaLoginUtil[0], credentiaLoginUtil[1]);
                    
                        if (!isAuthorized){ // If not authorized, give the option to exit
                            System.out.print("\nDo you want to exit (Type 1 to exit)?\n");
                            int exit = scanner.nextInt();
                            if(exit == 1) displayLoginScreen();
                        }
                    }

                    break;
                case 4:
                    System.out.println("Volunteer login selected.");
                    // Call volunteer-specific methods or controllers
                    while(!isAuthorized){
                        loginContext = new LoginContext(new VolunteerLoginStrategy());
                        String[] credentiaLoginUtil = LoginUtil.requestCredentials();
                        isAuthorized = loginContext.executeLogin(credentiaLoginUtil[0], credentiaLoginUtil[1]);
                    
                        if (!isAuthorized){ // If not authorized, give the option to exit
                            System.out.print("\nDo you want to exit (Type 1 to exit)?\n");
                            int exit = scanner.nextInt();
                            if(exit == 1) displayLoginScreen();
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting the application. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    displayLoginScreen(); // Recursive call for invalid input
            }
        }while(true);

 

        scanner.close();
    }
}

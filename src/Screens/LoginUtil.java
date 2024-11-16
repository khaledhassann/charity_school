package Screens;

import java.util.Scanner;

public class LoginUtil {

    public static String[] requestCredentials() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nLogin Screen\n");

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        return new String[]{username, password}; // Return credentials as an array
    }
}


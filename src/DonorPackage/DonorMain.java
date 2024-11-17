package DonorPackage;


// import java.util.ArrayList;
// import java.util.List;
// import java.util.Scanner;

// public class Main {
//     public static void main(String[] args) {
//     //     List<Subject> subjects = new ArrayList<>();
//     //     subjects.add(new Subject("Math", 1));
//     //     subjects.add(new Subject("Science", 2));
//     //     subjects.add(new Subject("History", 3));

//     //     School school1 = new School(subjects,"school1");


//     //     // Testing Monetary Donor
//     //     System.out.println("Monetary Donor Test:");
//     //     MonetaryDonor monetaryDonor = new MonetaryDonor("John Doe", "john@example.com",new MoneyDonation(100.0, "Credit Card"), school1);
//     //     monetaryDonor.donate(); 
//     //     Donor.addDonor(monetaryDonor);

//     //     System.out.println("\nTeacher Donor Test:");
//     //     // Testing Teacher Donor
//     //     TeacherDonor teacherDonor = new TeacherDonor("Jane Smith", "jane@example.com",school1);
//     //     teacherDonor.viewAvailableSubjects();
//     //     teacherDonor.addSubject(subjects.get(0));
//     //     teacherDonor.addSubject(subjects.get(1));
//     //     List<Subject> selectedSubjects = teacherDonor.getSelectedSubjects();
        
//     //     teacherDonor.setDonationStrategy(new TeachingDonation(selectedSubjects));
//     //     teacherDonor.donate(); 
//     //     teacherDonor.viewSchedule(); 

        
//     //     Donor.addDonor(teacherDonor);

//     //     System.out.println("\nList of all donors:");
//     //     for (Donor donor : Donor.getAllDonors()) {
//     //         System.out.println(donor.getDetails());
//     //     }
//             List<Subject> subjects = new ArrayList<>();
//         subjects.add(new Subject("Math", 1));
//         subjects.add(new Subject("Science", 2));
//         subjects.add(new Subject("History", 3));

//         School school = new School(subjects,"school1");
//     Donor donor = new MonetaryDonor("donor@example.com", "John Doe", school);
//      DonationScreen donorView = new DonationScreen();
//      DonationController donorController = new DonationController(donor, donorView,school);
//      Scanner scanner = new Scanner(System.in);
//      boolean isRunning = true;

//         while(isRunning){
//             System.out.println("Welcome to the Donation Management System");
//             System.out.println("Welcome to the Donation Management System");
//             System.out.println("1. Create Account");
//             System.out.println("2. Login");
//             System.out.println("3. Exit");
//             System.out.print("Choose an option: ");
//             int choice = scanner.nextInt();
//             switch (choice) {
//                 case 1 -> {
//                     System.out.println("Choose Account Type:");
//                     System.out.println("1. Teacher Donor");
//                     System.out.println("2. Monetary Donor");
//                     System.out.print("Enter your choice: ");
//                     int accountType = scanner.nextInt();
//                     scanner.nextLine(); 

//                     System.out.print("Enter Name: ");
//                     String name = scanner.nextLine();
//                     System.out.print("Enter Email: ");
//                     String email = scanner.nextLine();

//                     if (accountType == 1) {
//                         donorController.createTeacherDonor(name, email);
//                         System.out.println("Teacher Donor Account Created Successfully!");
//                     } else if (accountType == 2) {
//                         donorController.createMonetaryDonor(name, email);
//                         System.out.println("Monetary Donor Account Created Successfully!");
//                     } else {
//                         System.out.println("Invalid choice. Try again.");
//                         continue;
//                     }
//                     donorView.displayDonorMainMenu();
//                     choice = scanner.nextInt();
//                     scanner.nextLine(); 
//                     do{
//                         switch (choice) {
//                             case 1:
//                                 donorController.login();
//                                 break;
//                             case 2:
//                                 donorController.viewProfile();
//                                 break;
//                             case 3:
//                                 donorController.makeDonation();
//                                 break;
//                             case 4:
//                                 donorController.viewHistory();
//                                 break;
//                             case 5:
//                                 System.out.println("Exiting... Thank you for your contributions!");
//                                 break;
//                             default:
//                                 System.out.println("Invalid choice. Please try again.");
//                         }
//                     } while (choice != 5);

//                     scanner.close();
//                 }
//                 case 2 -> {
//                     System.out.println("Login Successful.");
//                     donorView.displayDonorMainMenu();
//                     choice = scanner.nextInt();
//                     scanner.nextLine(); 
//                     do{
//                         switch (choice) {
//                             case 1:
//                                 donorController.login();
//                                 break;
//                             case 2:
//                                 donorController.viewProfile();
//                                 break;
//                             case 3:
//                                 donorController.makeDonation();
//                                 break;
//                             case 4:
//                                 donorController.viewHistory();
//                                 break;
//                             case 5:
//                                 System.out.println("Exiting... Thank you for your contributions!");
//                                 break;
//                             default:
//                                 System.out.println("Invalid choice. Please try again.");
//                         }
//                     } while (choice != 5);

//                     scanner.close();
//         }
                
//                 case 3 -> {
//                     System.out.println("Thank you for using the system. Goodbye!");
//                     isRunning = false;
//                 }
//                 default -> System.out.println("Invalid choice. Please try again.");
//             }
//     }


// }}
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DonorMain {
    public void showMenu(Donor donor, School school) {    
        // Takes in donorController that is initialized with 
        // the appropriate DonationScreen and School objects
        // Use .createTeacherDonor() and .createMonetaryDonor()
        // Donor donor = null; // Start with no donor
        DonationScreen donorView = new DonationScreen();

        DonationController donorController = new DonationController(donor, donorView, school);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Login Successful.");

        showMenuHelper(scanner, donorController, donorView);

        // scanner.close();
    }

    private static void showMenuHelper(Scanner scanner, DonationController donorController, DonationScreen donorView) {
        int choice;
        do {
            donorView.displayDonorMainMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1 -> donorController.viewProfile();
                case 2 -> donorController.makeDonation();
                case 3 -> donorController.viewHistory();
                case 4 -> System.out.println("Exiting... Thank you for your contributions!");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }
}

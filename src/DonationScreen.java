// import java.util.List;
// import java.util.Scanner;

// public class DonationScreen {

//     // Display details of a donor
//     public void displayDonorDetails(Donor donor) {
//         if (donor == null) {
//             System.out.println("Donor not found.");
//             return;
//         }

//         System.out.println("------ Donor Details ------");
//         System.out.println("Name: " + donor.getName());
//         System.out.println("Contact Info: " + donor.getContactInfo());
//         System.out.println("School: " + (donor.school != null ? donor.school.getName() : "N/A"));
//         System.out.println("Has Donated: " + (donor.didDonate ? "Yes" : "No"));
//         System.out.println("---------------------------");
//     }

//     // Display donation history
//     public void displayDonationHistory(List<DonationDetails> donationHistory) {
//         if (donationHistory == null || donationHistory.isEmpty()) {
//             System.out.println("No donation history available.");
//             return;
//         }

//         System.out.println("------ Donation History ------");
//         for (DonationDetails details : donationHistory) {
//             System.out.println("Donation ID: " + details.getDonationId());
//             System.out.println("Amount: " + (details.getAmount() != null ? details.getAmount() : "N/A"));
//             System.out.println("Payment Method: " + (details.getPaymentMethod() != null ? details.getPaymentMethod() : "N/A"));
//             System.out.println("Subjects Donated: " + (details.getSubjects() != null ? details.getSubjects() : "N/A"));
//             System.out.println("Date: " + details.getDate());
//             System.out.println("School: " + details.getSchoolName());
//             System.out.println("-----------------------------");
//         }
//     }

//     // Display menu for donor operations
//     public void displayMenu(DonationController donorController) {
//         Scanner scanner = new Scanner(System.in);
//         int choice;

//         do {
//             System.out.println("\n--- Donor Menu ---");
//             System.out.println("1. Login");
//             System.out.println("1. View Donor Details");
//             System.out.println("1. View Donor Details");
//             System.out.println("2. View Donation History");
//             System.out.println("3. Make a Donation");
//             System.out.println("4. Exit");

//             System.out.print("Enter your choice: ");
//             choice = scanner.nextInt();
//             scanner.nextLine(); // Consume newline

//             switch (choice) {
//                 case 1:
//                     System.out.print("Enter Donor Name: ");
//                     String name = scanner.nextLine();
//                     donorController.viewDonorDetails(name);
//                     break;
//                 case 2:
//                     donorController.viewDonationHistory();
//                     break;
//                 case 3:
//                     donorController.makeDonation();
//                     break;
//                 case 4:
//                     System.out.println("Exiting donor menu.");
//                     break;
//                 default:
//                     System.out.println("Invalid choice. Try again.");
//             }
//         } while (choice != 4);
//     }
// }
import java.util.List;

public class DonationScreen {

    public void displayDonorMainMenu(){
        System.out.println("\n--- Main Menu ---");
            System.out.println("1. Login");
            System.out.println("2. View Profile");
            System.out.println("3. Make Donation");
            System.out.println("4. View Donation History");
            System.out.println("5. Exit");
    }
    public void displayDonorProfile(Donor donor) {
        System.out.println("\n--- Donor Profile ---");
        System.out.println("Name: " + donor.getName());
        System.out.println("Contact Info: " + donor.getContactInfo());
    }

    public void displayDonationHistory(List<DonationDetails> donationHistory) {
        System.out.println("--- Donation History ---");
        for (DonationDetails donation : donationHistory) {
            System.out.println("Donation ID: " + donation.getDonationID());
            System.out.println("Date: " + donation.getDate());
            System.out.println("School: " + donation.getSchool());

            if (donation.getDonationAmount() != null) {
                System.out.println("Donation Amount: $" + donation.getDonationAmount());
                System.out.println("Payment Strategy: " + donation.getPaymentStrategy());
            } else if (donation.getSelectedSubjects() != null) {
                System.out.println("Teaching Subjects: " + donation.getSelectedSubjects());
            }
            System.out.println("------------------------");
        }
    }
}

package DonorPackage;
import java.util.Scanner;

public class DonationController {
    private Donor donor;
    private DonationScreen donorView;
    private School school;
    private Scanner scanner = new Scanner(System.in); // Class-level scanner

    public DonationController(Donor donor, DonationScreen donorView, School school) {
        this.donor = donor;
        this.donorView = donorView;
        this.school = school;
    }

    public void createTeacherDonor(String name, String email) {
        donor = new TeacherDonor(name, email, school);
    }

    public void createMonetaryDonor(String name, String email) {
        donor = new MonetaryDonor(name, email, school);
    }

    public void viewProfile() {
        donorView.displayDonorProfile(donor);
    }

    public void makeDonation() {
        System.out.println("Select Donation Type:");
        System.out.println("1. Money Donation");
        // Allow teaching donation only for TeacherDonor
        if (donor instanceof TeacherDonor) {
            System.out.println("2. Teaching Donation");
        }
        System.out.println("3. Back to Main Menu");
    
        int choice = scanner.nextInt();
        scanner.nextLine();
    
        switch (choice) {
            case 1: // Money Donation
                System.out.print("Enter amount to donate: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Enter payment method: ");
                String paymentMethod = scanner.nextLine();
                System.out.print("Would you like to proceed with payment? Y/N: ");
                String proceed = scanner.nextLine();
                if (proceed.equalsIgnoreCase("Y")) {
                    MoneyDonation moneyDonation = new MoneyDonation(amount, paymentMethod);
                    donor.setDonationStrategy(moneyDonation);
                    if (donor.donate()) {
                        System.out.println("Money donation successful.");
                    }
                } else {
                    donorView.displayDonorMainMenu();
                }
                break;
    
            case 2: // Teaching Donation (only for TeacherDonor)
                if (donor instanceof TeacherDonor) {
                    TeacherDonor teacherDonor = (TeacherDonor) donor;
                    teacherDonor.viewAvailableSubjects();
    
                    System.out.println("Enter subjects to teach (comma-separated): ");
                    String[] subjectNames = scanner.nextLine().split(",");
                    for (String subjectName : subjectNames) {
                        Subject subject = teacherDonor.school.getSubjectByName(subjectName.trim());
                        if (subject != null) {
                            teacherDonor.addSubject(subject);
                        } else {
                            System.out.println("Subject " + subjectName + " not found.");
                        }
                    }
    
                    TeachingDonation teachingDonation = new TeachingDonation(teacherDonor.getSelectedSubjects());
                    donor.setDonationStrategy(teachingDonation);
                    if (donor.donate()) {
                        System.out.println("Teaching donation successful.");
                        teacherDonor.viewSchedule();
                    }
                } else {
                    System.out.println("Teaching donation is not available for this donor.");
                }
                break;
            case 3:
                donorView.displayDonorMainMenu();
                return;

            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    public void viewHistory() {
        donorView.displayDonationHistory(donor.getDonationHistory());
        System.out.print("Back to main menu? Y/N: ");
        String back = scanner.nextLine();
        if (back.equalsIgnoreCase("Y")) {
            donorView.displayDonorMainMenu();
        }
    }

    public boolean addDonor(Donor donor) {
        Donor.addDonor(donor);
        return true;
    }

    public boolean deleteDonor(Donor donor) {
        if (Donor.getAllDonors().contains(donor)) {
            Donor.deleteDonor(donor);
            return true;
        } else {
            return false;
        }
    }

    public int getTotalDonations(Donor donor) {
        return donor.getDonationHistory().size();
    }
}

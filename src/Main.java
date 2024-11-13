import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Initialize the school and schedule for teaching donations
        School school = new School();
        Schedule schedule = new Schedule();
        

        // Create some subjects for teaching
        List<Subject> subjects = new ArrayList<>();
        subjects.add(new Subject("Math", 10));
        subjects.add(new Subject("Science", 12));
        subjects.add(new Subject("History", 14));

        // Add subjects to the school
        school.addSubjects(subjects);

        // Testing Monetary Donor
        System.out.println("Monetary Donor Test:");
        MonetaryDonor monetaryDonor = new MonetaryDonor("John Doe", "john@example.com");
        IDonationStrategy moneyDonation = new MoneyDonation(100.0, "Credit Card");
        monetaryDonor.setDonationStrategy(moneyDonation);
        
        monetaryDonor.donate(); // This should print details of the monetary donation

        // Add donor to the list
        Donor.addDonor(monetaryDonor);

        System.out.println("\nTeacher Donor Test:");
        // Testing Teacher Donor
        TeacherDonor teacherDonor = new TeacherDonor("Jane Smith", "jane@example.com");
        List<Subject> selectedSubjects = new ArrayList<>();
        selectedSubjects.add(subjects.get(0)); // Math
        selectedSubjects.add(subjects.get(1)); // Science
        IDonationStrategy teachingDonation = new TeachingDonation(schedule, selectedSubjects);
        teacherDonor.setDonationStrategy(teachingDonation);

        // Teacher views available subjects in the school
        teacherDonor.viewAvailableSubjects(school);
        
        // Teacher makes a teaching donation and views the schedule
        teacherDonor.donate(); // This should print the created teaching donation schedule
        teacherDonor.viewSchedule(); // This should print the scheduled subjects for teaching

        // Add teacher donor to the list
        Donor.addDonor(teacherDonor);

        // Print all donors
        System.out.println("\nList of all donors:");
        for (Donor donor : Donor.getAllDonors()) {
            System.out.println(donor.getDetails());
        }
    }
}

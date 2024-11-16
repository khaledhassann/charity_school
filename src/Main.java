import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Subject> subjects = new ArrayList<>();
        subjects.add(new Subject("Math", 1));
        subjects.add(new Subject("Science", 2));
        subjects.add(new Subject("History", 3));

        School school1 = new School(subjects,"school1");


        // Testing Monetary Donor
        System.out.println("Monetary Donor Test:");
        MonetaryDonor monetaryDonor = new MonetaryDonor("John Doe", "john@example.com",new MoneyDonation(100.0, "Credit Card"), school1);
        monetaryDonor.donate(); 
        Donor.addDonor(monetaryDonor);

        System.out.println("\nTeacher Donor Test:");
        // Testing Teacher Donor
        TeacherDonor teacherDonor = new TeacherDonor("Jane Smith", "jane@example.com",school1);
        teacherDonor.viewAvailableSubjects();
        teacherDonor.addSubject(subjects.get(0));
        teacherDonor.addSubject(subjects.get(1));
        List<Subject> selectedSubjects = teacherDonor.getSelectedSubjects();
        
        teacherDonor.setDonationStrategy(new TeachingDonation(selectedSubjects));
        teacherDonor.donate(); 
        teacherDonor.viewSchedule(); 

        
        Donor.addDonor(teacherDonor);

        System.out.println("\nList of all donors:");
        for (Donor donor : Donor.getAllDonors()) {
            System.out.println(donor.getDetails());
        }
    }
}

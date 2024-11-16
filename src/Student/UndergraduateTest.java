package Student;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UndergraduateTest {
    public static void main(String[] args) {
        // Create an instance of UndergraduateStudent using StudentConfig for default values
        UndergraduateStudent student = new UndergraduateStudent(
                null, // userID (will use default from StudentConfig)
                null, // name (will use default from StudentConfig)
                null, // contactInfo (will use default from StudentConfig)
                null, // email (will use default from StudentConfig)
                null, // phone (will use default from StudentConfig)
                null, // address (will use default from StudentConfig)
                StudentConfig.DEFAULT_BENEFICIARY_STATUS,
                null, // dateOfBirth (will use default from StudentConfig)
                null, // nationality (will use default from StudentConfig)
                null, // major (will use default from StudentConfig)
                null, // enrollmentYear (will use default from StudentConfig)
                new ArrayList<>(StudentConfig.DEFAULT_DONORS), // donors (from StudentConfig)
                new ArrayList<>(StudentConfig.DEFAULT_SUBJECTS), // subjects (from StudentConfig)
                StudentConfig.DEFAULT_YEAR, // default year
                StudentConfig.DEFAULT_GPA, // default GPA
                StudentConfig.DEFAULT_INTERNSHIP_STATUS // default internship status
        );

        // Display initial student information
        System.out.println("Student Name: " + student.getName());
        System.out.println("Student ID: " + student.getUserID());
        System.out.println("Major: " + student.getMajor());
        System.out.println("Nationality: " + student.getNationality());
        System.out.println("Year: " + student.getYear());
        System.out.println("GPA: " + student.getGpa());
        System.out.println("Internship Status: " + student.getInternshipStatus());

        // Test checkGPA method
        student.checkGPA();

        // Test applyForScholarship method
        student.applyForScholarship();

        // Test applyForInternship method
        student.applyForInternship();

        // Update GPA and test applyForScholarship again
        System.out.println("\n--- Updating GPA and Reapplying for Scholarship ---");
        student.setGpa(3.6f);
        student.checkGPA();
        student.applyForScholarship();

        // Update internship status and test applyForInternship again
        System.out.println("\n--- Updating Internship Status and Reapplying for Internship ---");
        student.setInternshipStatus("Completed");
        student.applyForInternship();
    }
}

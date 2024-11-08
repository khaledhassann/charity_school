import java.util.Date;

public class StudentTest {
    public static void main(String[] args) {
        // Create a Student instance using the defaults from StudentConfig
        Student student = new Student(
                StudentConfig.DEFAULT_USER_ID,
                StudentConfig.DEFAULT_NAME,
                StudentConfig.DEFAULT_CONTACT_INFO,
                StudentConfig.DEFAULT_EMAIL,
                StudentConfig.DEFAULT_PHONE,
                StudentConfig.DEFAULT_ADDRESS,
                StudentConfig.DEFAULT_BENEFICIARY_STATUS,
                StudentConfig.DEFAULT_DATE_OF_BIRTH,
                StudentConfig.DEFAULT_NATIONALITY,
                StudentConfig.DEFAULT_MAJOR,
                StudentConfig.DEFAULT_ENROLLMENT_YEAR,
                StudentConfig.DEFAULT_DONORS,
                StudentConfig.DEFAULT_SUBJECTS
        );

        // Test by printing the student details
        System.out.println("Student Details:");
        System.out.println("User ID: " + student.getUserID());
        System.out.println("Name: " + student.getName());
        System.out.println("Contact Info: " + student.getContactInfo());
        System.out.println("Email: " + student.getEmail());
        System.out.println("Phone: " + student.getPhone());
        System.out.println("Address: " + student.getAddress());
        System.out.println("Beneficiary Status: " + (student.isBeneficiaryStatus() ? "Yes" : "No"));
        System.out.println("Date of Birth: " + student.getDateOfBirth());
        System.out.println("Nationality: " + student.getNationality());
        System.out.println("Major: " + student.getMajor());
        System.out.println("Enrollment Year: " + student.getEnrollmentYear());

        System.out.println("Donors:");
        for (Donor donor : student.getDonors()) {
            System.out.println(" - " + donor.getName() + " (" + donor.getEmail() + ")");
        }

        System.out.println("Subjects:");
        for (Subject subject : student.getSubjects()) {
            System.out.println(" - " + subject.getName() + " (" + subject.getCode() + ")");
        }

        // Additional actions can be tested here if needed
        student.register();

    }
}

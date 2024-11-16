package Student;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class UndergraduateStudent extends Student {
    private int year;
    private float gpa;
    private String internshipStatus;

    // Constructor
    public UndergraduateStudent(String userID, String name, String contactInfo, String email,
                                String phone, String address, boolean beneficiaryStatus,
                                String dateOfBirth, String nationality, String major, Date enrollmentYear,
                                List<Donor> donors, List<Subject> subjects,
                                int year, float gpa, String internshipStatus) {
        super(
                userID != null ? userID : StudentConfig.DEFAULT_USER_ID,
                name != null ? name : StudentConfig.DEFAULT_NAME,
                contactInfo != null ? contactInfo : StudentConfig.DEFAULT_CONTACT_INFO,
                email != null ? email : StudentConfig.DEFAULT_EMAIL,
                phone != null ? phone : StudentConfig.DEFAULT_PHONE,
                address != null ? address : StudentConfig.DEFAULT_ADDRESS,
                beneficiaryStatus,
                dateOfBirth  != null ? dateOfBirth : StudentConfig.DEFAULT_DATE_OF_BIRTH,
                nationality  != null ? nationality : StudentConfig.DEFAULT_NATIONALITY,
                major != null ? major : StudentConfig.DEFAULT_MAJOR,
                enrollmentYear  != null ? enrollmentYear : StudentConfig.DEFAULT_ENROLLMENT_YEAR,
                (donors != null && !donors.isEmpty()) ? donors : StudentConfig.DEFAULT_DONORS,
                (subjects != null && !subjects.isEmpty()) ? subjects : StudentConfig.DEFAULT_SUBJECTS

        );

        this.year = year > 0 ? year : StudentConfig.DEFAULT_YEAR;
        this.gpa = gpa > 0 ? gpa : StudentConfig.DEFAULT_GPA;
        this.internshipStatus = internshipStatus != null ? internshipStatus : StudentConfig.DEFAULT_INTERNSHIP_STATUS;
    }


    public void applyForInternship() {
        // Check if the student already has an internship status
        if ("Completed".equalsIgnoreCase(internshipStatus)) {
            System.out.println(getName() + " has already completed an internship. No further applications are needed.");
            return;
        } else if ("In Progress".equalsIgnoreCase(internshipStatus)) {
            System.out.println(getName() + " is already undertaking an internship. Cannot apply for a new one.");
            return;
        } else if ("Pending Approval".equalsIgnoreCase(internshipStatus)) {
            System.out.println(getName() + "'s application is already under review. Please wait for the decision.");
            return;
        }

        // Validate GPA for eligibility (assuming a minimum requirement of 2.5)
        if (getGpa() < 2.5) {
            System.out.println(getName() + " is not eligible to apply for an internship due to a GPA below the minimum requirement (2.5).");
            return;
        }

        internshipStatus = "Pending Approval";
        System.out.println(getName() + " has successfully applied for an internship. Current status: " + internshipStatus);
    }


    public void checkGPA() {
        System.out.println("The GPA of " + name + " is " + gpa);
    }

    public void applyForScholarship() {
        if (gpa >= 3.5) {
            System.out.println(name + " has applied for a scholarship.");
        } else {
            System.out.println(name + " does not meet the GPA requirement for a scholarship.");
        }
    }

    // Getters and Setters
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public String getInternshipStatus() {
        return internshipStatus;
    }

    public void setInternshipStatus(String internshipStatus) {
        this.internshipStatus = internshipStatus;
    }
}

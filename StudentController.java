import java.util.Date;
import java.util.List;

public class StudentController {
    private Student student;
    private List<Aid> availableAids;
    private List<Student> students;

    public StudentController(List<Student> students) {
        this.students = students;
    }

    public void registerStudent() {
        student.register();
    }
    public void viewStudentProfile(String studentID) {
        // Search for the student with the given ID
        Student student = findStudentByID(studentID);

        if (student == null) {
            System.out.println("Student with ID " + studentID + " not found.");
            return;
        }
        System.out.println("------ Student Profile ------");
        System.out.println("ID: " + student.getUserID());
        System.out.println("Name: " + student.getName());
        System.out.println("Email: " + student.getEmail());
        System.out.println("Phone: " + student.getPhone());
        System.out.println("Address: " + student.getAddress());
        System.out.println("Date of Birth: " + student.getDateOfBirth());
        System.out.println("Nationality: " + student.getNationality());
        System.out.println("Major: " + student.getMajor());
        System.out.println("Enrollment Year: " + student.getEnrollmentYear());
        System.out.println("Beneficiary Status: " + (student.isBeneficiaryStatus() ? "Yes" : "No"));
        System.out.println("------ End of Profile ------");
    }
    private Student findStudentByID(String studentID) {
        for (Student student : students) {
            if (student.getUserID().equals(studentID)) {
                return student;
            }
        }
        return null;
    }
    public void updateStudentProfile(String name, String email, String phone, String address) {
        // Update each field using the setters in the User (parent) class
        student.setName(name);
        student.setEmail(email);
        student.setPhone(phone);
        student.setAddress(address);

        // Confirm the profile update
        System.out.println("Profile updated for " + student.getName());
    }
    public void addSubject(Subject subject) {
        student.getSubjects().add(subject);
        System.out.println("Subject " + subject.getName() + " added for " + student.getName());
    }
    public void applyForAid() {
        System.out.println("Available Aid Options:");

        // Display all available aids
        for (int i = 0; i < availableAids.size(); i++) {
            Aid aid = availableAids.get(i);
            if (aid.isAvailable()) {
                System.out.println((i + 1) + ". " + aid.getAidName() + " - " + aid.getDescription());
            }
        }

        // Simulate aid application process
        if (!availableAids.isEmpty()) {
            Aid aidToApply = availableAids.get(0); // Applying for the first available aid as an example
            if (aidToApply.isAvailable()) {
                System.out.println("Applying for " + aidToApply.getAidName() + "...");
                aidToApply.setAvailable(false); // Mark as applied
                System.out.println("Aid application submitted for " + student.getName() + " for " + aidToApply.getAidName());
            } else {
                System.out.println("No available aid to apply for.");
            }
        }
    }
}
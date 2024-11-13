import java.util.List;
import java.util.Map;

public class StudentView {

    public void displayStudentProfile(Student student) {
        if (student == null) {
            System.out.println("Student not found.");
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

    public void displayAidOptions(List<Aid> availableAids) {
        if (availableAids == null || availableAids.isEmpty()) {
            System.out.println("No available aid options.");
            return;
        }

        System.out.println("Available Aid Options:");
        for (int i = 0; i < availableAids.size(); i++) {
            Aid aid = availableAids.get(i);
            if (aid.isAvailable()) {
                System.out.println((i + 1) + ". " + aid.getAidName() + " - " + aid.getDescription());
            }
        }
    }

    public void displaySubjects(List<Subject> subjects) {
        if (subjects == null || subjects.isEmpty()) {
            System.out.println("No subjects to display.");
            return;
        }

        System.out.println("------ List of Subjects ------");
        for (Subject subject : subjects) {
            System.out.println("Name: " + subject.getName());
            System.out.println("Code: " + subject.getCode());
            System.out.println("-----------------------------");
        }
    }

    public void displaySchedule(Map<String, Integer> schedule) {
        if (schedule == null || schedule.isEmpty()) {
            System.out.println("No schedule available.");
            return;
        }

        System.out.println("Student Schedule:");
        for (Map.Entry<String, Integer> entry : schedule.entrySet()) {
            System.out.println("Subject: " + entry.getKey() + ", Credit Hours: " + entry.getValue());
        }
    }

    public void displayProfileUpdateConfirmation(String studentName) {
        System.out.println("Profile updated for " + studentName);
    }

    public void displayAidApplicationStatus(String studentName, Aid aid) {
        if (aid.isAvailable()) {
            System.out.println("Applying for " + aid.getAidName() + "...");
            System.out.println("Aid application submitted for " + studentName + " for " + aid.getAidName());
        } else {
            System.out.println("No available aid to apply for.");
        }
    }
}

package Student;
import java.util.List;
import java.util.Map;

public class StudentView {

    // Display the profile of any student (including specific fields for undergraduate or graduate)
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

        // Check if the student is an UndergraduateStudent or GraduateStudent
        if (student instanceof UndergraduateStudent) {
            UndergraduateStudent undergrad = (UndergraduateStudent) student;
            System.out.println("Year: " + undergrad.getYear());
            System.out.println("GPA: " + undergrad.getGpa());
            System.out.println("Internship Status: " + undergrad.getInternshipStatus());
        } else if (student instanceof GraduateStudent) {
            GraduateStudent grad = (GraduateStudent) student;
            System.out.println("Thesis Topic: " + grad.getThesisTopic());
            System.out.println("Advisor: " + grad.getAdvisorName());
            System.out.println("GPA: " + grad.getGpa());
            //System.out.println("Research Aid Status: " + grad.getResearchAidStatus());
        }

        System.out.println("------ End of Profile ------");
    }

    // Display available aid options
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

    // Display a list of subjects
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

    // Display the student's schedule
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

    // Display confirmation after updating profile
    public void displayProfileUpdateConfirmation(String studentName) {
        System.out.println("Profile updated for " + studentName);
    }

    // Display aid application status
    public void displayAidApplicationStatus(String studentName, Aid aid) {
        if (aid.isAvailable()) {
            System.out.println("Applying for " + aid.getAidName() + "...");
            System.out.println("Aid application submitted for " + studentName + " for " + aid.getAidName());
        } else {
            System.out.println("No available aid to apply for.");
        }
    }

    // Display previously added subjects
    public void displayAddedSubjects(List<Subject> addedSubjects) {
        if (addedSubjects == null || addedSubjects.isEmpty()) {
            System.out.println("No subjects have been added previously.");
            return;
        }

        System.out.println("------ Previously Added Subjects ------");
        for (Subject subject : addedSubjects) {
            System.out.println("Name: " + subject.getName());
            System.out.println("Code: " + subject.getCode());
            System.out.println("---------------------------------------");
        }
    }

    // Display GPA check result for undergraduate students
    public void displayGpaCheckResult(UndergraduateStudent student) {
        System.out.println("The GPA of " + student.getName() + " is " + student.getGpa());
    }

    // Display internship application status for undergraduate students
    public void displayInternshipApplicationStatus(UndergraduateStudent student) {
        System.out.println(student.getName() + " has successfully applied for an internship. Current status: " + student.getInternshipStatus());
    }

    // Display scholarship application result for undergraduate students
    public void displayScholarshipApplicationStatus(UndergraduateStudent student) {
        if (student.getGpa() >= 3.5) {
            System.out.println(student.getName() + " has successfully applied for a scholarship.");
        } else {
            System.out.println(student.getName() + " does not meet the GPA requirement for a scholarship.");
        }
    }
}

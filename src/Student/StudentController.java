package Student;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentController {
    private UndergraduateStudent student;
    private List<Aid> availableAids;
    private List<UndergraduateStudent> students;
    private StudentView studentView;

    public StudentController(UndergraduateStudent student, List<UndergraduateStudent> students, StudentView studentView, List<Aid> availableAids) {
        this.student = student;  // Assigning a specific UndergraduateStudent instance to the controller
        this.students = students;
        this.studentView = studentView;
        this.availableAids = availableAids;
    }

    // Method to register the undergraduate student
    public void registerStudent() {
        if (student != null) {
            student.register();
            System.out.println("Student " + student.getName() + " has been registered successfully.");
        } else {
            System.out.println("No student to register.");
        }
    }

    // Method to view the undergraduate student's profile by their ID
    public void viewStudentProfile(String studentID) {
        // Search for the student with the given ID
        UndergraduateStudent foundStudent = findStudentByID(studentID);

        // Use StudentView to display the profile
        if (foundStudent != null) {
            studentView.displayStudentProfile(foundStudent);
        } else {
            System.out.println("Student with ID " + studentID + " not found.");
        }
    }

    // Helper method to find an undergraduate student by their ID
    private UndergraduateStudent findStudentByID(String studentID) {
        if (studentID == null || students == null) return null;

        for (UndergraduateStudent student : students) {
            if (studentID.equals(student.getUserID())) {
                return student;
            }
        }
        return null;
    }

    // Method to update the undergraduate student's profile with new details
    public void updateStudentProfile(String name, String email, String phone, String address) {
        if (student != null) {
            student.setName(name);
            student.setEmail(email);
            student.setPhone(phone);
            student.setAddress(address);

            // Confirm the profile update using the view
            studentView.displayProfileUpdateConfirmation(student.getName());
        } else {
            System.out.println("No student to update.");
        }
    }

    // Method to add a subject to the undergraduate student's list of subjects
    public void addSubject(Subject subject) {
        if (student == null) {
            System.out.println("No student is selected.");
            return;
        }

        List<Subject> currentSubjects = student.getSubjects();
        studentView.displayAddedSubjects(currentSubjects);

        if (subject == null) {
            System.out.println("Invalid subject.");
            return;
        }

        if (!currentSubjects.contains(subject)) {
            currentSubjects.add(subject);
            studentView.displaySubjects(currentSubjects); // Display updated subjects list
            System.out.println("Subject " + subject.getName() + " has been added for " + student.getName());
        } else {
            System.out.println("Subject " + subject.getName() + " is already added for " + student.getName());
        }
    }

    // Method to apply for aid
    public void applyForAid() {
        if (availableAids == null || availableAids.isEmpty()) {
            System.out.println("No aid options available.");
            return;
        }

        studentView.displayAidOptions(availableAids); // Display available aids

        // Simulate aid application process
        Aid aidToApply = availableAids.get(0); // Example: apply for the first available aid
        if (aidToApply.isAvailable()) {
            aidToApply.setAvailable(false); // Mark as applied
            studentView.displayAidApplicationStatus(student.getName(), aidToApply); // Display aid application status
        } else {
            System.out.println("No available aid to apply for.");
        }
    }

    // Method to create a schedule from a list of selected subjects
    public Map<String, Integer> createSchedule(List<Subject> selectedSubjects) {
        if (selectedSubjects == null || selectedSubjects.isEmpty()) {
            System.out.println("No subjects provided to create a schedule.");
            return new HashMap<>();
        }

        Map<String, Integer> scheduleMap = new HashMap<>();
        System.out.println("Creating schedule:");

        for (Subject subject : selectedSubjects) {
            Integer timeSlot = subject.getTimeSlot();
            String name = subject.getName();
            if (timeSlot != null) {
                scheduleMap.put(name, timeSlot);
                System.out.println("Subject: " + name + " - Time Slot: " + timeSlot);
            }
        }

        return scheduleMap;
    }

    // Method to display the schedule
    public void displaySchedule() {
        Map<String, Integer> schedule = createSchedule(student.getSubjects());
        studentView.displaySchedule(schedule);
    }

    // Specific method for undergraduate students to check GPA
    public void checkGPA() {
        if (student != null) {
            student.checkGPA();
        } else {
            System.out.println("No student to check GPA.");
        }
    }

    // Specific method for undergraduate students to apply for internship
    public void applyForInternship() {
        if (student != null) {
            student.applyForInternship();
        } else {
            System.out.println("No student to apply for internship.");
        }
    }

    // Specific method for undergraduate students to apply for scholarship
    public void applyForScholarship() {
        if (student != null) {
            student.applyForScholarship();
        } else {
            System.out.println("No student to apply for scholarship.");
        }
    }
}

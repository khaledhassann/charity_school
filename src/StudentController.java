import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentController {
    private Student student;
    private List<Student> students;
    private StudentView studentView;

    public StudentController(Student student, List<Student> students, StudentView studentView) {
        this.student = student; // Assigning a generic Student instance to the controller
        this.students = students;
        this.studentView = studentView;
    }

    // Method to register the student
    public void registerStudent() {
        if (student != null) {
            student.register();
            System.out.println("Student " + student.getName() + " has been registered successfully.");
        } else {
            System.out.println("No student to register.");
        }
    }

    // Method to view the student's profile by their ID
    public void viewStudentProfile(String studentID) {
        // Search for the student with the given ID
        Student foundStudent = findStudentByID(studentID);

        // Use StudentView to display the profile
        if (foundStudent != null) {
            studentView.displayStudentProfile(foundStudent);
        } else {
            System.out.println("Student with ID " + studentID + " not found.");
        }
    }

    // Helper method to find a student by their ID
    private Student findStudentByID(String studentID) {
        if (studentID == null || students == null)
            return null;

        for (Student student : students) {
            if (studentID.equals(student.getUserID())) {
                return student;
            }
        }
        return null;
    }

    // Method to update the student's profile with new details
    // public void updateStudentProfile(String name, String email, String phone,
    // String address) {
    // if (student != null) {
    // student.setName(name);
    // student.setEmail(email);
    // student.setPhone(phone);
    // student.setAddress(address);
    //
    // // Confirm the profile update using the view
    // studentView.displayProfileUpdateConfirmation(student.getName());
    // } else {
    // System.out.println("No student to update.");
    // }
    // }

    // Method to add a subject to the student's list of subjects
    public void addSubject(SubjectModel subject) {
        if (student == null) {
            System.out.println("No student is selected.");
            return;
        }

        List<SubjectModel> currentSubjects = student.getSubjects();
        studentView.displayAddedSubjects(currentSubjects);

        if (subject == null) {
            System.out.println("Invalid subject.");
            return;
        }

        if (!currentSubjects.contains(subject)) {
            currentSubjects.add(subject);
            studentView.displaySubjects(currentSubjects); // Display updated subjects list
            System.out.println("Subject " + subject.getSubjectName() + " has been added for " + student.getName());
        } else {
            System.out.println("Subject " + subject.getSubjectName() + " is already added for " + student.getName());
        }
    }

    // Method to create a schedule from a list of selected subjects
    public Map<String, Integer> createSchedule(List<SubjectModel> selectedSubjects) {
        if (selectedSubjects == null || selectedSubjects.isEmpty()) {
            System.out.println("No subjects provided to create a schedule.");
            return new HashMap<>();
        }

        Map<String, Integer> scheduleMap = new HashMap<>();
        System.out.println("Creating schedule:");

        for (SubjectModel subject : selectedSubjects) {
            Integer timeSlot = subject.getTimeslot();
            String name = subject.getSubjectName();
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

    public Student getStudent() {
        return student;
    }
}
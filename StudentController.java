import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentController {
    private Student student;
    private List<Aid> availableAids;
    private List<Student> students;
    private StudentView studentView;

    public StudentController(Student student, List<Student> students, StudentView studentView) {
        this.student = student;  // Assigning a specific student instance to the controller
        this.students = students;
        this.studentView = studentView;
    }

    public void registerStudent() {
        student.register();
    }

    public void viewStudentProfile(String studentID) {
        // Search for the student with the given ID
        Student student = findStudentByID(studentID);

        // Use StudentView to display the profile
        studentView.displayStudentProfile(student);
    }

    private Student findStudentByID(String studentID) {
        for (Student student : students) {
            if (student.getUserID().equals(studentID)) {
                return student;
            }
        }
        return null;
    }
    public boolean login (String userName, String passWord){
        LoginContext loginContext = new LoginContext(new StudentLoginStrategy());
        return loginContext.executeLogin("userName", "passWord");

    }

    public void updateStudentProfile(String name, String email, String phone, String address) {
        // Update each field using the setters in the User (parent) class
        student.setName(name);
        student.setEmail(email);
        student.setPhone(phone);
        student.setAddress(address);

        // Confirm the profile update using the view
        studentView.displayProfileUpdateConfirmation(student.getName());
    }

    public void addSubject(Subject subject) {
        // First, check if the student is registered by calling registerStudent
        if (subject.registerStudent(student)) { // registerStudent returns true if the student was newly registered
            System.out.println("Student " + student.getName() + " has been successfully registered.");
        }

        // Now proceed to add the subject if not already present
        if (!student.getSubjects().contains(subject)) {
            student.getSubjects().add(subject);
            studentView.displaySubjects(student.getSubjects()); // Display updated subjects list
            System.out.println("Subject " + subject.getName() + " has been added for " + student.getName());
        } else {
            System.out.println("Subject " + subject.getName() + " is already added for " + student.getName());
        }
    }

    // Assuming the registerStudent method is implemented as shown in the image




    public void applyForAid() {
        studentView.displayAidOptions(availableAids); // Display available aids

        // Simulate aid application process
        if (!availableAids.isEmpty()) {
            Aid aidToApply = availableAids.get(0); // Applying for the first available aid as an example
            if (aidToApply.isAvailable()) {
                aidToApply.setAvailable(false); // Mark as applied
                studentView.displayAidApplicationStatus(student.getName(), aidToApply); // Display aid application status
            } else {
                System.out.println("No available aid to apply for.");
            }
        }
    }

    public Map<String, Integer> createSchedule(List<Subject> selectedSubjects) {
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

}

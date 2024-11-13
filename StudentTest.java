import java.util.ArrayList;
import java.util.List;

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
                new ArrayList<>(StudentConfig.DEFAULT_SUBJECTS) // Convert to mutable ArrayList
        );

        // Create list of available aids (assume Aid is defined)
        List<Aid> availableAids = List.of(
                new Aid("Scholarship A", "Full scholarship", true),
                new Aid("Grant B", "Research grant", true)
        );

        // Create list of students and add the created student
        List<Student> students = new ArrayList<>();
        students.add(student);

        // Create the StudentView instance
        StudentView studentView = new StudentView();

        // Create the StudentController instance with students, view, and aids
        StudentController studentController = new StudentController(student,students, studentView);

        // Test: Register the student (should show registration message)
        System.out.println("Testing registerStudent:");
        studentController.registerStudent();

        // Test: View student profile
        System.out.println("\nTesting viewStudentProfile:");
        studentController.viewStudentProfile(StudentConfig.DEFAULT_USER_ID);

        // Test: Update student profile
        System.out.println("\nTesting updateStudentProfile:");
        studentController.updateStudentProfile(
                "Jane Doe",
                "jane.doe@example.com",
                "9876543210",
                "456 Elm St"
        );

        // Test: Add subjects to the student
        System.out.println("\nTesting addSubject:");
        studentController.addSubject(new Subject("Physics", "PHYS101", 2));
        studentController.addSubject(new Subject("Chemistry", "CHEM101", 3));

        // Attempt to add an already added subject
        System.out.println("\nTesting addSubject with an already added subject:");
        studentController.addSubject(new Subject("Math", "MTH101", 10));

        // Test: Apply for aid
        System.out.println("\nTesting applyForAid:");
        studentController.applyForAid();

        // Test: Create schedule
        System.out.println("\nTesting createSchedule:");
        studentController.createSchedule(student.getSubjects());
    }
}

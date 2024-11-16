package Student;

import java.util.*;

public class StudentApp {
    private static StudentView studentView = new StudentView();
    private static StudentController studentController;
    private static List<Student> students = new ArrayList<>();
    private Student student;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Student Management System");
        System.out.println("Are you an Undergraduate or Graduate student?");
        System.out.println("1. Undergraduate");
        System.out.println("2. Graduate");
        int studentType = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Student student;
        if (studentType == 1) {
            student = createUndergraduateStudent();
        } else {
            student = createGraduateStudent();
        }

        // Initialize StudentController with the selected student and StudentView
        studentController = new StudentController(student, students, studentView);

        // Add the student to the list of students
        students.add(student);

        // Display initial student profile
        studentController.viewStudentProfile(student.getUserID());

        // Main menu for options
        int choice;
        do {
            System.out.println("\nSelect an option:");
            System.out.println("1. View Profile");
            System.out.println("2. View Schedule");
            System.out.println("3. View Available Courses");
            System.out.println("4. Add Course");
            System.out.println("5. View Added Courses");
            System.out.println("6. Exit");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> studentController.viewStudentProfile(student.getUserID());
                case 2 -> viewSchedule();
                case 3 -> viewAvailableCourses();
                case 4 -> addCourse();
                case 5 -> viewAddedCourses();
                case 6 -> System.out.println("Exiting the system. Goodbye!");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }

    private static UndergraduateStudent createUndergraduateStudent() {
        return new UndergraduateStudent(
                null, null, null, null, null, null,
                StudentConfig.DEFAULT_BENEFICIARY_STATUS,
                null, null, null, null,
                new ArrayList<>(StudentConfig.DEFAULT_DONORS),
                new ArrayList<>(StudentConfig.DEFAULT_SUBJECTS),
                StudentConfig.DEFAULT_YEAR,
                StudentConfig.DEFAULT_GPA,
                StudentConfig.DEFAULT_INTERNSHIP_STATUS
        );
    }

    private static GraduateStudent createGraduateStudent() {
        return new GraduateStudent(
                null, null, null, null, null, null,
                StudentConfig.DEFAULT_BENEFICIARY_STATUS,
                null, null, null, null,
                new ArrayList<>(StudentConfig.DEFAULT_DONORS),
                new ArrayList<>(StudentConfig.DEFAULT_SUBJECTS),
                StudentConfig.DEFAULT_THESIS_TOPIC,
                StudentConfig.DEFAULT_ADVISOR_NAME,
                StudentConfig.DEFAULT_Grad_GPA,
                StudentConfig.DEFAULT_RESEARCH_AID_STATUS
        );
    }

    private static void viewSchedule() {
        Map<String, Integer> schedule = studentController.createSchedule(studentController.student.getSubjects());
        studentView.displaySchedule(schedule);
    }

    private static void viewAvailableCourses() {
        List<Subject> availableCourses = studentController.student.getAvailableSubjects();
        studentView.displaySubjects(availableCourses);
    }

    private static void addCourse() {
        Scanner scanner = new Scanner(System.in);
        List<Subject> availableCourses = StudentController.student.getAvailableSubjects();
        studentView.displaySubjects(availableCourses);

        System.out.println("Enter the subject code to add:");
        String subjectCode = scanner.nextLine();

        for (Subject subject : availableCourses) {
            if (subject.getCode().equals(subjectCode)) {
                studentController.addSubject(subject);
                return;
            }
        }
        System.out.println("Invalid subject code. Course not found.");
    }

    private static void viewAddedCourses() {
        List<Subject> addedCourses = studentController.student.getSubjects();
        studentView.displayAddedSubjects(addedCourses);
    }
}

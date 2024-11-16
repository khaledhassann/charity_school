import java.util.*;

public class StudentView {
    private static List<Student> students = initializeStudents();
    private static StudentController studentController;
    private static SchoolController schoolController;
    private static EventOrganizerStudent eventOrganizerStudent; // To hold the decorator instance if the student is an organizer
    private static SocialMediaHandler socialMediaHandler; // To hold the decorator instance if the student is a social media handler

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Student Management System");

        // Assume the student is already logged in and use the first student in the list as the logged-in student
        Student student = students.get(0); // Use the first student as the logged-in user
        studentController = new StudentController(student, students, new StudentView());

        // Ask if the student has the role of an event organizer or social media handler
        System.out.print("Is this student an event organizer? (yes/no): ");
        String isOrganizer = scanner.nextLine().trim().toLowerCase();

        System.out.print("Is this student a social media handler? (yes/no): ");
        String isHandler = scanner.nextLine().trim().toLowerCase();

        // Assign the respective decorators based on the user input
        if (isOrganizer.equals("yes")) {
            eventOrganizerStudent = new EventOrganizerStudent(student);
            System.out.println(student.getName() + " is now set as an Event Organizer.");
        }

        if (isHandler.equals("yes")) {
            System.out.print("Enter the student's social media handle: ");
            String socialMediaHandle = scanner.nextLine();
            socialMediaHandler = new SocialMediaHandler(student, socialMediaHandle);
            System.out.println(student.getName() + " is now set as a Social Media Handler with handle: " + socialMediaHandle);
        }

        // Display initial student profile
        displayStudentProfile(student);

        // Main menu for services
        int choice;
        do {
            System.out.println("\n--- Services Menu ---");
            System.out.println("1. View Profile");
            System.out.println("2. View Schedule");
            System.out.println("3. View Registered Courses");
            System.out.println("4. View Available Courses");
            System.out.println("5. Add Course");

            // Event Organizer-specific options
            if (eventOrganizerStudent != null) {
                System.out.println("6. Organize Event");
                System.out.println("7. Send Invitations");
                System.out.println("8. Track Event Budget");
                System.out.println("9. View Past Events");
                System.out.println("10. Collect Event Feedback");
            }

            // Social Media Handler-specific options
            if (socialMediaHandler != null) {
                System.out.println("11. Link Social Media");
                System.out.println("12. Share Event");
                System.out.println("13. View Recent Posts");
            }

            System.out.println("14. Exit");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Execute selected option
            switch (choice) {
                case 1 -> displayStudentProfile(student); // View Profile
                case 2 -> viewSchedule(); // View Schedule
                case 3 -> viewRegisteredCourses();
                case 4 -> viewAvailableCourses(); // View Available Courses
                case 5 -> addCourse(); // Add Course

                // Event Organizer functions
                case 6 -> {
                    if (eventOrganizerStudent != null) organizeEvent();
                    else System.out.println("Invalid choice. Please try again.");
                }
                case 7 -> {
                    if (eventOrganizerStudent != null) sendInvitations();
                    else System.out.println("Invalid choice. Please try again.");
                }
                case 8 -> {
                    if (eventOrganizerStudent != null) trackEventBudget();
                    else System.out.println("Invalid choice. Please try again.");
                }
                case 9 -> {
                    if (eventOrganizerStudent != null) viewPastEvents();
                    else System.out.println("Invalid choice. Please try again.");
                }
                case 10 -> {
                    if (eventOrganizerStudent != null) collectFeedback();
                    else System.out.println("Invalid choice. Please try again.");
                }

                // Social Media Handler functions
                case 11 -> {
                    if (socialMediaHandler != null) linkSocialMedia();
                    else System.out.println("Invalid choice. Please try again.");
                }
                case 12 -> {
                    if (socialMediaHandler != null) shareEvent();
                    else System.out.println("Invalid choice. Please try again.");
                }
                case 13 -> {
                    if (socialMediaHandler != null) viewRecentPosts();
                    else System.out.println("Invalid choice. Please try again.");
                }

                case 14 -> System.out.println("Exiting the system. Goodbye!");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 14);

        scanner.close();
    }

    // Method to initialize a list of existing students from StudentConfig
    private static List<Student> initializeStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(
                StudentConfig.DEFAULT_USER_ID, StudentConfig.DEFAULT_NAME, StudentConfig.DEFAULT_CONTACT_INFO,
                StudentConfig.DEFAULT_EMAIL, StudentConfig.DEFAULT_PHONE, StudentConfig.DEFAULT_ADDRESS,
                StudentConfig.DEFAULT_BENEFICIARY_STATUS, StudentConfig.DEFAULT_DATE_OF_BIRTH,
                StudentConfig.DEFAULT_NATIONALITY, StudentConfig.DEFAULT_MAJOR, StudentConfig.DEFAULT_ENROLLMENT_YEAR,
                new ArrayList<>(StudentConfig.DEFAULT_DONORS), new ArrayList<>(StudentConfig.DEFAULT_SUBJECTS)
        ));
        return students;
    }

    // Display the profile of a student
    public static void displayStudentProfile(Student student) {
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

    // Event Organizer methods
    private static void organizeEvent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter event name: ");
        String eventName = scanner.nextLine();
        System.out.print("Enter event date (yyyy-mm-dd): ");
        String dateInput = scanner.nextLine();
        Date eventDate = java.sql.Date.valueOf(dateInput);
        eventOrganizerStudent.organizeEvent(eventName, eventDate);
    }

    private static void sendInvitations() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter event name for invitations: ");
        String eventName = scanner.nextLine();
        eventOrganizerStudent.sendInvitations(eventName);
    }

    private static void trackEventBudget() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter event name: ");
        String eventName = scanner.nextLine();
        System.out.print("Enter allocated budget: ");
        double budget = scanner.nextDouble();
        eventOrganizerStudent.trackEventBudget(eventName, budget);
    }

    private static void viewPastEvents() {
        eventOrganizerStudent.viewPastEvents();
    }

    private static void collectFeedback() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter event name to collect feedback for: ");
        String eventName = scanner.nextLine();
        System.out.print("Enter feedback (type 'done' to finish): ");
        List<String> feedback = new ArrayList<>();
        while (true) {
            String fb = scanner.nextLine();
            if (fb.equalsIgnoreCase("done")) break;
            feedback.add(fb);
        }
        eventOrganizerStudent.collectFeedback(eventName, feedback);
    }

    // Social Media Handler methods
    private static void linkSocialMedia() {
        System.out.print("Enter social media platform: ");
        Scanner scanner = new Scanner(System.in);
        String platform = scanner.nextLine();
        socialMediaHandler.linkSocialMedia(platform);
    }

    private static void shareEvent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter event name to share: ");
        String eventName = scanner.nextLine();
        System.out.print("Enter event date (yyyy-mm-dd): ");
        String eventDate = scanner.nextLine();
        socialMediaHandler.shareEvent(eventName, eventDate);
    }

    private static void viewRecentPosts() {
        socialMediaHandler.viewRecentPosts();
    }

    // Existing Student functions (schedule, subjects, add course)
    public static void viewSchedule() {
        Map<String, Integer> schedule = studentController.createSchedule(studentController.getStudent().getSubjects());
        displaySchedule(schedule);
    }

    public static void viewRegisteredCourses() {
        List<SubjectModel> registeredCourses = studentController.getStudent().getAvailableSubjects();
        displaySubjects(registeredCourses);
    }

    public static void viewAvailableCourses() {
        schoolController.displaySubjects();
    }

    public static void addCourse() {
        Scanner scanner = new Scanner(System.in);
        List<SubjectModel> availableCourses = studentController.getStudent().getAvailableSubjects();
        displaySubjects(availableCourses);

        System.out.println("Enter the subject code to add:");
        String subjectCode = scanner.nextLine();

        for (SubjectModel subject : schoolController.getAllSubjects()) {
            if (schoolController.subjectExists(subject)) {
                studentController.addSubject(subject);
                System.out.println("Course " + subject.getName() + " added successfully.");
                return;
            }
        }
        System.out.println("Invalid subject code. Course not found.");
    }

    public static void displaySchedule(Map<String, Integer> schedule) {
        if (schedule == null || schedule.isEmpty()) {
            System.out.println("No schedule available.");
            return;
        }
        System.out.println("Student Schedule:");
        for (Map.Entry<String, Integer> entry : schedule.entrySet()) {
            System.out.println("Subject: " + entry.getKey() + ", Credit Hours: " + entry.getValue());
        }
    }

    public static void displaySubjects(List<SubjectModel> subjects) {
        if (subjects == null || subjects.isEmpty()) {
            System.out.println("No subjects to display.");
            return;
        }
        System.out.println("------ List of Subjects ------");
        for (SubjectModel subject : subjects) {
            System.out.println("Name: " + subject.getName());
            System.out.println("Code: " + subject.getCode());
            System.out.println("-----------------------------");
        }
    }
}

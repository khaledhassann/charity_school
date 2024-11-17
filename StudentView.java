import java.util.*;

public class StudentView {
    private final Scanner scanner = new Scanner(System.in);
    private List<Student> students;
    private StudentController studentController;
    private SchoolController schoolController;
    private static EventOrganizerStudent eventOrganizerStudent;
    private static SocialMediaHandler socialMediaHandler;

    public StudentView(Student student, SchoolController schoolController, boolean isEventOrganizer,
            boolean isSocialMediaHandler, String socialMediaHandle) {
        this.schoolController = schoolController;
        this.students = schoolController.getAllStudents();
        this.studentController = new StudentController(student, students, this);
    }

    public void showMainMenu() {
        // Student student = loginStudent();
        boolean running = true;

        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. View Profile");
            System.out.println("2. View Schedule");
            System.out.println("3. View Registered Courses");
            System.out.println("4. View Available Courses");
            System.out.println("5. Add Course");

            if (eventOrganizerStudent != null) {
                System.out.println("6. Event Organizer Options");
            }
            if (socialMediaHandler != null) {
                System.out.println("7. Social Media Handler Options");
            }
            System.out.println("8. Exit");

            int choice = getOption();

            switch (choice) {
                case 1:
                    displayStudentProfile(config.EXAMPLE_STUDENT);
                    break;
                case 2:
                    viewSchedule();
                    break;
                case 3:
                    viewRegisteredCourses();
                    break;
                case 4:
                    viewAvailableCourses();
                    break;
                case 5:
                    addCourse();
                    break;
                case 6:
                    if (eventOrganizerStudent != null)
                        showEventOrganizerOptions();
                    else
                        displayMessage("Invalid option.");
                    break;
                case 7:
                    if (socialMediaHandler != null)
                        showSocialMediaHandlerOptions();
                    else
                        displayMessage("Invalid option.");
                    break;
                case 8:
                    running = false;
                    break;
                default:
                    displayMessage("Invalid option. Please try again.");
                    break;
            }
        }

        displayMessage("Exiting system. Goodbye!");
    }

    private Student loginStudent() {
        Student student = students.get(0);
        studentController = new StudentController(student, students, this);

        System.out.print("Is this student an event organizer? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            eventOrganizerStudent = new EventOrganizerStudent(student);
            displayMessage(student.getName() + " is now set as an Event Organizer.");
        }

        System.out.print("Is this student a social media handler? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            System.out.print("Enter social media handle: ");
            String socialMediaHandle = scanner.nextLine();
            socialMediaHandler = new SocialMediaHandler(student, socialMediaHandle);
            displayMessage(
                    student.getName() + " is now set as a Social Media Handler with handle: " + socialMediaHandle);
        }

        displayStudentProfile(student);
        return student;
    }

    private void showEventOrganizerOptions() {
        boolean running = true;

        while (running) {
            System.out.println("\n--- Event Organizer Options ---");
            System.out.println("1. Organize Event");
            System.out.println("2. Send Invitations");
            System.out.println("3. Track Event Budget");
            System.out.println("4. View Past Events");
            System.out.println("5. Collect Event Feedback");
            System.out.println("6. Return to Main Menu");

            int choice = getOption();

            switch (choice) {
                case 1:
                    organizeEvent();
                    break;
                case 2:
                    sendInvitations();
                    break;
                case 3:
                    trackEventBudget();
                    break;
                case 4:
                    viewPastEvents();
                    break;
                case 5:
                    collectFeedback();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    displayMessage("Invalid option.");
                    break;
            }
        }
    }

    private void showSocialMediaHandlerOptions() {
        boolean running = true;

        while (running) {
            System.out.println("\n--- Social Media Handler Options ---");
            System.out.println("1. Link Social Media");
            System.out.println("2. Share Event");
            System.out.println("3. View Recent Posts");
            System.out.println("4. Return to Main Menu");

            int choice = getOption();

            switch (choice) {
                case 1:
                    linkSocialMedia();
                    break;
                case 2:
                    shareEvent();
                    break;
                case 3:
                    viewRecentPosts();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    displayMessage("Invalid option.");
                    break;
            }
        }
    }

    // Event Organizer methods
    private void organizeEvent() {
        System.out.print("Enter event name: ");
        String eventName = scanner.nextLine();
        System.out.print("Enter event date (yyyy-mm-dd): ");
        Date eventDate = java.sql.Date.valueOf(scanner.nextLine());
        eventOrganizerStudent.organizeEvent(eventName, eventDate);
    }

    private void sendInvitations() {
        System.out.print("Enter event name for invitations: ");
        String eventName = scanner.nextLine();
        eventOrganizerStudent.sendInvitations(eventName);
    }

    private void trackEventBudget() {
        System.out.print("Enter event name: ");
        String eventName = scanner.nextLine();
        System.out.print("Enter allocated budget: ");
        double budget = scanner.nextDouble();
        scanner.nextLine();
        eventOrganizerStudent.trackEventBudget(eventName, budget);
    }

    private void viewPastEvents() {
        eventOrganizerStudent.viewPastEvents();
    }

    private void collectFeedback() {
        System.out.print("Enter event name to collect feedback for: ");
        String eventName = scanner.nextLine();
        List<String> feedback = new ArrayList<>();
        System.out.print("Enter feedback (type 'done' to finish): ");
        while (true) {
            String fb = scanner.nextLine();
            if (fb.equalsIgnoreCase("done"))
                break;
            feedback.add(fb);
        }
        eventOrganizerStudent.collectFeedback(eventName, feedback);
    }

    // Social Media Handler methods
    private void linkSocialMedia() {
        System.out.print("Enter social media platform: ");
        String platform = scanner.nextLine();
        socialMediaHandler.linkSocialMedia(platform);
    }

    private void shareEvent() {
        System.out.print("Enter event name to share: ");
        String eventName = scanner.nextLine();
        System.out.print("Enter event date (yyyy-mm-dd): ");
        String eventDate = scanner.nextLine();
        socialMediaHandler.shareEvent(eventName, eventDate);
    }

    private void viewRecentPosts() {
        socialMediaHandler.viewRecentPosts();
    }

    // Student methods
    public void displayStudentProfile(Student student) {
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.println("------ Student Profile ------");
        System.out.println("ID: " + student.getUserID());
        System.out.println("Name: " + student.getName());
        System.out.println("Email: " + student.getEmail());
        System.out.println("Date of Birth: " + student.getDateOfBirth());
        System.out.println("Nationality: " + student.getNationality());
        System.out.println("Major: " + student.getMajor());
        System.out.println("Enrollment Year: " + student.getEnrollmentYear());
        System.out.println("Beneficiary Status: " + (student.getBeneficiaryStatus() ? "Yes" : "No"));
        System.out.println("------ End of Profile ------");
    }

    private void viewSchedule() {
        Map<String, Integer> schedule = studentController.createSchedule(studentController.getStudent().getSubjects());
        displaySchedule(schedule);
    }

    private void viewRegisteredCourses() {
        List<SubjectModel> registeredCourses = studentController.getStudent().getAvailableSubjects();
        displaySubjects(registeredCourses);
    }

    private void viewAvailableCourses() {
        schoolController.displaySubjects();
    }

    private void addCourse() {
        List<SubjectModel> availableCourses = studentController.getStudent().getAvailableSubjects();
        displaySubjects(availableCourses);
        System.out.print("Enter the subject code to add: ");
        String subjectCode = scanner.nextLine();

        for (SubjectModel subject : schoolController.getAllSubjects()) {
            if (schoolController.subjectExists(subject)) {
                studentController.addSubject(subject);
                System.out.println("Course " + subject.getSubjectName() + " added successfully.");
                return;
            }
        }
        System.out.println("Invalid subject code. Course not found.");
    }

    private int getOption() {
        System.out.print("Choose an option: ");
        return scanner.nextInt();
    }

    private static List<Student> initializeStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(
                StudentConfig.DEFAULT_USER_ID, StudentConfig.DEFAULT_NAME,
                StudentConfig.DEFAULT_EMAIL,
                StudentConfig.DEFAULT_BENEFICIARY_STATUS, StudentConfig.DEFAULT_DATE_OF_BIRTH,
                StudentConfig.DEFAULT_NATIONALITY, StudentConfig.DEFAULT_MAJOR, StudentConfig.DEFAULT_ENROLLMENT_YEAR,
                new ArrayList<>(StudentConfig.DEFAULT_DONORS), new ArrayList<>(StudentConfig.DEFAULT_SUBJECTS)));
        return students;
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

    public void displaySubjects(List<SubjectModel> subjects) {
        if (subjects == null || subjects.isEmpty()) {
            System.out.println("No subjects to display.");
            return;
        }
        System.out.println("------ List of Subjects ------");
        for (SubjectModel subject : subjects) {
            System.out.println("Name: " + subject.getSubjectName());
            System.out.println("Code: " + subject.getSubjectCode());
            System.out.println("-----------------------------");
        }
    }

    private void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayAddedSubjects(List<SubjectModel> addedSubjects) {
        if (addedSubjects == null || addedSubjects.isEmpty()) {
            System.out.println("No subjects have been added previously.");
            return;
        }

        System.out.println("------ Previously Added Subjects ------");
        for (SubjectModel subject : addedSubjects) {
            System.out.println("Name: " + subject.getSubjectName());
            System.out.println("Code: " + subject.getSubjectCode());
            System.out.println("---------------------------------------");
        }
    }
}
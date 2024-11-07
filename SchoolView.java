import java.util.Optional;
import java.util.Scanner;

public class SchoolView {
    private SchoolController schoolController;
    private Scanner scanner;

    public SchoolView(SchoolController controller) {
        this.schoolController = controller;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        try (Scanner scanner = new Scanner(System.in)) {
            int choice;
            do {
                System.out.println("\nWelcome to the Masr El Kheir charity!");
                System.out.println("***************************************");
                System.out.println("Please choose an option:");
                System.out.println("1. Display available courses");
                System.out.println("2. Select specific course");
                System.out.println("0. Exit");

                System.out.print("Your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        schoolController.displaySubjects();
                        break;

                    case 2:
                        handleCourseSelection();
                        break;

                    case 0:
                        System.out.println("Exiting the program. Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice, please try again.");
                        break;
                }
            } while (choice != 0);
        }

    }

    private void handleCourseSelection() {
        System.out.println("Enter course code to select: ");
        String courseCode = scanner.nextLine();
        Optional<Subject> result = schoolController.selectCourseByCode(courseCode);

        result.ifPresentOrElse(
                subject -> {
                    int subChoice;
                    do {
                        System.out.println("\nSelected course: " + subject.getDetails());
                        System.out.println("21. Add assessment");
                        System.out.println("22. Remove assessment");
                        System.out.println("23. Display all assessments");
                        System.out.println("0. Back to main menu");

                        System.out.print("Your choice: ");
                        subChoice = scanner.nextInt();
                        scanner.nextLine(); // Clear buffer

                        switch (subChoice) {
                            case 21:
                                System.out.println("Adding an assessment for " + subject.getCode());
                                schoolController.addAssessmentToSubject(subject.getCode(),
                                        new Assessment("Assessment 1", 0.1, 10));
                                break;

                            case 22:
                                System.out.print("Enter the name of the assessment to remove: ");
                                String assessmentName = scanner.nextLine();
                                schoolController.removeAssessmentFromSubject(subject, assessmentName);
                                break;

                            case 23:
                                subject.displayAllAssessments();
                                break;

                            case 0:
                                System.out.println("Returning to main menu...");
                                break;

                            default:
                                System.out.println("Invalid choice, please try again.");
                        }
                    } while (subChoice != 0);
                },
                () -> System.out.println("Subject with code " + courseCode + " not found!"));
    }

}

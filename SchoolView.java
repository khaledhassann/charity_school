import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class SchoolView {
    private SchoolController schoolController;
    private Scanner scanner;

    public SchoolView() {
        this.schoolController = new SchoolController(new SchoolModel(
                "Test School",
                "Test Location",
                List.of(new SubjectModel("Math 101", "MATH101", 3, new LetterGrading(), new WrittenExam(), 4,
                        config.EXAMPLE_DONOR),
                        new SubjectModel("History101", "ASU300", 2,
                                new PassFailGrading(), new PracticalExam(), 3, config.EXAMPLE_DONOR)),
                List.of(config.EXAMPLE_DONOR, config.EXAMPLE_STUDENT,
                        new Student("2084", "Omar", "omar@email.com", false, null, null, null, 0, null, null))));
        this.scanner = new Scanner(System.in);
    }

    private void handleAddingCourse() {
        scanner.nextLine(); // Clear buffer
        System.out.print("Enter the name of the new course: ");
        String courseName = scanner.nextLine();
        System.out.print("Enter the code of the new course: ");
        String courseCode = scanner.nextLine();
        System.out.print("Enter the credits of the new course: ");
        int courseCredits = scanner.nextInt();

        SubjectModel newSubject = new SubjectModel(courseName, courseCode, courseCredits, null, null, courseCredits,
                null); // Assuming SubjectModel has
        // a constructor
        boolean isAdded = schoolController.updateAvailableSubjects(List.of(newSubject));

        if (isAdded) {
            System.out.println("Course \"" + courseName + "\" has been successfully added!");
        } else {
            System.out.println("Failed to add the course. It might already exist.");
        }
    }

    private void handleRemovingCourse() {
        scanner.nextLine(); // Clear buffer
        System.out.print("Enter the code of the course to remove: ");
        String courseCode = scanner.nextLine();

        Optional<SubjectModel> subjectToRemove = schoolController.selectCourseByCode(courseCode);

        subjectToRemove.ifPresentOrElse(subject -> {
            boolean isRemoved = schoolController.removeSubject(subject);
            if (isRemoved) {
                System.out.println("Course \"" + subject.getSubjectName() + "\" has been successfully removed!");
            } else {
                System.out.println("Failed to remove the course.");
            }
        }, () -> {
            System.out.println("Course with code \"" + courseCode + "\" not found.");
        });
    }

    private void handleCourseSelection() {
        scanner.nextLine(); // Clear buffer
        System.out.println("Enter course code to select: ");
        String courseCode = scanner.nextLine();
        Optional<SubjectModel> result = schoolController.selectCourseByCode(courseCode);

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
                                System.out.println("Adding an assessment for " + subject.getSubjectCode());
                                schoolController.addAssessmentToSubject(subject.getSubjectCode(),
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

    public void showMenu() {
        int choice = 0;
        do {
            System.out.println("\nWelcome to the Masr El Kheir charity!");
            System.out.println("***************************************");
            System.out.println("Please choose an option:");
            System.out.println("1. Display available courses");
            System.out.println("2. Select specific course");
            System.out.println("3. Add course");
            System.out.println("4. Remove course");
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

                case 3:
                    handleAddingCourse();
                    break;

                case 4:
                    handleRemovingCourse();
                    break;

                case 0:
                    System.out.println("Going back to main Menu!");
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        } while (choice != 0);
    }

}

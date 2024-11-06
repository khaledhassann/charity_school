import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Subject> subjects = new ArrayList<Subject>() {
            {
                add(new AdvancedModule(new Math()));
                add(new Science());
                add(new ExtraCurricular(new History()));
            }
        };

        School AinShamsLanguageSchool = new School(subjects);

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
                        AinShamsLanguageSchool.displaySubjects();
                        break;

                    case 2:
                        System.out.print("Enter course code to select: ");
                        String courseCode = scanner.next();
                        Optional<Subject> result = AinShamsLanguageSchool.findSubjectByCode(courseCode);
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

                                        switch (subChoice) {
                                            case 21:
                                                System.out.println("Adding an assessment for " + subject.getCode());
                                                subject.addAssessment(new Assessment("Assessment 1", 0.1, 10));
                                                // Add assessment logic here
                                                break;

                                            case 22:
                                                // Prompt user to enter assessment name to remove
                                                System.out.print("Enter the name of the assessment to remove: ");
                                                scanner.nextLine(); // Clear the buffer
                                                String assessmentName = scanner.nextLine();

                                                // Remove the assessment based on the name
                                                Optional<Assessment> assessmentToRemove = subject.getAssessments()
                                                        .stream()
                                                        .filter(a -> a.getAssessmentName().equals(assessmentName))
                                                        .findFirst();

                                                assessmentToRemove.ifPresentOrElse(
                                                        assessment -> {
                                                            subject.removeAssessment(assessment);
                                                            System.out.println("Assessment \""
                                                                    + assessment.getAssessmentName() + "\" removed.");
                                                        },
                                                        () -> System.out.println("Assessment with name \""
                                                                + assessmentName + "\" not found."));
                                                break;

                                            case 23:
                                                subject.displayAllAssessments();
                                                // Display assessments logic here
                                                break;

                                            case 0:
                                                System.out.println("Returning to main menu...");
                                                break;

                                            default:
                                                System.out.println("Invalid choice, please try again.");
                                                break;
                                        }
                                    } while (subChoice != 0); // End of inner loop for submenu
                                },
                                () -> System.out.println("Subject with code " + courseCode + " not found"));
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

}

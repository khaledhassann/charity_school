import java.util.ArrayList;
import java.util.List;

// public class Main {
//     public static void main(String[] args) {
//         List<Subject> subjects = new ArrayList<Subject>() {
//             {
//                 add(new AdvancedModule(new Math()));
//                 add(new Science());
//                 add(new ExtraCurricular(new History()));
//             }
//         };

//         SchoolModel AinShamsLanguageSchool = new SchoolModel("Ain Shams Language School", "Abbaseya", subjects);
//         SchoolController schoolController = new SchoolController(AinShamsLanguageSchool);
//         SchoolView schoolView = new SchoolView(schoolController);

//         schoolView.showMenu();
//     }

// }
public class Main {
    public static void main(String[] args) {
        // Create a mock SchoolView to pass into AdminView
        SchoolView mockSchoolView = new SchoolView(new SchoolController(new SchoolModel(
                "Test School",
                "Test Location",
                List.of(new SubjectModel("Math 101", "MATH101", 3, new LetterGrading(), new WrittenExam(), 4,
                        config.EXAMPLE_DONOR),
                        new SubjectModel("History101", "ASU300", 2,
                                new PassFailGrading(), new PracticalExam(), 3, config.EXAMPLE_DONOR)))));

        // Create the AdminView and set the SchoolView
        AdminView adminView = new AdminView(mockSchoolView);

        // Show the main menu for the Admin console
        adminView.showMainMenu();
    }
}

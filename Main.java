import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Room.RoomView;

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
        // SchoolController schoolController = new SchoolController(new SchoolModel(
        // "Test School",
        // "Test Location",
        // List.of(new SubjectModel("Math 101", "MATH101", 3, new LetterGrading(), new
        // WrittenExam(), 4,
        // config.EXAMPLE_DONOR),
        // new SubjectModel("History101", "ASU300", 2,
        // new PassFailGrading(), new PracticalExam(), 3, config.EXAMPLE_DONOR))));
        // SubjectView subjectView = new SubjectView();
        // List<SubjectModel> availableSubjects = List.of(
        // new SubjectModel("Math 101", "MATH101", 3, new LetterGrading(), new
        // WrittenExam(), 4,
        // config.EXAMPLE_DONOR),
        // new SubjectModel("History101", "ASU300", 2,
        // new PassFailGrading(), new PracticalExam(), 3, config.EXAMPLE_DONOR));
        // Schedule schedule = new Schedule(availableSubjects);
        // ! Trying to test mariam's code
        List<SubjectModel> listOfAvailableSubjects = List.of(new SubjectModel("History", "ASU300", 2,
                new LetterGrading(), new WrittenExam(), 1, config.EXAMPLE_DONOR),
                new SubjectModel("Math", "PHM100", 3, new PassFailGrading(), new WrittenExam(), 1,
                        config.EXAMPLE_DONOR),
                new SubjectModel("Programming", "CSE300", 4, new PassFailGrading(), new PracticalExam(), 5,
                        config.EXAMPLE_DONOR));
        SchoolController schoolController = new SchoolController(
                new SchoolModel("Ain Shams Language Schools", "Abbaseya", listOfAvailableSubjects, List.of(
                        config.EXAMPLE_DONOR, config.EXAMPLE_STUDENT,
                        new Student("2084", "Omar", "omar@email.com", false, null, null, null, 0, null,
                                config.EXAMPLE_SUBJECTS_LIST_1))));
        StudentView studentView = new StudentView(config.EXAMPLE_STUDENT, schoolController, false, false,
                "habibay2002");
        studentView.showMainMenu();

        // ! Khaled's Admin code
        // SchoolView mockSchoolView = new SchoolView();
        // RoomView roomView = new RoomView();
        // DonationView donationView = new DonationView();
        // EventView eventView = new EventView();
        // // Create the AdminView and set the SchoolView
        // AdminView adminView = new AdminView(mockSchoolView, roomView, donationView,
        // eventView);
        // adminView.showMainMenu();

    }
}

package Login;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import School.*;

public class StudentLoginStrategy extends ILoginStrategy {


    private final String filePath = "./src/Data/Students.txt";
    
    @Override
    public boolean login(String username, String password) {
        // System.out.print("Validating credentials..." + username + " " + password);
        if (!validate(username, password, filePath)) {
            System.out.println("Invalid credentials. Please try again.");
            return false;
        }
        // Redirect to student dashboard
        System.out.println("Forward to student menu.");

        // Route to relevant page
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
        
        return true;
    }
}

package Student;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GraduateTest {
    public static void main(String[] args) {
        // Create an instance of GraduateStudent using StudentConfig for default values
        GraduateStudent graduateStudent = new GraduateStudent(
                null, // userID (will use default from StudentConfig)
                null, // name (will use default from StudentConfig)
                null, // contactInfo (will use default from StudentConfig)
                null, // email (will use default from StudentConfig)
                null, // phone (will use default from StudentConfig)
                null, // address (will use default from StudentConfig)
                StudentConfig.DEFAULT_BENEFICIARY_STATUS,
                null, // dateOfBirth (will use default from StudentConfig)
                null, // nationality (will use default from StudentConfig)
                null, // major (will use default from StudentConfig)
                null, // enrollmentYear (will use default from StudentConfig)
                new ArrayList<>(StudentConfig.DEFAULT_DONORS), // donors (from StudentConfig)
                new ArrayList<>(StudentConfig.DEFAULT_SUBJECTS), // subjects (from StudentConfig)
                // GPA (will use default from StudentConfig)
                StudentConfig.DEFAULT_THESIS_TOPIC, // thesis topic (will use default from StudentConfig)
                StudentConfig.DEFAULT_ADVISOR_NAME ,
                StudentConfig.DEFAULT_Grad_GPA,
                StudentConfig.DEFAULT_RESEARCH_AID_STATUS


        );

        // Display initial student information
        System.out.println("Graduate Student Name: " + graduateStudent.getName());
        System.out.println("Student ID: " + graduateStudent.getUserID());
        System.out.println("Major: " + graduateStudent.getMajor());
        System.out.println("Nationality: " + graduateStudent.getNationality());
        System.out.println("GPA: " + graduateStudent.getGpa());
        System.out.println("Thesis Topic: " + graduateStudent.getThesisTopic());
        System.out.println("Advisor: " + graduateStudent.getAdvisorName());


        // Test methods
        graduateStudent.submitThesis();
        graduateStudent.applyForResearchAid();

        // Update GPA and retest research aid eligibility
        System.out.println("\n--- Updating GPA and Retesting Research Aid Eligibility ---");
        graduateStudent.setGpa(3.8f);
        graduateStudent.applyForResearchAid();

        // Change thesis topic and display updated information
        System.out.println("\n--- Changing Thesis Topic ---");
        graduateStudent.setThesisTopic("Advanced Machine Learning Techniques");
        System.out.println("Updated Thesis Topic: " + graduateStudent.getThesisTopic());
    }

}


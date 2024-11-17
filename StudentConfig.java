import java.util.Arrays;
import java.util.List;

public class StudentConfig {

    // Default values for students
    public static final String DEFAULT_DATE_OF_BIRTH = "15-11-2002";
    public static final String DEFAULT_NATIONALITY = "Egyptian";
    public static final String DEFAULT_MAJOR = "Computer Engineering";
    public static final int DEFAULT_ENROLLMENT_YEAR = 2024;

    public static final List<Donor> DEFAULT_DONORS = Arrays.asList(
            config.EXAMPLE_DONOR,
            config.EXAMPLE_DONOR);

    public static final List<SubjectModel> DEFAULT_SUBJECTS = Arrays.asList(
            new SubjectModel("Math", "MTH101", 10, null, null, 0, null),
            new SubjectModel("Computer Science ", "CS101", 9, null, null, 0, null));

    public static final String DEFAULT_USER_ID = "S0001";
    public static final String DEFAULT_NAME = "Mariam";
    public static final String DEFAULT_CONTACT_INFO = "N/A";
    public static final String DEFAULT_EMAIL = "Mariam@student.com";
    public static final String DEFAULT_PHONE = "123-456";
    public static final String DEFAULT_ADDRESS = "New Cairo";
    public static final boolean DEFAULT_BENEFICIARY_STATUS = false;

    // Default values specific to GraduateStudent
    public static final String DEFAULT_THESIS_TOPIC = "Default Thesis Topic";
    public static final String DEFAULT_ADVISOR_NAME = "Dr. Smith";
    public static final boolean DEFAULT_RESEARCH_AID_STATUS = false;
    public static final float DEFAULT_Grad_GPA = 2.5f;

    // Default values specific to UndergraduateStudent
    public static final int DEFAULT_YEAR = 1;
    public static final float DEFAULT_GPA = 2.5f;
    public static final String DEFAULT_INTERNSHIP_STATUS = "Not Applied";

    // Sample Undergraduate Profile

}
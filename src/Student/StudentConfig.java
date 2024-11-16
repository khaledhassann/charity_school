package Student;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class StudentConfig {

    public static final String DEFAULT_DATE_OF_BIRTH = "15-11-2002";
    public static final String DEFAULT_NATIONALITY = "Egyptian";
    public static final String DEFAULT_MAJOR = "Computer Engineering";
    public static final Date DEFAULT_ENROLLMENT_YEAR = new Date();

    public static final List<Donor> DEFAULT_DONORS = Arrays.asList(
            new Donor("Donor 1", "donor1@example.com"),
            new Donor("Donor 2", "donor2@example.com")
    );

    public static final List<Subject> DEFAULT_SUBJECTS = Arrays.asList(
            new Subject("Math", "MTH101",10),
            new Subject("Computer Science ", "CS101",9)
    );


    public static final String DEFAULT_USER_ID = "S0001";
    public static final String DEFAULT_NAME = "Mariam";
    public static final String DEFAULT_CONTACT_INFO = "N/A";
    public static final String DEFAULT_EMAIL = "Mariam@student.com";
    public static final String DEFAULT_PHONE = "123-456";
    public static final String DEFAULT_ADDRESS = "new cairo";
    public static final boolean DEFAULT_BENEFICIARY_STATUS = false;


// for graduate class
    public static final String DEFAULT_THESIS_TOPIC = "Default Thesis Topic";
    public static final String DEFAULT_ADVISOR_NAME = "Dr. Smith";
    public static final boolean DEFAULT_RESEARCH_AID_STATUS = false;
    public static final float DEFAULT_Grad_GPA = 2.5f;



//for undergraduate class
    public static final int DEFAULT_YEAR = 1;
    public static final float DEFAULT_GPA = 2.5f;
    public static final String DEFAULT_INTERNSHIP_STATUS = "Not Applied";


}


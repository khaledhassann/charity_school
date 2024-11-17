import java.util.ArrayList;
import java.util.List;

public class config {
    public static final Volunteer EXAMPLE_VOLUNTEER = new Volunteer("2", "Adham", "adham@email.com", "0300200100",
            "Madinet Nasr", false);
    public static final DonationRequest EXAMPLE_DONATION_REQUEST = new DonationRequest();
    public static final Donor EXAMPLE_DONOR = new Donor("3", "Omar", "omar@email.com", "0200300100", "Egypt", false);
    public static final List<SubjectModel> EXAMPLE_SUBJECTS_LIST_1 = new ArrayList<>(List
            .of(new SubjectModel("Math", "PHM100", 3, new LetterGrading(), new WrittenExam(), 1, config.EXAMPLE_DONOR),
                    new SubjectModel("History", "ASU300", 2, new LetterGrading(), new WrittenExam(), 2, EXAMPLE_DONOR),
                    new SubjectModel("Programming", "CSE100", 4, new PassFailGrading(), new PracticalExam(), 3,
                            EXAMPLE_DONOR)));
    public static final List<SubjectModel> EXAMPLE_SUBJECTS_LIST_2 = new ArrayList<>(List
            .of(new SubjectModel("Statics", "PHM200", 3, new LetterGrading(), new WrittenExam(), 4,
                    config.EXAMPLE_DONOR),
                    new SubjectModel("Circuits", "ECE100", 3, new LetterGrading(), new PracticalExam(), 5,
                            EXAMPLE_DONOR),
                    new SubjectModel("Drawing", "ENVR100", 2, new PassFailGrading(), new PracticalExam(), 6,
                            EXAMPLE_DONOR)));
    public static final Student EXAMPLE_STUDENT = new Student("9595", "Habiba", "habiba@email.com", false, null, null,
            null, 0, null, config.EXAMPLE_SUBJECTS_LIST_2);
    public static final DonationController EXAPMLE_DONATION_CONTROLLER = new DonationController();
    public static final VolunteerController EXAMPLE_VOLUNTEER_CONTROLLER = new VolunteerController();

    public static final ArrayList<User> schoolUsersList = new ArrayList<User>() {
        {
            add(EXAMPLE_DONOR);
            // add(EXAMPLE_STUDENT);
            add(EXAMPLE_VOLUNTEER);
        }
    };

}
package School;

import java.util.ArrayList;

public class config {
    public static final Volunteer EXAMPLE_VOLUNTEER = new Volunteer("2", "Adham", "adham@email.com", "0300200100",
            "Madinet Nasr", false);
    public static final DonationRequest EXAMPLE_DONATION_REQUEST = new DonationRequest();
    public static final Donor EXAMPLE_DONOR = new Donor("3", "Omar", "omar@email.com", "0200300100", "Egypt", false);
    public static final Student EXAMPLE_STUDENT = new Student("9595", "Habiba", "habiba@email.com", false, null, null,
            null, null, null, null);
    public static final DonationController EXAPMLE_DONATION_CONTROLLER = new DonationController();
    public static final VolunteerController EXAMPLE_VOLUNTEER_CONTROLLER = new VolunteerController();
    public static final ArrayList<User> schoolUsersList = new ArrayList<User>() {
        {
            add(EXAMPLE_DONOR);
            add(EXAMPLE_STUDENT);
            add(EXAMPLE_VOLUNTEER);
        }
    };

}
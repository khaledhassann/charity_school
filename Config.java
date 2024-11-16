import java.util.List;

public class Config {
    // User-related constants
    public static final String DEFAULT_USER_ID = "S0001";
    public static final String DEFAULT_NAME = "Habiba";
    public static final String DEFAULT_CONTACT_INFO = "N/A";
    public static final String DEFAULT_EMAIL = "habiba@volunteer.com";
    public static final String DEFAULT_PHONE = "123-456";
    public static final String DEFAULT_ADDRESS = "New Cairo";

    public static final int DEFAULT_EVENT_ID = 1;
    public static final String DEFAULT_EVENT_NAME = "Charity Workshop";
    public static final String DEFAULT_EVENT_DATE = "2024-12-10";
    public static final String DEFAULT_EVENT_LOCATION = "Community Hall";

    // Sample data for other events
    public static final List<Integer> SAMPLE_EVENT_IDS = List.of(2, 3, 4);
    public static final List<String> SAMPLE_EVENT_NAMES = List.of(
            "Fundraising Gala",
            "Coding Bootcamp",
            "Health Awareness Drive"
    );
    public static final List<String> SAMPLE_EVENT_DATES = List.of(
            "2024-12-15",
            "2024-12-20",
            "2024-12-22"
    );
    public static final List<String> SAMPLE_EVENT_LOCATIONS = List.of(
            "Grand Ballroom",
            "Tech Center",
            "Local Clinic"
    );


}

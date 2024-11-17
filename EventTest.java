import java.util.ArrayList;
import java.util.List;

public class EventTest {
    public static void main(String[] args) {
        // Initialize sample events using Config
        List<Event> events = new ArrayList<>();
        events.add(new Event(
                Config.DEFAULT_EVENT_ID,
                Config.DEFAULT_EVENT_NAME,
                Config.DEFAULT_EVENT_DATE,
                Config.DEFAULT_EVENT_LOCATION
        ));

        for (int i = 0; i < Config.SAMPLE_EVENT_IDS.size(); i++) {
            events.add(new Event(
                    Config.SAMPLE_EVENT_IDS.get(i),
                    Config.SAMPLE_EVENT_NAMES.get(i),
                    Config.SAMPLE_EVENT_DATES.get(i),
                    Config.SAMPLE_EVENT_LOCATIONS.get(i)
            ));
        }

        // Initialize the EventController with logged-in user and sample events
        User loggedInUser = new User(
                Config.DEFAULT_USER_ID,
                Config.DEFAULT_NAME,
                Config.DEFAULT_CONTACT_INFO,
                Config.DEFAULT_EMAIL,
                Config.DEFAULT_PHONE,
                Config.DEFAULT_ADDRESS
        );
        EventController controller = new EventController(events, loggedInUser);

        // Initialize the EventView
        EventView eventView = new EventView();

        // Start the application by invoking the main menu
        eventView.showMainMenu(controller);
    }
}

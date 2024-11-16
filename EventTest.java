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

        // Initialize the EventView and EventController
        EventView eventView = new EventView();
        EventController controller = new EventController(events, eventView);

        boolean running = true;

        while (running) {
            eventView.showEventOptions();
            int choice = eventView.getOption();

            switch (choice) {
                case 1: // Register Attendee
                    controller.registerAttendee();
                    break;

                case 2: // Remove Attendee
                    controller.removeAttendee();
                    break;

                case 3: // Display Attendees
                    controller.displayAttendees();
                    break;

                case 4: // Add Event
                    controller.addEvent();
                    break;

                case 5: // Remove Event
                    controller.removeEvent();
                    break;

                case 6: // Display Events
                    controller.displayEvents();
                    break;

                case 7: // Exit
                    running = false;
                    break;

                default:
                    eventView.displayMessage("Invalid option. Please try again.");
            }
        }

        System.out.println("Program ended.");
    }
}

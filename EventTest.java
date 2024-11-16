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
        User loggedInUser = new User(
                Config.DEFAULT_USER_ID,
                Config.DEFAULT_NAME,
                Config.DEFAULT_CONTACT_INFO,
                Config.DEFAULT_EMAIL,
                Config.DEFAULT_PHONE,
                Config.DEFAULT_ADDRESS
        );
        EventController controller = new EventController(events, loggedInUser);

        boolean running = true;

        while (running) {
            eventView.showMainMenu();
            int choice = new java.util.Scanner(System.in).nextInt();

            switch (choice) {
                case 1 -> { // Admin View
                    boolean adminRunning = true;
                    while (adminRunning) {
                        eventView.showAdminOptions();
                        int adminChoice = new java.util.Scanner(System.in).nextInt();
                        switch (adminChoice) {
                            case 1 -> controller.addEvent(eventView.getEventDetails(events.size() + 1));
                            case 2 -> {
                                int eventIndex = eventView.getEventNumber(controller.getEvents());
                                if (controller.removeEvent(eventIndex)) {
                                    eventView.displayMessage("Event removed successfully.");
                                } else {
                                    eventView.displayMessage("Invalid event number.");
                                }
                            }
                            case 3 -> eventView.displayEvents(controller);
                            case 4 -> {
                                int eventIndex = eventView.getEventNumber(controller.getEvents());
                                eventView.displayAttendees(controller.getAttendees(eventIndex));
                            }
                            case 5 -> adminRunning = false; // Exit Admin View
                            default -> eventView.displayMessage("Invalid option. Please try again.");
                        }
                    }
                }
                case 2 -> { // User View
                    boolean userRunning = true;
                    while (userRunning) {
                        eventView.showUserOptions();
                        int userChoice = new java.util.Scanner(System.in).nextInt();
                        switch (userChoice) {
                            case 1 -> {
                                int eventIndex = eventView.getEventNumber(controller.getEvents());
                                if (controller.registerAttendee(eventIndex)) {
                                    eventView.displayMessage("Successfully registered for the event.");
                                } else {
                                    eventView.displayMessage("Already registered or invalid event.");
                                }
                            }
                            case 2 -> {
                                int eventIndex = eventView.getEventNumber(controller.getEvents());
                                if (controller.removeAttendee(eventIndex)) {
                                    eventView.displayMessage("Successfully removed from the event.");
                                } else {
                                    eventView.displayMessage("You are not registered or invalid event.");
                                }
                            }
                            case 3 -> eventView.displayEvents(controller);
                            case 4 -> userRunning = false; // Exit User View
                            default -> eventView.displayMessage("Invalid option. Please try again.");
                        }
                    }
                }
                case 3 -> running = false; // Exit Program
                default -> eventView.displayMessage("Invalid option. Please try again.");
            }
        }

        eventView.displayMessage("Program ended.");
    }
}

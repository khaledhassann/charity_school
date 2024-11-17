import java.util.List;

public class EventView {

    // Display all events
    public void displayEvents(EventController controller) {
        List<Event> events = controller.getEvents();

        if (events.isEmpty()) {
            System.out.println("No events available.");
        } else {
            System.out.println("\nAvailable Events:");
            for (Event event : events) {
                System.out.println(
                        "- " + event.getEventName() + " on " + event.getEventDate() + " at " + event.getLocation());
            }
        }
    }

    // Display attendees
    public void displayAttendees(List<User> attendees) {
        if (attendees == null || attendees.isEmpty()) {
            System.out.println("No attendees registered for this event.");
        } else {
            System.out.println("Attendees:");
            for (User user : attendees) {
                System.out.println("- " + user.getName() + " (" + user.getEmail() + ")");
            }
        }
    }

    // Main menu options
    public void showMainMenu() {
        System.out.println("\nSelect View:");
        System.out.println("1. Admin View");
        System.out.println("2. User View");
        System.out.println("3. Exit");
    }

    // Admin options
    public void showAdminOptions() {
        System.out.println("\nAdmin Options:");
        System.out.println("1. Add Event");
        System.out.println("2. Remove Event");
        System.out.println("3. Display Events");
        System.out.println("4. Display Attendees");
        System.out.println("5. Exit to Main Menu");
    }

    // User options
    public void showUserOptions() {
        System.out.println("\nUser Options:");
        System.out.println("1. Register for an Event");
        System.out.println("2. Remove Registration from an Event");
        System.out.println("3. Display Events");
        System.out.println("4. Exit to Main Menu");
    }

    // Generic message display
    public void displayMessage(String message) {
        System.out.println(message);
    }

    // Prompt for event details
    public Event getEventDetails(int eventId) {
        System.out.print("Enter event name: ");
        String name = new java.util.Scanner(System.in).nextLine();
        System.out.print("Enter event date (YYYY-MM-DD): ");
        String date = new java.util.Scanner(System.in).nextLine();
        System.out.print("Enter event location: ");
        String location = new java.util.Scanner(System.in).nextLine();
        return new Event(eventId, name, date, location);
    }

    // Prompt for event selection
    public int getEventNumber(List<Event> events) {
        System.out.println("\nAvailable Events:");
        for (int i = 0; i < events.size(); i++) {
            System.out.println((i + 1) + ". " + events.get(i).getEventName());
        }
        System.out.print("Enter event number: ");
        return new java.util.Scanner(System.in).nextInt() - 1; // Zero-based index
    }
}
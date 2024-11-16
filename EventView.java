import java.util.List;
import java.util.Scanner;

public class EventView {
    private final Scanner scanner;

    // Constructor
    public EventView() {
        this.scanner = new Scanner(System.in);
    }

    // Display event options
    public void showEventOptions() {
        System.out.println("\nEvent Management Options:");
        System.out.println("1. Register Attendee");
        System.out.println("2. Remove Attendee");
        System.out.println("3. Display Attendees");
        System.out.println("4. Add Event");
        System.out.println("5. Remove Event");
        System.out.println("6. Display Events");
        System.out.println("7. Exit");
    }

    // Prompt user to choose an option
    public int getOption() {
        System.out.print("Choose an option: ");
        return scanner.nextInt();
    }

    // Prompt user to select an event
    public int getEventNumber(List<Event> events) {
        System.out.println("\nAvailable Events:");
        for (int i = 0; i < events.size(); i++) {
            System.out.println((i + 1) + ". " + events.get(i).getEventName());
        }
        System.out.print("Enter event number: ");
        return scanner.nextInt();
    }

    // Prompt for attendee details
    public User getAttendeeDetails() {
        scanner.nextLine(); // Consume newline
        System.out.print("Enter attendee name: ");
        String name = scanner.nextLine();
        System.out.print("Enter attendee email: ");
        String email = scanner.nextLine();
        System.out.print("Enter attendee phone: ");
        String phone = scanner.nextLine();
        return new User("U" + (int) (Math.random() * 1000), name, "N/A", email, phone, "N/A");
    }

    // Prompt for event details
    public Event getEventDetails(int eventId) {
        scanner.nextLine(); // Consume newline
        System.out.print("Enter event name: ");
        String name = scanner.nextLine();
        System.out.print("Enter event date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        System.out.print("Enter event location: ");
        String location = scanner.nextLine();
        return new Event(eventId, name, date, location);
    }

    // Display attendees
    public void displayAttendees(List<User> attendees) {
        if (attendees.isEmpty()) {
            System.out.println("No attendees registered for this event.");
        } else {
            System.out.println("Attendees:");
            for (User user : attendees) {
                System.out.println("- " + user.getName() + " (" + user.getEmail() + ")");
            }
        }
    }

    // Display all events
    public void displayEvents(List<Event> events) {
        if (events.isEmpty()) {
            System.out.println("No events available.");
        } else {
            System.out.println("\nAvailable Events:");
            for (Event event : events) {
                System.out.println("- " + event.getEventName() + " on " + event.getEventDate() + " at " + event.getLocation());
            }
        }
    }

    // Display a generic message
    public void displayMessage(String message) {
        System.out.println(message);
    }
}

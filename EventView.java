import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EventView {
    private final Scanner scanner = new Scanner(System.in);
    private EventController controller; // Reference to EventController

    // Empty constructor
    public EventView() {
        List<Event> events = new ArrayList<>();
        events.add(new Event(1, "Charity workshop", "2024-12-10", "Community hall"));
        this.controller = new EventController(events, config.EXAMPLE_STUDENT);
    }

    // Setter for the controller
    public void setController(EventController controller) {
        this.controller = controller;
    }

    // Main menu options
    public void showMainMenu() {
        boolean running = true;

        while (running) {
            System.out.println("\nSelect View:");
            System.out.println("1. Admin View");
            System.out.println("2. User View");
            System.out.println("3. Exit");

            int choice = getOption();

            switch (choice) {
                case 1:
                    showAdminOptions();
                    break;
                case 2:
                    showUserOptions();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    displayMessage("Invalid option. Please try again.");
            }
        }

        displayMessage("Program ended.");
    }

    // Admin options
    public void showAdminOptions() {
        boolean adminRunning = true;

        while (adminRunning) {
            System.out.println("\nAdmin Options:");
            System.out.println("1. Add Event");
            System.out.println("2. Remove Event");
            System.out.println("3. Display Events");
            System.out.println("4. Display Attendees");
            System.out.println("5. Exit to Main Menu");

            int adminChoice = getOption();

            switch (adminChoice) {
                case 1:
                    Event event = getEventDetails(controller.getEvents().size() + 1); // Prompt for event details
                    controller.addEvent(event); // Add event via controller
                    displayMessage("Event added successfully.");
                    break;
                case 2:
                    int eventIndex = getEventNumber(controller.getEvents());
                    if (controller.removeEvent(eventIndex)) {
                        displayMessage("Event removed successfully.");
                    } else {
                        displayMessage("Invalid event number.");
                    }
                    break;
                case 3:
                    displayEvents(controller.getEvents());
                    break;
                case 4:
                    int eventIndex1 = getEventNumber(controller.getEvents());
                    displayAttendees(controller.getAttendees(eventIndex1));
                    break;
                case 5:
                    adminRunning = false;
                    break;
                default:
                    displayMessage("Invalid option. Please try again.");
            }
        }
    }

    // User options
    public void showUserOptions() {
        boolean userRunning = true;

        while (userRunning) {
            System.out.println("\nUser Options:");
            System.out.println("1. Register for an Event");
            System.out.println("2. Remove Registration from an Event");
            System.out.println("3. Display Events");
            System.out.println("4. Exit to Main Menu");

            int userChoice = getOption();

            switch (userChoice) {
                case 1:
                    int eventIndex = getEventNumber(controller.getEvents());
                    if (controller.registerAttendee(eventIndex)) {
                        displayMessage("Successfully registered for the event.");
                    } else {
                        displayMessage("Already registered or invalid event.");
                    }
                    break;
                case 2:
                    eventIndex = getEventNumber(controller.getEvents());
                    if (controller.removeAttendee(eventIndex)) {
                        displayMessage("Successfully removed from the event.");
                    } else {
                        displayMessage("You are not registered or invalid event.");
                    }
                    break;
                case 3:
                    displayEvents(controller.getEvents());
                    break;
                case 4:
                    userRunning = false;
                    break;
                default:
                    displayMessage("Invalid option. Please try again.");
            }
        }
    }

    // Helper methods
    private int getOption() {
        System.out.print("Choose an option: ");
        return scanner.nextInt();
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

    // Prompt for event selection
    public int getEventNumber(List<Event> events) {
        System.out.println("\nAvailable Events:");
        for (int i = 0; i < events.size(); i++) {
            System.out.println((i + 1) + ". " + events.get(i).getEventName());
        }
        System.out.print("Enter event number: ");
        return scanner.nextInt() - 1; // Zero-based index
    }

    // Display all events
    public void displayEvents(List<Event> events) {
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

    // Generic message display
    public void displayMessage(String message) {
        System.out.println(message);
    }
}
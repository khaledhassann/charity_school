import java.util.List;

public class EventController {
    private List<Event> events;
    private EventView view;

    // Constructor
    public EventController(List<Event> events, EventView view) {
        this.events = events;
        this.view = view;
    }

    // Register an attendee for an event
    public void registerAttendee() {
        int eventNumber = view.getEventNumber(events);

        if (eventNumber > 0 && eventNumber <= events.size()) {
            Event selectedEvent = events.get(eventNumber - 1);
            User attendee = view.getAttendeeDetails();

            if (selectedEvent.registerAttendee(attendee)) {
                view.displayMessage("Successfully registered " + attendee.getName() + " for the event: " + selectedEvent.getEventName());
            } else {
                view.displayMessage("User is already registered for this event.");
            }
        } else {
            view.displayMessage("Invalid event number. Please try again.");
        }
    }

    // Remove an attendee from an event
    public void removeAttendee() {
        int eventNumber = view.getEventNumber(events);

        if (eventNumber > 0 && eventNumber <= events.size()) {
            Event selectedEvent = events.get(eventNumber - 1);
            User attendee = view.getAttendeeDetails();

            if (selectedEvent.removeAttendee(attendee)) {
                view.displayMessage("Successfully removed " + attendee.getName() + " from the event: " + selectedEvent.getEventName());
            } else {
                view.displayMessage("User is not registered for this event.");
            }
        } else {
            view.displayMessage("Invalid event number. Please try again.");
        }
    }

    // Display attendees of an event
    public void displayAttendees() {
        int eventNumber = view.getEventNumber(events);

        if (eventNumber > 0 && eventNumber <= events.size()) {
            Event selectedEvent = events.get(eventNumber - 1);
            view.displayAttendees(selectedEvent.displayAttendees());
        } else {
            view.displayMessage("Invalid event number. Please try again.");
        }
    }

    // Add a new event
    public void addEvent() {
        Event newEvent = view.getEventDetails(events.size() + 1);
        events.add(newEvent);
        view.displayMessage("Event added successfully: " + newEvent.getEventName());
    }

    // Remove an event
    public void removeEvent() {
        int eventNumber = view.getEventNumber(events);

        if (eventNumber > 0 && eventNumber <= events.size()) {
            Event removedEvent = events.remove(eventNumber - 1);
            view.displayMessage("Successfully removed event: " + removedEvent.getEventName());
        } else {
            view.displayMessage("Invalid event number. Please try again.");
        }
    }

    // Display all events
    public void displayEvents() {
        view.displayEvents(events);
    }
}

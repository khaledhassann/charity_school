import java.util.List;

public class EventController {
    private List<Event> events;
    private User loggedInUser;

    // Constructor
    public EventController(List<Event> events, User loggedInUser) {
        this.events = events;
        this.loggedInUser = loggedInUser;
    }

    // Admin functionalities
    public void addEvent(Event event) {
        events.add(event);
    }

    public boolean removeEvent(int eventIndex) {
        if (eventIndex >= 0 && eventIndex < events.size()) {
            events.remove(eventIndex);
            return true;
        }
        return false;
    }

    public List<Event> getEvents() {
        return events;
    }

    public List<User> getAttendees(int eventIndex) {
        if (eventIndex >= 0 && eventIndex < events.size()) {
            return events.get(eventIndex).displayAttendees();
        }
        return null;
    }

    // User functionalities
    public boolean registerAttendee(int eventIndex) {
        if (eventIndex >= 0 && eventIndex < events.size()) {
            Event selectedEvent = events.get(eventIndex);
            return selectedEvent.registerAttendee(loggedInUser);
        }
        return false;
    }

    public boolean removeAttendee(int eventIndex) {
        if (eventIndex >= 0 && eventIndex < events.size()) {
            Event selectedEvent = events.get(eventIndex);
            return selectedEvent.removeAttendee(loggedInUser);
        }
        return false;
    }
}
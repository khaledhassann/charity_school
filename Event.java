import java.util.ArrayList;
import java.util.List;

public class Event {
    private int eventId;
    private String eventName;
    private String eventDate;
    private String location;
    private List<User> attendees;

    // Constructor
    public Event(int eventId, String eventName, String eventDate, String location) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.location = location;
        this.attendees = new ArrayList<>();
    }

    // Getters
    public int getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public String getLocation() {
        return location;
    }

    // Register attendee
    public boolean registerAttendee(User user) {
        if (!attendees.contains(user)) {
            attendees.add(user);
            return true;
        }
        return false;
    }

    // Remove attendee
    public boolean removeAttendee(User user) {
        return attendees.remove(user);
    }

    // Display attendees
    public List<User> displayAttendees() {
        return new ArrayList<>(attendees);
    }

    public List<User> getAttendees() {
        return attendees;
    }
}
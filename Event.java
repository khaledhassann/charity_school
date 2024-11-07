import java.sql.Date;
import java.util.List;

public class Event {
    private String eventName;
    private Date eventDate;
    private String eventLocation;
    private List<User> attendees;

    // SETTERS AND GETTERS
    public Date getEventDate() {
        return eventDate;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public String getEventName() {
        return eventName;
    }

    public List<User> getAttendees() {
        return attendees;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setAttendees(List<User> attendees) {
        this.attendees = attendees;
    }

    // CLASS METHODS
    public boolean registerAttendee(User user) {
        return true;
    }

    public boolean trackAttendance(User attendee) {
        return true;
    }

    public void sendReminder(Event event, User attendee) {
        // TODO: implement reminder sending logic
    }

}

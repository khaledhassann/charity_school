import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventOrganizerStudent extends StudentDecorator {
    private final List<String> eventsOrganized;

    public EventOrganizerStudent(Student decoratorStudent) {
        super(decoratorStudent);
        this.eventsOrganized = new ArrayList<>();
    }

    public void organizeEvent(String eventName, Date eventDate) {
        eventsOrganized.add(eventName);
        System.out.println(decoratorStudent.getName() + " organized an event: " + eventName + " on " + eventDate);
    }

    public void sendInvitations(String eventName) {
        System.out.println("Invitations sent for event: " + eventName);
    }

    public void trackEventBudget(String eventName, double allocatedBudget) {
        System.out.println("Tracking budget for " + eventName + ". Budget allocated: " + allocatedBudget);
    }

    public void viewPastEvents() {
        System.out.println(decoratorStudent.getName() + " is viewing past events:");
        for (String event : eventsOrganized) {
            System.out.println(" - " + event);
        }
    }

    public void collectFeedback(String eventName, List<String> feedback) {
        System.out.println("Collecting feedback for event: " + eventName);
        for (String fb : feedback) {
            System.out.println("Feedback: " + fb);
        }
    }
}
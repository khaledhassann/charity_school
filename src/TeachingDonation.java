import java.util.List;
import java.util.Map;

public class TeachingDonation implements IDonationStrategy {
    private Schedule schedule;
    private List<Subject> selectedSubjects;

    public TeachingDonation(Schedule schedule, List<Subject> selectedSubjects) {
        this.schedule = schedule;
        this.selectedSubjects = selectedSubjects;
    }

    @Override
    public boolean donate() {
        System.out.println("Creating schedule for teaching donation:");
        Map<String, Integer> createdSchedule = schedule.createSchedule(selectedSubjects);

        System.out.println("Teaching Donation Schedule:");
        for (Map.Entry<String, Integer> entry : createdSchedule.entrySet()) {
            System.out.println("Subject: " + entry.getKey() + " - Time Slot: " + entry.getValue());
        }
        System.out.println("Teaching donation scheduled successfully.");
        return true;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public List<Subject> getSelectedSubjects() {
        return selectedSubjects;
    }
}

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeachingDonation implements IDonationStrategy {
    private List<Subject> selectedSubjects;
    private Map<String, Integer> createdSchedule = new HashMap<>();
    private Schedule schedule;

    public TeachingDonation( List<Subject> selectedSubjects) {
        this.selectedSubjects = selectedSubjects;
    }

    @Override
    public boolean donate() {
        // System.out.println("Creating schedule for teaching donation:");
        // createdSchedule = schedule.createSchedule(selectedSubjects);

        // System.out.println("Teaching Donation Schedule:");
        // for (Map.Entry<String, Integer> entry : createdSchedule.entrySet()) {
        //     System.out.println("Subject: " + entry.getKey() + " - Time Slot: " + entry.getValue());
        // }
        System.out.println("Processing teaching donation for selected subjects:");
        for (Subject subject : selectedSubjects) {
            System.out.println("Subject: " + subject.getName() + " - Time Slot: " + subject.getTimeSlot());
        }
        System.out.println("Teaching donation scheduled successfully.");
        return true;
    }

    // public Schedule getSchedule() {
    //     return schedule;
    // }

    public List<Subject> getSelectedSubjects() {
        return selectedSubjects;
    }
    public Map<String, Integer> getcreatedSchedule(){
        return createdSchedule;
    }
}

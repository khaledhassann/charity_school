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
        if (selectedSubjects == null || selectedSubjects.isEmpty()) {
            System.out.println("No subjects selected for teaching donation.");
            return false;
        }
    
        schedule = new Schedule(selectedSubjects);
        createdSchedule = schedule.createSchedule(selectedSubjects);
        System.out.println("Processing teaching donation for selected subjects:");
        for (Subject subject : selectedSubjects) {
            System.out.println("Subject: " + subject.getName() + " - Time Slot: " + subject.getTimeSlot());
        }
        System.out.println("Teaching donation scheduled successfully.");
        return true;
    }

    public List<Subject> getSelectedSubjects() {
        return selectedSubjects;
    }
    public Map<String, Integer> getcreatedSchedule(){
        return createdSchedule;
    }
}

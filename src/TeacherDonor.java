import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TeacherDonor extends Donor {
    private List<Subject> selectedSubjects = new ArrayList<>();
    private Schedule schedule;
   

    public TeacherDonor(String contactInfo, String name, School school) {
        super(contactInfo, name, null,school); // No strategy initially
    }

    public void viewAvailableSubjects() {
        List<Subject> subjects = school.getAvailableSubjects();
        if (subjects.isEmpty()) {
            System.out.println("No subjects available for teaching.");
            return;
        }
        System.out.println("Available Subjects:");
        for (Subject subject : subjects) {
            System.out.println("Subject: " + subject.getName() + ", Time Slot: " + subject.getTimeSlot());
        }
    }
    
    public void addSubject(Subject subject) {
        selectedSubjects.add(subject);
        System.out.println("Added subject: " + subject.getName());
    }

    public void viewSchedule() {
        if (donationStrategy instanceof TeachingDonation && this.didDonate) {
            if(selectedSubjects != null){
            schedule = new Schedule(selectedSubjects);
            Map<String, Integer> createdSchedule = schedule.createSchedule(selectedSubjects);

            System.out.println("Teaching Donation Schedule:");
            for (Map.Entry<String, Integer> entry : createdSchedule.entrySet()) {
                System.out.println("Subject: " + entry.getKey() + " - Time Slot: " + entry.getValue());
            }}
        } else {
            System.out.println("No teaching schedule available for this donation type.");
        }
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public List<Subject> getSelectedSubjects() {
        return selectedSubjects;
    }

    public void setSelectedSubjects(List<Subject> selectedSubjects) {
        this.selectedSubjects = selectedSubjects;
    }

}

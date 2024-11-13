import java.util.List;
import java.util.Map;

public class TeacherDonor extends Donor {
    private IDonationStrategy donationStrategy;
    private School school;
    private Schedule schedule;

    public TeacherDonor(String contactInfo, String name, TeachingDonation donationStrategy) {
        super(contactInfo, name, donationStrategy);
    }

    public void viewAvailableSubjects(School school) {
        List<Subject> subjects = school.getAvailableSubjects();
        System.out.println("Available Subjects:");
        for (Subject subject : subjects) {
            System.out.println("Subject: " + subject.getName() + ", Time Slot: " + subject.getTimeSlot());
        }
    }

    public void viewSchedule() {
        if (donationStrategy instanceof TeachingDonation) {
            TeachingDonation teachingDonation = (TeachingDonation) donationStrategy;
            Map<String, Integer> schedule = teachingDonation.getSchedule().scheduleSubjects(teachingDonation.getSelectedSubjects());
            System.out.println("Your Teaching Donation Schedule:");
            for (Map.Entry<String, Integer> entry : schedule.entrySet()) {
                System.out.println("Subject: " + entry.getKey() + " - Time Slot: " + entry.getValue());
            }
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

}

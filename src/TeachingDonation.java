import java.util.List;
import java.util.Map;

public class TeacherDonor extends Donor {

    private School school;

    public TeacherDonor(String contactInfo, String name, TeachingDonation donationStrategy, School school) {
        super(contactInfo, name, donationStrategy);
        this.school = school;
    }

    public void viewAvailableSubjects() {
        List<Subject> subjects = school.getAllSubjects();
        System.out.println("Available Subjects:");
        for (Subject subject : subjects) {
            System.out.println("Subject: " + subject.getName() + ", Time Slot: " + subject.getTimeSlot());
        }
    }

    public void viewSchedule() {
        if (getDonationStrategy() instanceof TeachingDonation) {
            TeachingDonation teachingDonation = (TeachingDonation) getDonationStrategy();
            Map<String, Integer> schedule = teachingDonation.getSchedule().createSchedule(teachingDonation.getSelectedSubjects());
            System.out.println("Your Teaching Donation Schedule:");
            for (Map.Entry<String, Integer> entry : schedule.entrySet()) {
                System.out.println("Subject: " + entry.getKey() + " - Time Slot: " + entry.getValue());
            }
        } else {
            System.out.println("No teaching schedule available for this donation type.");
        }
    }
}

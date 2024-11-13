import java.util.List;
import java.util.Map;

public class TeacherDonor extends Donor {
    private IDonationStrategy donationStrategy;
    private School school;

    public TeacherDonor(){
        super(getContactInfo(), getName());
    }

    public void viewAvailableSubjects(School school) {
        List<Subject> subjects = school.getAllSubjects();
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

    public boolean donate(){
        return donationStrategy.donate();
    }

    public IDonationStrategy getDonationStrategy() {
        return donationStrategy;
    }

    public void setDonationStrategy(IDonationStrategy donationStrategy) {
        this.donationStrategy = donationStrategy;
    }
}

public class TeachingDonation implements IDonationStrategy {
    private TimeSlot timeSlot;
    private Subject subject;
    private Schedule schedule;

    public TeachingDonation(TimeSlot timeSlot, Subject subject,Schedule schedule) {
        this.timeSlot = timeSlot;
        this.subject = subject;
        this.schedule = schedule;
    }

    @Override
    public boolean donate() {
        if (timeSlot.isAvailable()) {
            schedule.assignSlot(timeSlot);
            System.out.println("Teaching " + subject.getName() + " in time slot " + timeSlot.getDate() + " " + timeSlot.getTime());
            return true;
        }
        System.out.println("Failed to assign teaching time slot.");
        return false;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
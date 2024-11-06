public class Main {
    public static void main(String[] args) {
        // Monetary Donation
        Donor donor = new Donor("lailaihab@gmail.com", "Laila");
        donor.setDonationStrategy(new MoneyDonation(100.0, "Credit Card"));
        donor.donate();

        // Teaching Donation
        Subject subject = new Subject("Math");
        TimeSlot timeSlot = new TimeSlot("2024-11-10", "10:00 AM", subject);
        
        Schedule schedule = new Schedule();
        schedule.addAvailableSlot(timeSlot); 
        donor.setDonationStrategy(new TeachingDonation(timeSlot, subject, schedule));
        donor.donate();
    }
}
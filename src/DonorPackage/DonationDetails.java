package DonorPackage;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DonationDetails {
    private int donationID;
    private Float donationAmount; // Nullable for teaching donations
    private String paymentStrategy; // Nullable for teaching donations
    private List<Subject> selectedSubjects; // Nullable for monetary donations
    private Date date;
    private String school;

    public DonationDetails(int donationID, Float donationAmount, String paymentStrategy, List<Subject> selectedSubjects, Date date, String school) {
        this.donationID = donationID;
        this.donationAmount = donationAmount;
        this.paymentStrategy = paymentStrategy;
        this.selectedSubjects = selectedSubjects;
        this.date = date;
        this.school = school;
    }

    public Map<String, String> getDonationDetails() {
        Map<String, String> details = new HashMap<>();
        details.put("Donation ID", String.valueOf(donationID));
        details.put("Date", date.toString());
        details.put("School", school);

        if (donationAmount != null) {
            details.put("Donation Amount", String.valueOf(donationAmount));
            details.put("Payment Strategy", paymentStrategy);
        } else if (selectedSubjects != null) {
            details.put("SelectedSubjects", selectedSubjects.toString());
        }

        return details;
    }

    public int getDonationID() {
        return donationID;
    }

    public void setDonationID(int donationID) {
        this.donationID = donationID;
    }

    public Float getDonationAmount() {
        return donationAmount;
    }

    public void setDonationAmount(Float donationAmount) {
        this.donationAmount = donationAmount;
    }

    public String getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setPaymentStrategy(String paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public List<Subject> getSelectedSubjects() {
        return selectedSubjects;
    }

    public void setSelectedSubjects(List<Subject> selectedSubjects) {
        this.selectedSubjects = selectedSubjects;
    }
}

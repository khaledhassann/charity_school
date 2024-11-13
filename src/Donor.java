import java.util.ArrayList;
import java.util.List;

public abstract class Donor {

    private IDonationStrategy donationStrategy;
    private String name;
    private String contactInfo;
    private static List<Donor> donors = new ArrayList<>();

    public Donor(String contactInfo, String name, IDonationStrategy donationStrategy) {
        this.contactInfo = contactInfo;
        this.name = name;
        this.donationStrategy = donationStrategy;
    }

    public String getDetails() {
        return "Name: " + name + ", Contact Info: " + contactInfo;
    }

    public boolean donate() {
        if (donationStrategy != null) {
            return donationStrategy.donate();
        }
        System.out.println("No donation strategy set for " + name);
        return false;
    }

    public IDonationStrategy getDonationStrategy() {
        return donationStrategy;
    }

    public void setDonationStrategy(IDonationStrategy donationStrategy) {
        this.donationStrategy = donationStrategy;
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public static void addDonor(Donor donor) {
        donors.add(donor);
    }

    public static void deleteDonor(Donor donor) {
        donors.remove(donor);
    }

    public static List<Donor> getAllDonors() {
        return donors;
    }
}

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Donor {

    protected IDonationStrategy donationStrategy;
    protected String name;
    protected  String contactInfo;
    protected School school;
    private static List<Donor> donors = new ArrayList<>();
    protected  boolean didDonate;
    protected List<DonationDetails> donationHistory = new ArrayList<>();
    
        public Donor(String contactInfo, String name, IDonationStrategy donationStrategy,School school) {
            this.contactInfo = contactInfo;
            this.name = name;
            this.donationStrategy = donationStrategy;
            this.didDonate = false;
            this.school=school;
        }
    
        public String getDetails() {
            return "Name: " + name + ", Contact Info: " + contactInfo;
        }
    
        public boolean donate() {
            if (donationStrategy != null) {
                DonationDetails donationDetails = null;
    
                if (donationStrategy instanceof MoneyDonation) {
                    MoneyDonation moneyDonation = (MoneyDonation) donationStrategy;
                    donationDetails = new DonationDetails(
                        donationHistory.size() + 1,
                        (float) moneyDonation.getAmount(),
                        moneyDonation.getPaymentMethod(),
                        null,
                        new Date(),
                        school.getName()
                    );
                } else if (donationStrategy instanceof TeachingDonation) {
                    TeachingDonation teachingDonation = (TeachingDonation) donationStrategy;
                    donationDetails = new DonationDetails(
                        donationHistory.size() + 1,
                        null,
                        null,
                        teachingDonation.getSelectedSubjects(),
                        new Date(),
                        school.getName()
                    );
                }
    
                if (donationDetails != null) {
                    donationHistory.add(donationDetails);
                    return donationStrategy.donate();
                }
            }
            System.out.println("No donation strategy set for " + name);
            return false;
        }
    
        public IDonationStrategy getDonationStrategy() {
            return donationStrategy;
        }
    
    
        // public boolean login(String username, String pass){
        //     LoginContext loginContext = new LoginContext(new DonorLoginStrategy());
        //     return loginContext.executeLogin("userName", "passWord");
            
        // }
    
        
        public void setDonationStrategy(IDonationStrategy donationStrategy) {
            this.donationStrategy = donationStrategy;
        }
    
        public String getName() {
            return name;
        }
    
        public  String getContactInfo() {
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

    public void setName(String name) {
        this.name = name;
    }

    public List<DonationDetails> getDonationHistory() {
        return donationHistory;
    }

    public void setDonationHistory(List<DonationDetails> donationHistory) {
        this.donationHistory = donationHistory;
    }
}

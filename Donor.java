public class Donor {

    private IDonationStrategy donationStrategy;
    private String name;
    private String contactInfo;


    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public Donor(String contactInfo, String name) {
        this.contactInfo = contactInfo;
        // this.donationStrategy = donationStrategy;
        this.name = name;
    }

    public String getDetails() {
        return "Name: " + name + ", Contact Info: " + contactInfo;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
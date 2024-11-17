public class MonetaryDonor extends Donor {

    // public MonetaryDonor(String contactInfo, String name, MoneyDonation donationStrategy, School school) {
    //     super(contactInfo, name, donationStrategy, school);
    // }
    public MonetaryDonor(String contactInfo, String name, School school) {
        super(contactInfo, name, null, school);
    }
}

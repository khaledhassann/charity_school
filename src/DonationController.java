import java.util.List;

public class DonationController {

    private Donor donor;

    public DonationController(Donor donor) {
        this.donor = donor;
    }


    public void getDonorHistory(Donor donor) {
        List<DonationDetails> history = donor.getDonationHistory();
    }

    public boolean addDonor(Donor donor) {
        Donor.addDonor(donor);
        return true;
    }

    public boolean deleteDonor(Donor donor) {
        if (Donor.getAllDonors().contains(donor)) {
            Donor.deleteDonor(donor);
            return true;
        } else {
            return false;
        }
    }

    public double getTotalDonations(Donor donor) {
        int totalDonations = donor.getDonationHistory().size();
        return totalDonations;
    }
}

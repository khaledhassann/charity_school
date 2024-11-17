
public class Donor extends User implements Observer {
    private String userID;
    private String name;
    private String email;
    private String phone;
    private String address;
    private boolean beneficiaryStatus;

    public Donor(String userID, String name, String email, String phone, String address,
            boolean beneficiaryStatus) {
        super(userID, name, email, beneficiaryStatus);
    }

    @Override
    public void update(double donationAmount) {

    }

    // SETTERS AND GETTERS
    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return super.getName();
    }

    @Override
    public String getUserID() {
        // TODO Auto-generated method stub
        return super.getUserID();
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBeneficiaryStatus(boolean beneficiaryStatus) {
        this.beneficiaryStatus = beneficiaryStatus;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

}

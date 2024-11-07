public class User {
    private String userID;
    private String name;
    private String contactInfo;
    private String email;
    private String phone;
    private String address;
    private boolean beneficiaryStatus;

    public User(String userID, String name, String contactInfo, String email, String phone, String address,
            boolean beneficiaryStatus) {
        this.userID = userID;
        this.name = name;
        this.contactInfo = contactInfo;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.beneficiaryStatus = beneficiaryStatus;
    }
}

public abstract class User {
    private String userID;
    private String name;
    private String email;
    private boolean beneficiaryStatus;

    public User(String userID, String name, String email,
            boolean beneficiaryStatus) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.beneficiaryStatus = beneficiaryStatus;
    }

    public String getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public boolean getBeneficiaryStatus() {
        return beneficiaryStatus;
    }
}

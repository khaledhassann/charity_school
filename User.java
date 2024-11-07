import java.util.HashMap;
import java.util.Map;

public class User {
    protected String userID;
    protected String name;
    protected String contactInfo;
    protected String email;
    protected String phone;
    protected String address;
    protected boolean beneficiaryStatus;

    // Constructor
    public User(String userID, String name, String contactInfo, String email,
                String phone, String address) {
        this.userID = userID;
        this.name = name;
        this.contactInfo = contactInfo;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }
    // Getter and Setter methods for User class attributes
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }





}

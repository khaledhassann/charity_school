
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Student extends User {
    private Schedule schedule;
    private String dateOfBirth;
    private String nationality;
    private String major;
    private Date enrollmentYear;
    private List<Donor> donors;
    private List<Subject> subjects;

    public Student(String userID, String name, String contactInfo, String email,
                   String phone, String address, boolean beneficiaryStatus,
                   String dateOfBirth, String nationality, String major, Date enrollmentYear,
                   List<Donor> donors, List<Subject> subjects) {
        super(userID, name, contactInfo, email, phone, address, beneficiaryStatus);
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
        this.major = major;
        this.enrollmentYear = enrollmentYear;
        this.donors = (donors != null) ? donors : new ArrayList<>();
        this.subjects = (subjects != null) ? subjects : new ArrayList<>();
    }


    public abstract void register();
    public abstract void viewProfile();


    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Date getEnrollmentYear() {
        return enrollmentYear;
    }

    public void setEnrollmentYear(Date enrollmentYear) {
        this.enrollmentYear = enrollmentYear;
    }

    public List<Donor> getDonors() {
        return donors;
    }

    public void setDonors(List<Donor> donors) {
        this.donors = donors;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
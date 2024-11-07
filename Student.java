
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

    public Student(String name, String email, String password, String dateOfBirth, String nationality,
                   String major, Date enrollmentYear, Schedule schedule, List<Donor> donors, List<Subject> subjects) {
        super(name, email, password);
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
        this.major = major;
        this.enrollmentYear = enrollmentYear;
        this.schedule = schedule;
        this.donors = donors;
        this.subjects = subjects;
    }

    public abstract void register();
    public abstract void viewProfile();



    // Add a subject to the subjects list with null check
    // Method to view donor list
    //public void viewDonors() {
       // System.out.println("Viewing donors...");
        //for (Donor donor : donors) {
          //  System.out.println("Donor: " + donor.getName() + " - Email: " + donor.getEmail());
       // }
   // }

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
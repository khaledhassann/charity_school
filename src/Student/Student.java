package Student;
import java.util.*;

public class Student extends User {
    private Schedule schedule;
    private String dateOfBirth;
    private String nationality;
    private String major;
    private Date enrollmentYear;
    private List<Donor> donors;
    private List<Subject> subjects;

    // Constructor using StudentConfig for defaults
    public Student(String userID, String name, String contactInfo, String email,
                   String phone, String address, boolean beneficiaryStatus,
                   String dateOfBirth, String nationality, String major, Date enrollmentYear,
                   List<Donor> donors, List<Subject> subjects) {
        super(
                userID != null ? userID : StudentConfig.DEFAULT_USER_ID,
                name != null ? name : StudentConfig.DEFAULT_NAME,
                contactInfo != null ? contactInfo : StudentConfig.DEFAULT_CONTACT_INFO,
                email != null ? email : StudentConfig.DEFAULT_EMAIL,
                phone != null ? phone : StudentConfig.DEFAULT_PHONE,
                address != null ? address : StudentConfig.DEFAULT_ADDRESS,
                beneficiaryStatus
        );

        this.dateOfBirth = dateOfBirth != null ? dateOfBirth : StudentConfig.DEFAULT_DATE_OF_BIRTH;
        this.nationality = nationality != null ? nationality : StudentConfig.DEFAULT_NATIONALITY;
        this.major = major != null ? major : StudentConfig.DEFAULT_MAJOR;
        this.enrollmentYear = enrollmentYear != null ? enrollmentYear : StudentConfig.DEFAULT_ENROLLMENT_YEAR;
        this.donors = (donors != null && !donors.isEmpty()) ? donors : new ArrayList<>(StudentConfig.DEFAULT_DONORS);
        this.subjects = (subjects != null && !subjects.isEmpty()) ? subjects : new ArrayList<>(StudentConfig.DEFAULT_SUBJECTS);
    }

    // Method to register the student
    public void register() {
        System.out.println(getName() + " has successfully registered for the semester.");
    }

    // Getter and Setter methods
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

    // Additional utility methods for controller functionality

    // Adds a subject to the student's list of subjects
    public void addSubject(Subject subject) {
        if (subjects == null) {
            subjects = new ArrayList<>();
        }
        subjects.add(subject);
    }

    // Retrieves the subject names and credit hours as a map for easy scheduling
    public Map<String, Integer> getSubjectSchedule() {
        Map<String, Integer> scheduleMap = new HashMap<>();
        for (Subject subject : subjects) {
            Integer timeSlot = subject.getTimeSlot(); // Assuming Subject has a getTimeSlot method
            if (timeSlot != null) {
                scheduleMap.put(subject.getName(), timeSlot); // Map subject names to their time slots
            }
        }
        return scheduleMap;
    }

    public List<Subject> getAvailableSubjects() {
        return new ArrayList<>(StudentConfig.DEFAULT_SUBJECTS);

    }
    public String getUserID() {
        return userID;
    }

}

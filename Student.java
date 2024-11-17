import java.util.*;

public class Student extends User {
    private Schedule schedule;
    private String dateOfBirth;
    private String nationality;
    private String major;
    private int enrollmentYear = -1;
    private List<Donor> donors;
    private List<SubjectModel> subjects;

    // Constructor using StudentConfig for defaults
    public Student(String userID, String name, String email,
            boolean beneficiaryStatus,
            String dateOfBirth, String nationality, String major, int enrollmentYear,
            List<Donor> donors, List<SubjectModel> subjects) {
        super(
                userID != null ? userID : StudentConfig.DEFAULT_USER_ID,
                name != null ? name : StudentConfig.DEFAULT_NAME,
                email != null ? email : StudentConfig.DEFAULT_EMAIL,
                beneficiaryStatus);

        this.dateOfBirth = dateOfBirth != null ? dateOfBirth : StudentConfig.DEFAULT_DATE_OF_BIRTH;
        this.nationality = nationality != null ? nationality : StudentConfig.DEFAULT_NATIONALITY;
        this.major = major != null ? major : StudentConfig.DEFAULT_MAJOR;
        this.enrollmentYear = enrollmentYear != -1 ? enrollmentYear : StudentConfig.DEFAULT_ENROLLMENT_YEAR;
        this.donors = (donors != null && !donors.isEmpty()) ? donors : new ArrayList<>(StudentConfig.DEFAULT_DONORS);
        this.subjects = (subjects != null) ? subjects
                : new ArrayList<>(StudentConfig.DEFAULT_SUBJECTS);
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

    public int getEnrollmentYear() {
        return enrollmentYear;
    }

    public void setEnrollmentYear(int enrollmentYear) {
        this.enrollmentYear = enrollmentYear;
    }

    public List<Donor> getDonors() {
        return donors;
    }

    public void setDonors(List<Donor> donors) {
        this.donors = donors;
    }

    public List<SubjectModel> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectModel> subjects) {
        this.subjects = subjects;
    }

    // Additional utility methods for controller functionality

    // Adds a subject to the student's list of subjects
    public void addSubject(SubjectModel subject) {
        if (subjects == null) {
            subjects = new ArrayList<>();
        }
        subjects.add(subject);
    }

    // Retrieves the subject names and credit hours as a map for easy scheduling
    public Map<String, Integer> getSubjectSchedule() {
        Map<String, Integer> scheduleMap = new HashMap<>();
        for (SubjectModel subject : subjects) {
            Integer timeSlot = subject.getTimeslot(); // Assuming Subject has a getTimeSlot method
            if (timeSlot != null) {
                scheduleMap.put(subject.getSubjectName(), timeSlot); // Map subject names to their time slots
            }
        }
        return scheduleMap;
    }

    public List<SubjectModel> getAvailableSubjects() {
        return subjects;

    }

    public String getUserID() {
        return super.getUserID();
    }

}
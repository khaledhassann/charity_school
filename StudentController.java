import java.util.Date;
import java.util.List;

public class StudentController {
    private Student student;

    // Constructor for initializing with a student object
    public StudentController(Student student) {
        this.student = student;
    }

    // Method to register a student
    public void registerStudent() {
        student.register();
        System.out.println("Student registration completed.");
    }

    // Method to update a student's profile
    public void updateStudentProfile(String name, String email, String phone, String address) {
        student.setName(name);
        student.setEmail(email);
        student.setPhone(phone);
        student.setAddress(address);
        student.updateProfile();
        System.out.println("Student profile updated.");
    }

    // Method to apply for aid
    public void applyForAid() {
        student.applyForAid();
        System.out.println("Aid application submitted.");
    }

    // Method to view all charity events
    public void viewCharityEvents() {
        student.viewCharityEvents();
    }

    // Method to view all donors
    public void viewDonors() {
        student.viewDonors();
    }

    // Method to assign a room
    public void assignRoom(Room room) {
        student.assignRoom(room);
    }

    // Method to add a subject
    public void addSubject(Subject subject) {
        student.addSubject(subject);
    }

    // Getters for accessing student information if needed in the view
    public String getStudentName() {
        return student.getName();
    }

    public int getStudentID() {
        return student.getStudentID();
    }

    public String getEmail() {
        return student.getEmail();
    }

    public String getPhone() {
        return student.getPhone();
    }

    public String getAddress() {
        return student.getAddress();
    }

    public String getDateOfBirth() {
        return student.getDateOfBirth();
    }

    public String getNationality() {
        return student.getNationality();
    }

    public String getMajor() {
        return student.getMajor();
    }

    public Date getEnrollmentYear() {
        return student.getEnrollmentYear();
    }

    public List<Donor> getDonors() {
        return student.getDonors();
    }

    public List<Subject> getSubjects() {
        return student.getSubjects();
    }

    public Room getAssignedRoom() {
        return student.getAssignedRoom();
    }

    // Setters for modifying specific student information through the controller
    public void setStudentID(int studentID) {
        student.setStudentID(studentID);
    }

    public void setStudentName(String name) {
        student.setName(name);
    }

    public void setEmail(String email) {
        student.setEmail(email);
    }

    public void setPhone(String phone) {
        student.setPhone(phone);
    }

    public void setAddress(String address) {
        student.setAddress(address);
    }

    public void setDateOfBirth(String dateOfBirth) {
        student.setDateOfBirth(dateOfBirth);
    }

    public void setNationality(String nationality) {
        student.setNationality(nationality);
    }

    public void setMajor(String major) {
        student.setMajor(major);
    }

    public void setEnrollmentYear(Date enrollmentYear) {
        student.setEnrollmentYear(enrollmentYear);
    }


    public void setDonors(List<Donor> donors) {
        student.setDonors(donors);
    }

    public void setSubjects(List<Subject> subjects) {
        student.setSubjects(subjects);
    }

    public void setAssignedRoom(Room assignedRoom) {
        student.setAssignedRoom(assignedRoom);
    }

}

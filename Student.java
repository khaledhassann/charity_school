import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public abstract class Student {
    // Attributes
    private int studentID;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String dateOfBirth;
    private String nationality;
    private String major;
    private Date enrollmentYear;
    private List<Donor> donors;

    private List<Subject> subjects;
    private Room assignedRoom;

    // Updated Constructor with Donors, Partnerships, and Subjects as Parameters
    public Student(int studentID, String name, String email, String phone, String address,
                   String dateOfBirth, String nationality, String major, Date enrollmentYear,
                   List<Donor> donors,  List<Subject> subjects) {
        this.studentID = studentID;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
        this.major = major;
        this.enrollmentYear = enrollmentYear;
        this.donors = (donors != null) ? donors : new ArrayList<>();
        this.subjects = (subjects != null) ? subjects : new ArrayList<>();
    }

    // Abstract methods
    public abstract void register();
    public abstract void updateProfile();
    public abstract void viewCharityEvents();
    public abstract void applyForAid();
    public abstract void viewProfile();

    // Concrete methods with logic

    // Assign Room with logic to check for existing assignment
    public void assignRoom(Room room) {
        if (assignedRoom != null) {
            System.out.println("Student already has an assigned room: " + assignedRoom.getRoomNumber());
            System.out.println("Reassigning to new room: " + room.getRoomNumber());
        } else {
            System.out.println("Assigning new room: " + room.getRoomNumber());
        }
        this.assignedRoom = room;
    }



    // Add a subject to the subjects list with null check
    public void addSubject(Subject subject) {
        if (subject != null) {
            subjects.add(subject);
            System.out.println("Added subject: " + subject.getSubjectName());
        } else {
            System.out.println("Cannot add a null subject.");
        }
    }

    // Method to view donor list
    public void viewDonors() {
        System.out.println("Viewing donors...");
        for (Donor donor : donors) {
            System.out.println("Donor: " + donor.getName() + " - Email: " + donor.getEmail());
        }
    }

    // Getters and Setters (example for one attribute; add as needed)
    public int getStudentID() {
        return studentID;
    }
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public String getMajor() {
        return major;
    }

    public Date getEnrollmentYear() {
        return enrollmentYear;
    }

    public List<Donor> getDonors() {
        return donors;
    }



    public List<Subject> getSubjects() {
        return subjects;
    }
    public Room getAssignedRoom() {
        return assignedRoom;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setEnrollmentYear(Date enrollmentYear) {
        this.enrollmentYear = enrollmentYear;
    }

    public void setDonors(List<Donor> donors) {
        this.donors = donors != null ? donors : new ArrayList<>();
    }



    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects != null ? subjects : new ArrayList<>();
    }

    public void setAssignedRoom(Room assignedRoom) {
        this.assignedRoom = assignedRoom;
    }


}

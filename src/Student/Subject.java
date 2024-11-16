package Student;
public class Subject {
    private String subjectName;
    private String subjectCode;
    private Integer timeSlot; // New field to represent the time slot

    public Subject(String subjectName, String subjectCode, Integer timeSlot) {
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
        this.timeSlot = timeSlot; // Initialize timeSlot in the constructor
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public String getName() {
        return this.subjectName;
    }

    public String getCode() {
        return this.subjectCode;
    }

    public Integer getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(Integer timeSlot) {
        this.timeSlot = timeSlot;
    }
}

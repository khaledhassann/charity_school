import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    private String code;
    private String name = "Default subject";
    private int credits = 0;
    private List<Assessment> assessments = new ArrayList<>();
    private IGradingBehavior gradeBehavior;
    private IExamBehavior finalExam;
    private int timeslot;
    private List<Student> registeredStudents = new ArrayList<Student>();
    private Donor teacher;

    public String getDetails() {
        return "This is " + this.getCode() + ":" + this.getName() + " with credit hours " + this.getCredits()
                + "\nTeaching method: " + this.getBehavior() + "\nGrading: " + this.getGradeBehavior().defineGrading()
                + "\nFinal Exam: " + this.getFinalExam().defineExamType() + "\nTime Slot: " + this.getTimeslot();
    };

    public abstract String getBehavior();

    public void addAssessment(Assessment assessment) {
        assessments.add(assessment);
    }

    public void removeAssessment(Assessment assessment) {
        // TODO: remove assessment code
        assessments.remove(assessment);
    }

    public void displayAllAssessments() {
        if (assessments.isEmpty()) {
            System.out.println("No assessments available.");
        } else {
            System.out.println("Assessments for " + getName() + ":");
            for (Assessment assessment : assessments) {
                System.out.println(assessment.getDetails());
            }
        }
    }

    public boolean registerStudent(Student student) {
        if (!registeredStudents.contains(student)) {
            registeredStudents.add(student);
            return true;
        } else {
            System.out.println("Student: " + student.getName() + " is already registered!");
            return false;
        }
    }

    // SETTERS AND GETTERS

    public Donor getTeacher() {
        return teacher;
    }

    public List<Student> getRegisteredStudents() {
        return registeredStudents;
    }

    public List<Assessment> getAssessments() {
        return assessments;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public String getCode() {
        return code;
    }

    public IGradingBehavior getGradeBehavior() {
        return gradeBehavior;
    }

    public IExamBehavior getFinalExam() {
        return finalExam;
    }

    public int getTimeslot() {
        return timeslot;
    }

    public void setTeacher(Donor teacher) {
        this.teacher = teacher;
    }

    public void setRegisteredStudents(List<Student> registeredStudents) {
        this.registeredStudents = registeredStudents;
    }

    public void setAssessments(List<Assessment> assessments) {
        this.assessments = assessments;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setGradeBehavior(IGradingBehavior gradeBehavior) {
        this.gradeBehavior = gradeBehavior;
    }

    public void setFinalExam(IExamBehavior finalExam) {
        this.finalExam = finalExam;
    }

    public void setTimeslot(int timeslot) {
        this.timeslot = timeslot;
    }

}

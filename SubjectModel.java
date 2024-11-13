import java.util.ArrayList;
import java.util.List;

public abstract class SubjectModel {
    protected String subjectName;
    protected String subjectCode;
    protected int subjectCredit;
    protected List<Student> students;
    protected String code;
    protected String name = "Default subject";
    protected int credits = 0;
    protected List<Assessment> assessments = new ArrayList<>();
    protected IGradingBehavior gradeBehavior;
    protected IExamBehavior finalExam;
    protected int timeslot;
    protected List<Student> registeredStudents = new ArrayList<Student>();
    protected Donor teacher;

    public SubjectModel(String subjectName, String subjectCode, int subjectCredit) {
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
        this.subjectCredit = subjectCredit;
        this.students = new ArrayList<>();
    }

    public abstract String getBehavior();

    public boolean addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
            return true;
        } else {
            System.out.println("Student: " + student.getName() + " is already registered!");
            return false;
        }
    }

    public boolean removeStudent(Student student) {
        if (!students.contains(student)) {
            System.out.println("Student: " + student.getName() + " is not registered!");
            return false;
        } else {
            students.remove(student);
            return true;
        }
    }

    public boolean addAssessment(Assessment assessment) {
        if (!assessments.contains(assessment)) {
            assessments.add(assessment);
            return true;
        } else {
            System.out.println("Assessment: '" + assessment.getAssessmentName() + "' is already registered!");
            return false;
        }
    }

    public boolean removeAssessment(Assessment assessment) {
        if (!assessments.contains(assessment)) {
            System.out
                    .println("Assessment: '" + assessment.getAssessmentName() + "' is not registered to " + this.name);
            return false;
        } else {
            assessments.remove(assessment);
            return true;
        }
    }

    public String getDetails() {
        return "This is " + this.getCode() + ":" + this.getName() + " with credit hours " + this.getCredits()
                + "\nTeaching method: " + this.getBehavior() + "\nGrading: "
                + this.getGradeBehavior().defineGrading()
                + "\nFinal Exam: " + this.getFinalExam().defineExamType() + "\nTime Slot: " + this.getTimeslot();
    };

    // SETTERS AND GETTERS

    public List<Assessment> getAssessments() {
        return assessments;
    }

    public String getCode() {
        return code;
    }

    public int getCredits() {
        return credits;
    }

    public IExamBehavior getFinalExam() {
        return finalExam;
    }

    public IGradingBehavior getGradeBehavior() {
        return gradeBehavior;
    }

    public String getName() {
        return name;
    }

    public List<Student> getRegisteredStudents() {
        return registeredStudents;
    }

    public Donor getTeacher() {
        return teacher;
    }

    public int getTimeslot() {
        return timeslot;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setAssessments(List<Assessment> assessments) {
        this.assessments = assessments;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setFinalExam(IExamBehavior finalExam) {
        this.finalExam = finalExam;
    }

    public void setGradeBehavior(IGradingBehavior gradeBehavior) {
        this.gradeBehavior = gradeBehavior;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRegisteredStudents(List<Student> registeredStudents) {
        this.registeredStudents = registeredStudents;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void setTeacher(Donor teacher) {
        this.teacher = teacher;
    }

    public void setTimeslot(int timeslot) {
        this.timeslot = timeslot;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public int getSubjectCredit() {
        return subjectCredit;
    }

    public void setSubjectCredit(int subjectCredit) {
        this.subjectCredit = subjectCredit;
    }

    public List<Student> getStudents() {
        return students;
    }
}

import java.util.ArrayList;
import java.util.List;

public class SubjectModel {
    protected String subjectName;
    protected String subjectCode;
    protected int subjectCredit;
    protected List<Student> students;
    // protected String code;
    // protected String name = "Default subject";
    // protected int credits = 0;
    protected List<Assessment> assessments = new ArrayList<>();
    protected IGradingBehavior gradeBehavior;
    protected IExamBehavior finalExam;
    protected int timeslot;
    protected List<Student> registeredStudents = new ArrayList<Student>();
    protected Donor teacher;

    public SubjectModel(String subjectName, String subjectCode, int subjectCredit, IGradingBehavior gradingBehavior,
            IExamBehavior examBehavior, int timeslot, Donor teacher) {
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
        this.subjectCredit = subjectCredit;
        this.gradeBehavior = gradingBehavior;
        this.finalExam = examBehavior;
        this.timeslot = timeslot;
        this.teacher = teacher;
        this.students = new ArrayList<>();
    }

    // public String getBehavior() {
    // return "Default behavior";
    // };

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
                    .println("Assessment: '" + assessment.getAssessmentName() + "' is not registered to "
                            + this.subjectName);
            return false;
        } else {
            assessments.remove(assessment);
            return true;
        }
    }

    public void displayAllAssessments() {
        if (assessments.isEmpty()) {
            System.out.println("No assessments available.");
        } else {
            System.out.println("Assessments for " + getSubjectName() + ":");
            for (Assessment assessment : assessments) {
                System.out.println(assessment.getDetails());
            }
        }
    }

    public String getDetails() {
        return this.getSubjectCode() + ":" + this.getSubjectName() + " with credit hours "
                + this.getSubjectCredit()
                + "\nGrading: "
                + this.getGradeBehavior().defineGrading()
                + "\nFinal Exam: " + this.getFinalExam().defineExamType() + "\nTime Slot: " + this.getTimeslot();
    };

    // SETTERS AND GETTERS

    public List<Assessment> getAssessments() {
        return assessments;
    }

    public IExamBehavior getFinalExam() {
        return finalExam;
    }

    public IGradingBehavior getGradeBehavior() {
        return gradeBehavior;
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

    public void setFinalExam(IExamBehavior finalExam) {
        this.finalExam = finalExam;
    }

    public void setGradeBehavior(IGradingBehavior gradeBehavior) {
        this.gradeBehavior = gradeBehavior;
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

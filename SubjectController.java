
// SubjectController.java - Controller Component
import java.util.List;

public class SubjectController {
    private SubjectModel model;
    private SubjectView view;

    public SubjectController(SubjectModel model, SubjectView view) {
        this.model = model;
        this.view = view;
    }

    public void addAssessment(Assessment assessment) {
        model.addAssessment(assessment);
    }

    public void addRegisteredStudent(Student student) {
        model.addStudent(student);
    }

    // Existing methods...
    public void updateView() {
        view.printSubjectDetails(model.getSubjectName(), model.getSubjectCode(), model.getSubjectCredit(),
                model.getStudents());
    }

    // Getters and setters for the new fields
    public void setCode(String code) {
        model.setCode(code);
    }

    public String getCode() {
        return model.getCode();
    }

    public void setName(String name) {
        model.setName(name);
    }

    public String getName() {
        return model.getName();
    }

    public void setCredits(int credits) {
        model.setCredits(credits);
    }

    public int getCredits() {
        return model.getCredits();
    }

    public List<Assessment> getAssessments() {
        return model.getAssessments();
    }

    public void setGradeBehavior(IGradingBehavior gradeBehavior) {
        model.setGradeBehavior(gradeBehavior);
    }

    public IGradingBehavior getGradeBehavior() {
        return model.getGradeBehavior();
    }

    public void setFinalExam(IExamBehavior finalExam) {
        model.setFinalExam(finalExam);
    }

    public IExamBehavior getFinalExam() {
        return model.getFinalExam();
    }

    public void setTimeslot(int timeslot) {
        model.setTimeslot(timeslot);
    }

    public int getTimeslot() {
        return model.getTimeslot();
    }

    public List<Student> getRegisteredStudents() {
        return model.getRegisteredStudents();
    }

    public void setTeacher(Donor teacher) {
        model.setTeacher(teacher);
    }

    public Donor getTeacher() {
        return model.getTeacher();
    }

}

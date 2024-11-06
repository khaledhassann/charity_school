import java.util.List;

public abstract class Subject {
    private String name = "Default subject";
    private int credits = 0;
    private List<Assessment> assessments;

    public abstract String getDetails();

    public abstract String getBehavior();

    public void addAssessment(Assessment assessment) {
        // TODO: add assessment code
    }

    public void removeAssessment(Assessment assessment) {
        // TODO: remove assessment code
    }

    // SETTERS AND GETTERS

    public List<Assessment> getAssessments() {
        return assessments;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
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

}

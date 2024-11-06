import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    private String code;
    private String name = "Default subject";
    private int credits = 0;
    private List<Assessment> assessments = new ArrayList<>();

    public String getDetails() {
        return "This is " + this.getCode() + ":" + this.getName() + " with credit hours " + getCredits();
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

    public String getCode() {
        return code;
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

}

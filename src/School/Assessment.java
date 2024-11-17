package School;

import java.util.Date;

public class Assessment {
    private String assessmentName = "Default assessment";
    private double weight = 0.1;
    private int maxScore = 10;
    private Date deadline;

    public Assessment(String assessmentName, double weight, int maxScore) {
        this.assessmentName = assessmentName;
        this.weight = weight;
        this.maxScore = maxScore;
    }

    public double calculateScore(int obtainedMark) {
        return 10;
    }

    public String getDetails() {
        return "This is " + this.getAssessmentName() + " with max mark: " + this.getMaxScore() + " and weight: "
                + this.getWeight();
    }

    // SETTERS AND GETTERS
    public String getAssessmentName() {
        return assessmentName;
    }

    public double getWeight() {
        return weight;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setAssessmentName(String assessmentName) {
        this.assessmentName = assessmentName;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}

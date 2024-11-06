import java.util.Date;

public class Assessment {
    private String assessmentName;
    private double weight;
    private int maxScore;
    private Date deadline;

    public double calculateScore(int obtainedMark) {
        // TODO: Define Assessment calculateScore code
        return 0;
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

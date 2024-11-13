// HistorySubjectModel.java - History Specific Model Component
public class HistorySubjectModel extends SubjectModel {
    public HistorySubjectModel(String subjectName, String subjectCode, int subjectCredit) {
        super(subjectName, subjectCode, subjectCredit);
    }

    @Override
    public String getBehavior() {
        // TODO Define History behavior
        return "History behavior is more about learning from past mistakes and enriching your knowledge";
    }
}
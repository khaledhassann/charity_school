public class MathSubjectModel extends SubjectModel {
    public MathSubjectModel(String subjectName, String subjectCode, int subjectCredit) {
        super(subjectName, subjectCode, subjectCredit);
    }

    @Override
    public String getBehavior() {
        // TODO Define Math behavior
        return "Math behavior is more about solving examples and seeing ahead";
    }
}
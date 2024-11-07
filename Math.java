public class Math extends Subject {
    public Math() {
        setCode("PHM100");
        setName("Mathematics");
        setCredits(4);
        setGradeBehavior(new LetterGrading());
        setFinalExam(new WrittenExam());
        setTimeslot(1);
    }

    @Override
    public String getBehavior() {
        // TODO Define Math behavior
        return "Math behavior is more about solving examples and seeing ahead";
    }
}

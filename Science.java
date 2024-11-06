public class Science extends Subject {

    public Science() {
        setCode("ENRG200");
        setName("Science");
        setCredits(3);
        setGradeBehavior(new LetterGrading());
        setFinalExam(new PracticalExam());
    }

    @Override
    public String getBehavior() {
        // TODO Define Science behavior
        return "Science behavior is more about curiosity and experimentation";
    }

}

public class Math extends Subject {
    public Math() {
        setCode("PHM100");
        setName("Mathematics");
        setCredits(4);
        setGradeBehavior(new LetterGrading());
    }

    @Override
    public String getDetails() {
        // TODO Define Math details
        return "This is " + this.getCode() + ":" + this.getName() + " with credit hours " + getCredits();
    }

    @Override
    public String getBehavior() {
        // TODO Define Math behavior
        return "Math behavior is more about solving examples and seeing ahead";
    }
}

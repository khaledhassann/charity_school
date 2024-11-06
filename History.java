public class History extends Subject {

    public History() {
        setCode("ASU300");
        setName("History");
        setCredits(2);
    }

    @Override
    public String getBehavior() {
        // TODO Define History behavior
        return "History behavior is more about learning from past mistakes and enriching your knowledge";
    }

}

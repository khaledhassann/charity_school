public class ExtraCurricular extends SubjectDecorator {
    Subject subject;

    public ExtraCurricular(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String getDetails() {
        // TODO Define Extra Curricular details
        return subject.getDetails()
                + "\n* This subject contains a large part of extracurricular activities aimed to make you market ready!";
    }

    @Override
    public String getBehavior() {
        // TODO Define Extra Curricular behavior
        return subject.getBehavior() + ", with an added layer of extracurricular activites";
    }

    @Override
    public String getName() {
        return subject.getName(); // Delegate to the wrapped subject (Math)
    }

    @Override
    public String getCode() {
        return subject.getCode(); // Delegate to the wrapped subject (Math)
    }

}

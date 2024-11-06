public class ExtraCurricular extends SubjectDecorator {
    Subject subject;

    public ExtraCurricular(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String getDetails() {
        // TODO Define Extra Curricular details
        throw new UnsupportedOperationException("Unimplemented method 'getDetails'");
    }

    @Override
    public String getBehavior() {
        // TODO Define Extra Curricular behavior
        throw new UnsupportedOperationException("Unimplemented method 'getBehavior'");
    }

}

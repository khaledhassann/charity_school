public class AdvancedModule extends SubjectDecorator {

    Subject subject;

    public AdvancedModule(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String getDetails() {
        // TODO Define Advanced Module details
        throw new UnsupportedOperationException("Unimplemented method 'getDetails'");
    }

    @Override
    public String getBehavior() {
        // TODO Define Advanced Module behavior
        throw new UnsupportedOperationException("Unimplemented method 'getBehavior'");
    }

}

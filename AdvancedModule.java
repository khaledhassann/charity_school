// public class AdvancedModule extends SubjectDecorator {

// Subject subject;

// public AdvancedModule(Subject subject) {
// this.subject = subject;
// }

// @Override
// public String getDetails() {
// return subject.getDetails()
// + "\n* This is an Advanced Module; meaning you need to take it's base module
// first!";
// }

// @Override
// public String getBehavior() {
// return subject.getBehavior() + ", with an added layer of advanced
// techniques.";
// }

// @Override
// public String getName() {
// return subject.getName(); // Delegate to the wrapped subject (Math)
// }

// @Override
// public String getCode() {
// return subject.getCode(); // Delegate to the wrapped subject (Math)
// }

// }

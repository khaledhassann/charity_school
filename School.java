import java.util.List;
import java.util.Optional;

public class School {
    private List<Subject> subjects;

    public School(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public void displaySubjects() {
        for (Subject subject : subjects) {
            System.out.println(subject.getName() + ": " + subject.getCode());
        }
    }

    public Optional<Subject> findSubjectByCode(String code) {
        return this.subjects.stream()
                .filter(subject -> subject.getCode().equals(code))
                .findFirst();
    }

    public void addAssessmentForSubject(String courseCode, Assessment assessment) {
        Optional<Subject> result = findSubjectByCode(courseCode);
        result.ifPresentOrElse(
                subject -> {
                    subject.addAssessment(assessment);
                    System.out.println("Assessment added for subject " + subject.getName());
                },
                () -> System.out.println("Subject with code " + courseCode + " not found"));
    }

    // SETTERS AND GETTERS
    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }
}

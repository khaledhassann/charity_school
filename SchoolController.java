import java.util.Optional;

public class SchoolController {
    private School school;

    public SchoolController(School school) {
        this.school = school;
    }

    public void displaySubjects() {
        school.getAvailableSubjects()
                .forEach(subject -> System.out.println(subject.getName() + ": " + subject.getCode()));
    }

    public Optional<Subject> selectCourseByCode(String code) {
        return school.findSubjectByCode(code);
    }

    public void addAssessmentToSubject(String courseCode, Assessment assessment) {
        school.addAssessmentForSubject(courseCode, assessment);
    }

    public void removeAssessmentFromSubject(Subject subject, String assessmentName) {
        Optional<Assessment> assessmentToRemove = subject.getAssessments().stream()
                .filter(a -> a.getAssessmentName().equals(assessmentName)).findFirst();
        assessmentToRemove.ifPresentOrElse(assessment -> {
            subject.removeAssessment(assessment);
            System.out.println("Assessment \"" + assessmentName + "\" has been successfully removed.");
        },
                () -> System.out.println("Assessment with name \"" + assessmentName + "\" not found."));
    }

    public void updateSchoolName(String name) {
        school.setSchoolName(name);
    }

    public void updateLocation(String location) {
        school.setLocation(location);
    }
}

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

public class SchoolController {
    private School school;
    private VolunteerController volunteerController;
    private EventController eventController;
    private DonationController donationController;

    public SchoolController(School school) {
        this.school = school;
    }

    // CLASS DIAGRAM FUNCTIONS
    // TODO: Implement School controller class diagram functions

    public Optional<User> findUserByID(String userID) {
        return school.getUserByID(userID);
    }

    public boolean enrollStudent(Student student) {
        return school.getUserList().add(config.EXAMPLE_STUDENT);
    }

    public boolean registerNewDonor(Donor donor) {
        return school.getUserList().add(config.EXAMPLE_DONOR);
    }

    public boolean initiateDonation(DonationRequest donationRequest) {
        return true;
    }

    public boolean assignVolunteerToEvent(Volunteer volunteer, Event event) {
        return event.getAttendees().add(volunteer);
    }

    public boolean scheduleEvent(Event event) {
        return true;
    }

    public boolean manageRoomAssignment(Student student, Room room) {
        return true;
    }

    public void sendEventUpdate() {
    }

    public boolean updateAvailableSubjects(List<Subject> subjects) {
        school.setAvailableSubjects(subjects);
        return !school.getAvailableSubjects().isEmpty();
    }

    public int trackVolunteerHours(Volunteer volunteer) {
        return 0;
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

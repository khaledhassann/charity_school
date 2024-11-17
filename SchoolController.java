import java.util.List;
import java.util.Optional;

import Room.Room;

public class SchoolController {
    private SchoolModel schoolModel;

    public SchoolController(SchoolModel school) {
        this.schoolModel = school;
    }

    // CLASS DIAGRAM FUNCTIONS

    public boolean subjectExists(SubjectModel subject) {
        return schoolModel.checkForSubject(subject);
    }

    public Optional<User> findUserByID(String userID) {
        return schoolModel.getUserByID(userID);
    }

    public boolean enrollStudent(Student student) {
        return schoolModel.getUserList().add(config.EXAMPLE_STUDENT);
    }

    public boolean registerNewDonor(Donor donor) {
        return schoolModel.getUserList().add(config.EXAMPLE_DONOR);
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
        // TODO: assign student to room
        return true;
    }

    public boolean updateAvailableSubjects(List<SubjectModel> subjects) {
        schoolModel.setAvailableSubjects(subjects);
        return !schoolModel.getAvailableSubjects().isEmpty();
    }

    public int trackVolunteerHours(Volunteer volunteer) {
        return 0;
    }

    public void displaySubjects() {
        schoolModel.getAvailableSubjects()
                .forEach(subject -> System.out.println(subject.getSubjectName() + ": " + subject.getSubjectCode()));
    }

    public List<SubjectModel> getAllSubjects() {
        return schoolModel.getAvailableSubjects();
    }

    public Optional<SubjectModel> selectCourseByCode(String code) {
        return schoolModel.findSubjectByCode(code);
    }

    public boolean removeSubject(SubjectModel subjectToRemove) {
        return schoolModel.removeSubject(subjectToRemove);
    }

    public void addAssessmentToSubject(String courseCode, Assessment assessment) {
        schoolModel.addAssessmentForSubject(courseCode, assessment);
    }

    public void removeAssessmentFromSubject(SubjectModel subject, String assessmentName) {
        Optional<Assessment> assessmentToRemove = subject.getAssessments().stream()
                .filter(a -> a.getAssessmentName().equals(assessmentName)).findFirst();
        assessmentToRemove.ifPresentOrElse(assessment -> {
            subject.removeAssessment(assessment);
            System.out.println("Assessment \"" + assessmentName + "\" has been successfully removed.");
        },
                () -> System.out.println("Assessment with name \"" + assessmentName + "\" not found."));
    }

    public void updateSchoolName(String name) {
        schoolModel.setSchoolName(name);
    }

    public void updateLocation(String location) {
        schoolModel.setLocation(location);
    }
}

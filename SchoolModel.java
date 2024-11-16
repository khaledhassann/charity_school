import java.util.List;
import java.util.Optional;

public class SchoolModel {
    private String schoolName;
    private String location;
    private List<User> userList;
    private List<Room> rooms; // get them from database not in RAM
    private List<Event> events;
    private List<SubjectModel> availableSubjects;

    public SchoolModel(String schoolName, String location, List<SubjectModel> subjects) {
        this.schoolName = schoolName;
        this.location = location;
        this.availableSubjects = subjects;
        this.userList = config.schoolUsersList;
    }

    // CLASS DIAGRAM FUNCTIONS
    // TODO: Implement School model class diagram functions
    public boolean addUser(User user) {
        return userList.add(user);
    }

    public Optional<User> getUserByID(String userID) {
        // ! DUMMY DATA
        return this.userList.stream().filter(user -> user.getUserID().equals(userID)).findFirst();
    }

    public boolean removeUser(User user) {
        Optional<User> result = getUserByID(user.getUserID());
        result.ifPresentOrElse(foundUser -> {
            userList.remove(user);
            System.out.println("User '" + user.getName() + "' has been removed ✅");
        }, () -> System.out.println("User not found!"));
        return true;
    }

    public boolean addSubject(Subject subject) {
        return true;
    }

    public boolean removeSubject(SubjectModel subject) {
        try {
            availableSubjects.remove(subject);
            return true;
        } catch (Exception e) {
            System.out.println("Failed to remove subject");
            return false;
        }
    }

    public boolean addRoom(Room room) {
        return true;
    }

    public boolean addEvent(Event event) {
        return true;
    }

    public void displaySubjects() {
        for (SubjectModel subject : availableSubjects) {
            System.out.println(subject.getSubjectName() + ": " + subject.getSubjectCode());
        }
    }

    public Optional<SubjectModel> findSubjectByCode(String code) {
        return this.availableSubjects.stream()
                .filter(subject -> subject.getSubjectCode().equals(code))
                .findFirst();
    }

    public boolean checkForSubject(SubjectModel passedSubject) {
        for (SubjectModel subject : availableSubjects) {
            if (subject.getSubjectCode().equals(passedSubject.getSubjectCode())) {
                return true;
            }
        }
        return false;
    }

    public void addAssessmentForSubject(String courseCode, Assessment assessment) {
        Optional<SubjectModel> result = findSubjectByCode(courseCode);
        result.ifPresentOrElse(
                subject -> {
                    subject.addAssessment(assessment);
                    System.out.println("Assessment added for subject " + subject.getSubjectName());
                },
                () -> System.out.println("Subject with code " + courseCode + " not found"));
    }

    // SETTERS AND GETTERS
    public void setAvailableSubjects(List<SubjectModel> subjects) {
        this.availableSubjects = subjects;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<SubjectModel> getAvailableSubjects() {
        return availableSubjects;
    }

    public List<Event> getEvents() {
        return events;
    }

    public String getLocation() {
        return location;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public List<User> getUserList() {
        return userList;
    }
}

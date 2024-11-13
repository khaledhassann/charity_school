import java.util.List;
import java.util.Optional;

public class School {
    private String schoolName;
    private String location;
    private List<User> userList;
    private List<Room> rooms; // get them from database not in RAM
    private List<Event> events;
    private List<Subject> availableSubjects;

    public School(String schoolName, String location, List<Subject> subjects) {
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

    public boolean removeSubject(Subject subject) {
        return true;
    }

    public boolean addRoom(Room room) {
        return true;
    }

    public boolean addEvent(Event event) {
        return true;
    }

    public void displaySubjects() {
        for (Subject subject : availableSubjects) {
            System.out.println(subject.getName() + ": " + subject.getCode());
        }
    }

    public Optional<Subject> findSubjectByCode(String code) {
        return this.availableSubjects.stream()
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
    public void setAvailableSubjects(List<Subject> subjects) {
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

    public List<Subject> getAvailableSubjects() {
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
import java.util.List;

public class School {
    private List<Subject> availableSubjects;
    private String name;

    public String getName() {
        return name;
    }
    public School(List<Subject> availableSubjects,String name) {
        this.availableSubjects = availableSubjects;
        this.name = name;
    }
    public List<Subject> getAvailableSubjects() {
        return availableSubjects;
    }
    public void setAvailableSubjects(List<Subject> availableSubjects) {
        this.availableSubjects = availableSubjects;
    }
    public boolean addSubject(Subject subject) {
        return true;
    }

    public boolean removeSubject(Subject subject) {
        return true;
    }
    public Subject getSubjectByName(String name) {
        for (Subject subject : availableSubjects) {
            if (subject.getName().equalsIgnoreCase(name)) {
                return subject;
            }
        }
        return null; // Return null if no subject is found with the given name
    }

}

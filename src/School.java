import java.util.List;

public class School {
    private List<Subject> availableSubjects;

    public School(List<Subject> availableSubjects) {
        this.availableSubjects = availableSubjects;
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

}

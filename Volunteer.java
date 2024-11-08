import java.util.ArrayList;
import java.util.List;

public class Volunteer extends User {
    private boolean available;
    private List<Task> assignedTasks;
    private int maxAssignments;

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    private float rating;
    private List<String> skills; // Skills of the volunteer

    // List to hold all volunteers
    private static List<Volunteer> volunteers = new ArrayList<>();

    // Constructor
    public Volunteer(String userID, String name, String contactInfo, String email, String phone, String address, boolean available, float rating) {
        super(userID, name, contactInfo, email, phone, address);
        this.available = available;
        this.assignedTasks = new ArrayList<>();
        this.maxAssignments = Config.MAX_VOLUNTEER_ASSIGNMENTS;
        this.rating=rating;
        this.skills = new ArrayList<>();
    }

    // Getter and Setter Methods
    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public List<Task> getAssignedTasks() {
        return assignedTasks;
    }

    public int getMaxAssignments() {
        return maxAssignments;
    }

    public List<String> getSkills() {
        return skills;
    }

    // Assign task if within capacity and meets minimum rating requirement
    public boolean assignTask(Task task) {
        if (assignedTasks.size() < maxAssignments && this.rating >= Config.minRatingRequired) {
            for (String requiredSkill : task.getRequiredSkills()) {
                if (skills.contains(requiredSkill)) {
                    if (task.getAssignedVolunteersCount() < Config.TASK_CAPACITY) {
                        assignedTasks.add(task);
                        task.assignVolunteer(this);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // Add skill to volunteer
    public void addSkill(String skill) {
        skills.add(skill);
    }

    // Static methods to manage the volunteer list
    public static void addVolunteer(Volunteer volunteer) {
        volunteers.add(volunteer);
    }

    public static void deleteVolunteer(Volunteer volunteer) {
        volunteers.remove(volunteer);
    }

    public static List<Volunteer> getAllVolunteers() {
        return volunteers;
    }
}

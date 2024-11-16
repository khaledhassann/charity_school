//import java.util.ArrayList;
//import java.util.List;
//
//public class Task {
//    private String taskID;
//    private String taskName;
//    private String description;
//    private List<String> requiredSkills;
//    private List<Volunteer> assignedVolunteers;
//    private float minRatingRequired;
//
//    // Constructor
//    public Task(String taskID, String taskName, String description, List<String> requiredSkills, float minRatingRequired) {
//        this.taskID = taskID;
//        this.taskName = taskName;
//        this.description = description;
//        this.requiredSkills = requiredSkills;
//        this.assignedVolunteers = new ArrayList<>();
//        this.minRatingRequired = minRatingRequired;
//    }
//
//    // Methods for assigning a volunteer to the task
//    public boolean assignVolunteer(Volunteer volunteer) {
//        if (assignedVolunteers.size() < Config.TASK_CAPACITY && volunteer.getRating() >= minRatingRequired) {
//            assignedVolunteers.add(volunteer);
//            return true;
//        }
//        return false;
//    }
//
//    // Getters for task attributes
//    public String getTaskID() {
//        return taskID;
//    }
//
//    public String getTaskName() {
//        return taskName;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public float getMinRatingRequired() {
//        return minRatingRequired;
//    }
//
//    public List<String> getRequiredSkills() {
//        return requiredSkills;
//    }
//
//    public int getAssignedVolunteersCount() {
//        return assignedVolunteers.size();
//    }
//
//    public List<Volunteer> getAssignedVolunteers() {
//        return assignedVolunteers;
//    }
//}

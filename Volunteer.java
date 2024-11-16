//import java.util.ArrayList;
//import java.util.List;
//
//public class Volunteer extends User {
//    private boolean available;
//    private List<Task> assignedTasks;
//    private int rating;
//    private List<String> skills;
//
//    public Volunteer(String userID, String name, String contactInfo, String email, String phone, String address, boolean available, int rating) {
//        super(userID, name, contactInfo, email, phone, address);
//        this.available = available;
//        this.rating = rating;
//        this.skills = new ArrayList<>();
//        this.assignedTasks = new ArrayList<>();
//    }
//
//    // Model methods
//    public boolean isAvailable() { return available; }
//    public void setAvailable(boolean available) { this.available = available; }
//    public List<String> getSkills() { return skills; }
//    public void addSkill(String skill) { skills.add(skill); }
//    public List<Task> getAssignedTasks() { return assignedTasks; }
//    public boolean assignTask(Task task) {
//        if (assignedTasks.size() < Config.MAX_VOLUNTEER_ASSIGNMENTS && rating >= Config.minRatingRequired) {
//            assignedTasks.add(task);
//            return true;
//        }
//        return false;
//    }
//    public void setAssignedTasks(List<Task> assignedTasks) {
//        this.assignedTasks = assignedTasks;
//    }
//
//    public int getRating() {
//        return rating;
//    }
//
//    public void setRating(int rating) {
//        this.rating = rating;
//    }
//
//    public void setSkills(List<String> skills) {
//        this.skills = skills;
//    }
//
//    // Method to view profile details
//    public String viewProfile() {
//        return "Name: " + getName() + "\nEmail: " + getEmail() + "\nAddress: " + getAddress() + "\nRating: " + getRating();
//    }
//}

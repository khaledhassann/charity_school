import java.util.ArrayList;
import java.util.List;

public class VolunteerController {
    private Volunteer volunteer;
    private VolunteerView view;

    public VolunteerController(Volunteer volunteer, VolunteerView view) {
        this.volunteer = volunteer;
        this.view = view;
    }
//    public boolean login (String userName, String passWord) {
//        LoginContext loginContext = new LoginContext(new VolunteerLoginStrategy());
//        return loginContext.executeLogin("userName", "passWord");
//    }
    public void addSkill(String skill) {
        volunteer.addSkill(skill);
        view.displayMessage("Skill added successfully.");
        view.displaySkills(volunteer.getSkills());
    }

    public void viewSkills() {
        view.displaySkills(volunteer.getSkills());
    }

    public void chooseTask(List<Task> tasks, int taskNumber) {
        Task selectedTask = tasks.get(taskNumber - 1);
        if (volunteer.assignTask(selectedTask)) {
            view.displayMessage("Task assigned successfully.");
        } else {
            view.displayMessage("Unable to assign task, either max assignments reached or rating is too low.");
        }
    }

    public void changeAvailability(boolean available) {
        volunteer.setAvailable(available);
        view.displayMessage("Availability updated to: " + (available ? "Available" : "Unavailable"));
    }

    public void viewAssignedTasks() {
        view.displayAssignedTasks(volunteer.getAssignedTasks());
    }

    // Method to view profile
    public void viewProfile() {
        String profile = volunteer.viewProfile();
        view.displayProfile(profile);
    }
    public void changeRating(int rating){
        volunteer.setRating(rating);
        view.displayMessage("Rating updated to: Rating:"+rating);
    }

}
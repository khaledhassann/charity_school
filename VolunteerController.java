import java.util.List;

public class VolunteerController {
    // Register a volunteer
    public boolean registerVolunteer(Volunteer volunteer) {
        if (volunteer != null) {
            Volunteer.addVolunteer(volunteer);
            return true;
        }
        return false;
    }

    // Assign a task to a volunteer
    public boolean assignTaskToVolunteer(Volunteer volunteer, Task task) {
        if (volunteer != null && task != null) {
            return volunteer.assignTask(task);
        }
        return false;
    }

    // Update availability and add skill
    public void updateVolunteerDetails(Volunteer volunteer, boolean available, String skill) {
        if (volunteer != null) {
            volunteer.setAvailable(available);
            if (skill != null && !skill.isEmpty()) {
                volunteer.addSkill(skill);
            }
        }
    }

    // Delete a volunteer
    public void deleteVolunteer(Volunteer volunteer) {
        Volunteer.deleteVolunteer(volunteer);
    }

    // Get all volunteers
    public List<Volunteer> getAllVolunteers() {
        return Volunteer.getAllVolunteers();
    }
}

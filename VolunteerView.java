public class VolunteerView {
    private VolunteerController controller;

    public VolunteerView(VolunteerController controller) {
        this.controller = controller;
    }

    // Show volunteer details
    public void showVolunteerDetails(Volunteer volunteer) {
        System.out.println("Volunteer Details:");
        System.out.println("ID: " + volunteer.getUserID());
        System.out.println("Name: " + volunteer.getName());
        System.out.println("Available: " + volunteer.isAvailable());
        System.out.println("Max Assignments: " + volunteer.getMaxAssignments());
        System.out.println("Assigned Tasks: " + volunteer.getAssignedTasks().size());
        System.out.println("Skills: " + volunteer.getSkills());
    }

    // Show task details
    public void showTaskDetails(Task task) {
        System.out.println("Task Details:");
        System.out.println("Task ID: " + task.getTaskID());
        System.out.println("Name: " + task.getTaskName());
        System.out.println("Minimum Rating Required: " + task.getMinRatingRequired());
        System.out.println("Capacity: " + Config.TASK_CAPACITY);
        System.out.println("Assigned Volunteers: " + task.getAssignedVolunteersCount());
    }

    // Display all volunteers
    public void displayAllVolunteers() {
        System.out.println("List of All Volunteers:");
        for (Volunteer volunteer : controller.getAllVolunteers()) {
            showVolunteerDetails(volunteer);
        }
    }
}

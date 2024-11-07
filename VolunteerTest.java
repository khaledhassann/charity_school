import java.util.ArrayList;
import java.util.List;

public class VolunteerTest {
    public static void main(String[] args) {
        VolunteerController controller = new VolunteerController();

        // Create and register volunteers
        Volunteer volunteer1 = new Volunteer("V1", "John Doe", "contact info", "john@example.com", "123-4567", "address", true,2.0f);
        Volunteer volunteer2 = new Volunteer("V2", "Jane Smith", "contact info", "jane@example.com", "987-6543", "address", true,5.0f);

        boolean h1=controller.registerVolunteer(volunteer1);
        System.out.println(h1);
        boolean h2=controller.registerVolunteer(volunteer2);
        System.out.println(h2);


        // Update details for volunteer1
        controller.updateVolunteerDetails(volunteer1, true, "Java");
        controller.updateVolunteerDetails(volunteer2, true, "Python");

        // Create a task
        List<String> taskSkills = new ArrayList<>();
        taskSkills.add("Java");
        Task task1 = new Task("T1", "Code Review", "Review code for quality", taskSkills, Config.minRatingRequired);

        // Assign the task to volunteer1
        boolean result=controller.assignTaskToVolunteer(volunteer1, task1);
        System.out.println(result);


        // Show volunteer and task details
        VolunteerView view = new VolunteerView(controller);
        view.showVolunteerDetails(volunteer1);
        view.showTaskDetails(task1);

        // Display all volunteers
        view.displayAllVolunteers();

        // Delete a volunteer
        controller.deleteVolunteer(volunteer2);
        System.out.println("After deletion:");
        view.displayAllVolunteers();
    }
}

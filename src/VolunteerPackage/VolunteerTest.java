package VolunteerPackage;

import java.util.ArrayList;
import java.util.List;

public class VolunteerTest {
    public static void showMenu() {
        // Create a Volunteer instance using default values from the Config class
        Volunteer volunteer = new Volunteer(
                Config.DEFAULT_USER_ID,
                Config.DEFAULT_NAME,
                Config.DEFAULT_CONTACT_INFO,
                Config.DEFAULT_EMAIL,
                Config.DEFAULT_PHONE,
                Config.DEFAULT_ADDRESS,
                Config.DEFAULT_BENEFICIARY_STATUS,
                Config.minRatingRequired // Using the default rating requirement as an example
        );

        // Add default skills to the volunteer
        for (String skill : Config.DEFAULT_SKILLS) {
            volunteer.addSkill(skill);
        }

        // Initialize controller and view
        VolunteerView view = new VolunteerView();
        VolunteerController controller = new VolunteerController(volunteer, view);
        view.setController(controller);

        // Sample tasks
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("T1", "Code Review", "Review code for quality", List.of("Java"), Config.minRatingRequired));
        tasks.add(new Task("T2", "Documentation", "Prepare documentation", List.of("Writing"), Config.minRatingRequired));
        tasks.add(new Task("T3", "Testing", "Develop a testing code", List.of("Java"), Config.minRatingRequired));
        tasks.add(new Task("T4", "Talk", "Give a talk", List.of("Communication"), Config.minRatingRequired));

        // Start the application
        view.showVolunteerOptions(tasks);
    }
}

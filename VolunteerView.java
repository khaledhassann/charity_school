//import java.util.Arrays;
//import java.util.Date;
//import java.util.List;
//
//public class VolunteerView {
//    public void showVolunteerOptions() {
//        System.out.println("\nVolunteer Options:");
//        System.out.println("1. Add Skill");
//        System.out.println("2. View Skills");
//        System.out.println("3. Choose Task");
//        System.out.println("4. Change Availability");
//        System.out.println("5. View My Assigned Tasks");
//        System.out.println("6. View Profile");
//        System.out.println("7. Change Rating");
//        System.out.println("8. End Program");
//    }
//
//    public void displayMessage(String message) {
//        System.out.println(message);
//    }
//
//    public void displaySkills(List<String> skills) {
//        System.out.println("Skills:");
//        for (String skill : skills) {
//            System.out.println("- " + skill);
//        }
//    }
//
//    public void displayAssignedTasks(List<Task> tasks) {
//        System.out.println("Assigned Tasks:");
//        for (Task task : tasks) {
//            System.out.println("- " + task.getTaskName());
//        }
//    }
//
//    public void displayAvailableTasks(List<Task> tasks) {
//        System.out.println("Available Tasks:");
//        for (int i = 0; i < tasks.size(); i++) {
//            Task task = tasks.get(i);
//            System.out.println((i + 1) + ". " + task.getTaskName() + ": " + task.getDescription() +
//                    " (Required Skills: " + task.getRequiredSkills() + ")");
//        }
//    }
//
//    // Display profile details
//    public void displayProfile(String profile) {
//        System.out.println("Profile Information:\n" + profile);
//    }
//}

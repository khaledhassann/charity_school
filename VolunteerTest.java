//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class VolunteerTest {
//    public static void main(String[] args) {
//        // Create a Volunteer instance using default values from the Config class
//        Volunteer volunteer = new Volunteer(
//                Config.DEFAULT_USER_ID,
//                Config.DEFAULT_NAME,
//                Config.DEFAULT_CONTACT_INFO,
//                Config.DEFAULT_EMAIL,
//                Config.DEFAULT_PHONE,
//                Config.DEFAULT_ADDRESS,
//                Config.DEFAULT_BENEFICIARY_STATUS,
//                Config.minRatingRequired // Using the default rating requirement as an example
//        );
//
//        // Add default skills to the volunteer
//        for (String skill : Config.DEFAULT_SKILLS) {
//            volunteer.addSkill(skill);
//        }
//
//        VolunteerView view = new VolunteerView();
//        VolunteerController controller = new VolunteerController(volunteer, view);
//
//        // Sample tasks
//        List<Task> tasks = new ArrayList<>();
//        tasks.add(new Task("T1", "Code Review", "Review code for quality", List.of("Java"), Config.minRatingRequired));
//        tasks.add(new Task("T2", "Documentation", "Prepare documentation", List.of("Writing"), Config.minRatingRequired));
//        tasks.add(new Task("T3", "Testing", "Develop a testing code", List.of("Java"), Config.minRatingRequired));
//        tasks.add(new Task("T4", "Talk", "Give a talk", List.of("Communication"), Config.minRatingRequired));
//
//
//        Scanner scanner = new Scanner(System.in);
//        boolean running = true;
//
//        System.out.println("Hello, you are currently unavailable.");
//
//        while (running) {
//            view.showVolunteerOptions();
//            int choice = scanner.nextInt();
//            scanner.nextLine(); // Consume newline
//
//            switch (choice) {
//                case 1:
//                    System.out.print("Enter skill to add: ");
//                    String skill = scanner.nextLine();
//                    controller.addSkill(skill);
//                    break;
//                case 2:
//                    controller.viewSkills();
//                    break;
//                case 3:
//                    view.displayAvailableTasks(tasks);
//                    System.out.print("Choose task by number: ");
//                    int taskNumber = scanner.nextInt();
//                    controller.chooseTask(tasks, taskNumber);
//                    break;
//                case 4:
//                    System.out.print("Change availability (yes/no): ");
//                    String availability = scanner.nextLine();
//                    controller.changeAvailability(availability.equalsIgnoreCase("yes"));
//                    break;
//                case 5:
//                    controller.viewAssignedTasks();
//                    break;
//                case 6:
//                    controller.viewProfile();
//                    break;
//                case 7:
//                    System.out.print("Change Rating (1-5): ");
//                    int rating = Integer.parseInt(scanner.nextLine());
//                    controller.changeRating(rating);
//                    break;
//                case 8:
//                    running = false;
//                    break;
//                default:
//                    System.out.println("Invalid choice. Please try again.");
//            }
//        }
//
//        scanner.close();
//        System.out.println("Program ended.");
//    }
//}

package VolunteerPackage;

import java.util.List;
import java.util.Scanner;

public class VolunteerView {
    private final Scanner scanner = new Scanner(System.in);
    private VolunteerController controller;
    private EventTest eventTest;

    // Setter for the controller
    public void setController(VolunteerController controller) {
        this.controller = controller;
    }

    public void showVolunteerOptions(List<Task> tasks) {
        boolean running = true;

        while (running) {
            System.out.println("\nVolunteer Options:");
            System.out.println("1. Add Skill");
            System.out.println("2. View Skills");
            System.out.println("3. Choose Task");
            System.out.println("4. Change Availability");
            System.out.println("5. View My Assigned Tasks");
            System.out.println("6. View Profile");
            System.out.println("7. Change Rating");
            System.out.println("8. Show Event Details");
            System.out.println("9. End Program");


            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addSkill();
                    break;
                case 2:
                    controller.viewSkills();
                    break;
                case 3:
                    chooseTask(tasks);
                    break;
                case 4:
                    changeAvailability();
                    break;
                case 5:
                    controller.viewAssignedTasks();
                    break;
                case 6:
                    controller.viewProfile();
                    break;
                case 7:
                    changeRating();
                    break;
                case 8:
                    EventTest.showEventOptions();
                case 9:
                    running = false;
                    displayMessage("Program ended.");
                    break;
                default:
                    displayMessage("Invalid option. Please try again.");
            }
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displaySkills(List<String> skills) {
        System.out.println("Skills:");
        for (String skill : skills) {
            System.out.println("- " + skill);
        }
    }

    public void displayAssignedTasks(List<Task> tasks) {
        System.out.println("Assigned Tasks:");
        for (Task task : tasks) {
            System.out.println("- " + task.getTaskName());
        }
    }

    public void displayAvailableTasks(List<Task> tasks) {
        System.out.println("Available Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            System.out.println((i + 1) + ". " + task.getTaskName() + ": " + task.getDescription() +
                    " (Required Skills: " + task.getRequiredSkills() + ")");
        }
    }

    public void displayProfile(String profile) {
        System.out.println("Profile Information:\n" + profile);
    }

    // Helper methods for menu options
    private void addSkill() {
        System.out.print("Enter skill to add: ");
        String skill = scanner.nextLine();
        controller.addSkill(skill);
    }

    private void chooseTask(List<Task> tasks) {
        displayAvailableTasks(tasks);
        System.out.print("Choose task by number: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        controller.chooseTask(tasks, taskNumber);
    }

    private void changeAvailability() {
        System.out.print("Change availability (yes/no): ");
        String availability = scanner.nextLine();
        controller.changeAvailability(availability.equalsIgnoreCase("yes"));
    }

    private void changeRating() {
        System.out.print("Change Rating (1-5): ");
        int rating = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        controller.changeRating(rating);
    }
}

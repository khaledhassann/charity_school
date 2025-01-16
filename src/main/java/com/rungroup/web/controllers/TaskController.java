package com.rungroup.web.controllers;

import com.rungroup.web.models.Task;
import com.rungroup.web.models.Volunteer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class TaskController {

    private List<Task> taskList = new ArrayList<>(); // Simulates task storage
    private List<Volunteer> volunteers = getVolunteers(); // Simulated volunteer data
    private static long taskIdCounter = 1L;

    @GetMapping("/create-task")
public String showCreateTaskForm(Model model) {
    // Refresh the volunteers list (but do not modify availability)
    this.volunteers = getVolunteers();

    // Add volunteers for selection
    model.addAttribute("volunteers", volunteers);
    return "create-task"; // Render the create-tasks.html page
}

    @PostMapping("/create-task")
    public String processTaskCreation(
        @RequestParam("name") String name,
        @RequestParam("skillsRequired") List<String> skillsRequired,
        @RequestParam("volunteer_id") Long volunteer_id,
        Model model
) {
    // Find the selected volunteer
    Volunteer selectedVolunteer = volunteers.stream()
            .filter(v -> v.getId().equals(volunteer_id))
            .findFirst()
            .orElse(null);

    if (selectedVolunteer == null) {
        model.addAttribute("error", "Volunteer not found.");
        model.addAttribute("volunteers", volunteers);
        return "create-task";
    }

    System.out.println(selectedVolunteer.getSkills() + " jjj");

    // Check if the volunteer has the required skills
    if (!selectedVolunteer.getSkills().containsAll(skillsRequired)) {
        model.addAttribute("error", "Selected volunteer does not have all the required skills.");
        model.addAttribute("volunteers", volunteers);
        return "create-task";
    }

    // Create a new Task if validation passes
    Task newTask = new Task(taskIdCounter++, name, skillsRequired, volunteer_id);
    taskList.add(newTask);

    model.addAttribute("message", "Task created successfully!");
    model.addAttribute("volunteers", volunteers);
    return "create-task";
}

    @GetMapping("/volunteer-tasks")
    public String showVolunteerTasks(Model model) {
    Long volunteer_id = 1L; // Replace with session-based or security context-based ID
    List<Task> volunteerTasks = taskList.stream()
            .filter(task -> task.getResponsibleUser().equals(volunteer_id))
            .collect(Collectors.toList());

    model.addAttribute("tasks", volunteerTasks);
    model.addAttribute("volunteerId", volunteer_id);
    return "volunteer-tasks"; // Render the volunteer-tasks.html page
}


    @GetMapping("/task/{id}")
    public String showTaskDetails(@PathVariable("id") Long taskId, Model model) {
        // Find the task by ID
        Task task = taskList.stream()
                .filter(t -> t.getId().equals(taskId))
                .findFirst()
                .orElse(null);

        if (task == null) {
            model.addAttribute("error", "Task not found.");
            return "volunteer-tasks";
        }

        model.addAttribute("task", task);
        return "task"; // Render the task.html page
    }

    // Simulated method to get volunteers
    private List<Volunteer> getVolunteers() {
        List<Volunteer> volunteers = new ArrayList<>();
        volunteers.add(new Volunteer(1L, "John Doe", "john@example.com", "password123", List.of("Teaching", "Organizing"), true));
        volunteers.add(new Volunteer(2L, "Jane Smith", "jane@example.com", "password123", List.of("Counseling", "Technical"), true));
        return volunteers;
    }
    
}

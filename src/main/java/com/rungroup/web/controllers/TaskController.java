package com.rungroup.web.controllers;

import com.rungroup.web.models.Task;
import com.rungroup.web.models.Volunteer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TaskController {

    private List<Task> taskList = new ArrayList<>(); // Simulates task storage
    private List<Volunteer> volunteers = getVolunteers(); // Simulated volunteer data
    private static long taskIdCounter = 1L;

    @GetMapping("/create-task")
    public String showCreateTaskForm(Model model) {
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
            return "create-task";
        }
        System.out.println(selectedVolunteer.getSkills()+"jjj");

        // Check if the volunteer has the required skills
        if (!selectedVolunteer.getSkills().containsAll(skillsRequired)) {
            
            model.addAttribute("error", "Selected volunteer does not have all the required skills.");
            return "create-task";
        }

        // Check if the volunteer is available
        if (!selectedVolunteer.getAvailability()) {
            model.addAttribute("error", "Selected volunteer is not available.");
            return "create-task";
        }

        // Create a new Task if validation passes
        Task newTask = new Task(taskIdCounter++, name, skillsRequired, volunteer_id);
        taskList.add(newTask);

        model.addAttribute("message", "Task created successfully!");
        return "create-task";
    }

    // Simulated method to get volunteers
    private List<Volunteer> getVolunteers() {
        List<Volunteer> volunteers = new ArrayList<>();
        volunteers.add(new Volunteer(1L, "John Doe", "john@example.com", "password123", List.of("Teaching", "Organizing"), true));
        volunteers.add(new Volunteer(2L, "Jane Smith", "jane@example.com", "password123", List.of("Counseling", "Technical"), false));
        return volunteers;
    }
}

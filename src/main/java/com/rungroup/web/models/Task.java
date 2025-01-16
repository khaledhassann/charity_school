package com.rungroup.web.models;

import java.util.List;

public class Task {
    private Long id;
    private String name;
    private List<String> skillsRequired;
    private Long volunteer_id; // Volunteer ID

    // Constructor
    public Task(Long id, String name, List<String> skillsRequired, Long volunteer_id) {
        this.id = id;
        this.name = name;
        this.skillsRequired = skillsRequired;
        this.volunteer_id = volunteer_id;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSkillsRequired() {
        return skillsRequired;
    }

    public void setSkillsRequired(List<String> skillsRequired) {
        this.skillsRequired = skillsRequired;
    }

    public Long getResponsibleUser() {
        return volunteer_id;
    }

    public void setResponsibleUser(Long volunteer_id) {
        this.volunteer_id = volunteer_id;
    }

    // Method to assign a task
    public boolean assignTask(Volunteer volunteer) {
        if (volunteer.getSkills().containsAll(skillsRequired)) {
            this.volunteer_id = volunteer.getId();
            return true;
        }
        return false;
    }
}


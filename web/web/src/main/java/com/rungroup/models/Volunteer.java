package com.rungroup.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Volunteer extends User {
    private List<String> skills;
    private String availability;

    // Constructor
    public Volunteer(Long id, String name, String email, String password, List<String> skills, String availability) {
        super(id, name, email, password);
        this.skills = skills;
        this.availability = availability;
    }

    public Volunteer() {
        this.skills = new ArrayList<>();
    }

    // Getters and Setters
    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    // Methods
    @Override
    public String getRole() {
        return "Volunteer";
    }

    public boolean updateProfile(String updatedName, String updatedEmail) {
        if (updatedName != null && !updatedName.isEmpty()) {
            setName(updatedName);
        }
        if (updatedEmail != null && !updatedEmail.isEmpty()) {
            setEmail(updatedEmail);
        }
        return true;
    }

    public boolean signUpForEvent(Event event) {
        if (event == null) {
            return false;
        }
        // Logic for signing up for an event (e.g., adding to a list or database)
        return true;
    }

    public boolean teachSubject(Course course, double hours, LocalDateTime date) {
        if (course == null || hours <= 0 || date == null) {
            return false;
        }
        // Logic for teaching a subject (e.g., logging details in a database)
        return true;
    }

    public List<VerbDetails> getTeachingHistory() {
        // Logic to fetch teaching history (e.g., fetching from a database)
        return new ArrayList<>();
    }

    public List<VerbDetails> getEventHistory() {
        // Logic to fetch event history (e.g., fetching from a database)
        return new ArrayList<>();
    }

    // Add and Remove methods for skills
    public void addSkill(String skill) {
        if (skill != null && !skill.isEmpty()) {
            skills.add(skill);
        }
    }

    public void removeSkill(String skill) {
        skills.remove(skill);
    }
}

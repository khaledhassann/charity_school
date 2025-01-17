package com.rungroup.web.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id; 

    @Column(name = "created_at", updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    protected LocalDateTime created_at;
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    protected LocalDateTime updated_at;

    private String name;

    // private List<String> skillsRequired = new ArrayList<>();
    @Column(name = "skills_required", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private String skillsRequired;

    private Long volunteer_id; // Volunteer ID

    // Constructor
    public Task(String name, List<String> skillsRequired, Long volunteer_id) {
        
        this.name = name;
        setSkillsRequired(skillsRequired);
        this.volunteer_id = volunteer_id;
    }

    // Getters and Setters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSkillsRequired() {
        if(skillsRequired != null && skillsRequired != ""){
            return List.of(skillsRequired.split(","));
        }
        return null;
    }

    public void setSkillsRequired(List<String> skillsRequired) {
        this.skillsRequired = String.join(",", skillsRequired);
    }

    public Long getResponsibleUser() {
        return volunteer_id;
    }

    public void setResponsibleUser(Long volunteer_id) {
        this.volunteer_id = volunteer_id;
    }

    // Method to assign a task
    public boolean assignTask(Volunteer volunteer) {
        if (volunteer.getSkills().containsAll(getSkillsRequired())) {
            this.volunteer_id = volunteer.getId();
            return true;
        }
        return false;
    }
}


package com.rungroup.web.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "assessment")

public class Assessment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double weight;
    private double maxScore;
    private LocalDateTime deadline;
    @Transient
    private Course course;
    private Long course_id;
    @Transient
    private State state;
    private Long state_id;
    private String stateName;
    @Column(name = "created_at", updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime created_at;
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updated_at;

    public Assessment(String name, double weight, double maxScore, LocalDateTime deadline, Course course, State state) {
        this.name = name;
        this.weight = weight;
        this.maxScore = maxScore;
        this.deadline = deadline;
        this.course = course;
        this.state = state;
        this.course_id = course.getId();
        // this.state_id = state.ge;
        this.stateName = state instanceof Draft ? "Draft" : "Active";
    }

    // Default constructor
    // public Assessment() {}

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getMaxScore() {
        return maxScore;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public Course getCourse() {
        return course;
    }

    public State getState() {
        return state;
    }

    public String getStateName() {
        return stateName;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setMaxScore(double maxScore) {
        this.maxScore = maxScore;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setState(State state) {
        this.state = state;
        this.stateName = state instanceof Draft ? "Draft" : "Active";
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    // Additional Methods
    public void changeState() {
        state.changeState(this);
    }

    @Override
    public String toString() {
        return "Assessment{name='" + name + "', state=" + state + "}";
    }
}

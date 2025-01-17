package com.rungroup.models;

import java.time.LocalDateTime;

public class Assessment {
    private Long id;
    private String name;
    private double weight;
    private double maxScore;
    private LocalDateTime deadline;
    private Course course;
    private State state;
    private String stateName;

    public Assessment(Long id, String name, double weight, double maxScore, LocalDateTime deadline, Course course, State state) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.maxScore = maxScore;
        this.deadline = deadline;
        this.course = course;
        this.state = state;
        this.stateName = state instanceof Draft ? "Draft" : "Active";
    }

    // Default constructor
    public Assessment() {}

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

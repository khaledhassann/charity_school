package com.rungroup.web.models;
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

    // Getters and setters
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

    public String getStateName() {
        return state.toString();
    }

    public void changeState() {
        state.changeState(this);
    }

   

    @Override
    public String toString() {
        return "Assessment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", state=" + state +
                '}';
    }
    public void setState(State state) {
        this.state = state;
        this.stateName = state instanceof Draft ? "Draft" : "Active";
    }
    public State getState() {
        return state;
    }
    
    
}
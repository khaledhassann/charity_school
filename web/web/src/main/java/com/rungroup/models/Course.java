package com.rungroup.models;

public class Course {
    private Long id;
    private String name;
    private String description;
    private String image_Url;
    private int credits;        
    private int timeSlot;       
    private double progress;    

    public Course(Long id, String name, String description, String imageUrl, int credits, int timeSlot, double progress) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image_Url = image_Url;
        this.credits = credits;
        this.timeSlot = timeSlot;
        this.progress = progress;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return image_Url;
    }

    public void setImageUrl(String image_Url) {
        this.image_Url = image_Url;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(int timeSlot) {
        this.timeSlot = timeSlot;
    }

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }
}

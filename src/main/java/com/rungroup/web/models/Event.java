package com.rungroup.web.models;


import java.time.LocalDateTime;

public class Event {
    private Long id;
    private String name;
    private String description;
    private String image_url;
    private LocalDateTime date; 
    private String location;

    // Constructors
    public Event(){}
    public Event(Long id, String name, String description, String image_url, LocalDateTime date, String location) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image_url = image_url;
        this.date = date;
        this.location = location;
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
        return image_url;
    }

    public void setImageUrl(String imageUrl) {
        this.image_url = imageUrl;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

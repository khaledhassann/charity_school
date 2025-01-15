package com.rungroup.web.models;

import java.time.LocalDateTime;

public class Advertisement {
    private Long id;
    private String content;
    private String platform;
    private String status;
    private LocalDateTime launchDate;
    private Long eventId; // New field for associated event

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getEventId() {
        return eventId;
    }
    public void setEventId(Long eventId){
this.eventId=eventId;

    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(LocalDateTime launchDate) {
        this.launchDate = launchDate;
    }
}

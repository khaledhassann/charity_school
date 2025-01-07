package com.rungroup.web.models;

import java.time.LocalDateTime;

public abstract class Advertisement {
    private Long id;
    private String content;
    private SocialMediaPlatform platform;
    private String status;
    private LocalDateTime launchDate;
    private Long eventId;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public SocialMediaPlatform getPlatform() {
        return platform;
    }

    public void setPlatform(SocialMediaPlatform platform) {
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

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    // Abstract method
    public abstract String showAd();
}

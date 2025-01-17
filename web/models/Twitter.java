package com.rungroup.web.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="Twitter")
public class Twitter extends Advertisement {
    private String PlatformAlgo;
    public Twitter(Long id, String content,  String status, LocalDateTime launchDate, Long eventId,LocalDateTime created_at,LocalDateTime updated_at) {
        super(id, content, status, launchDate, eventId, created_at, updated_at);
    }
    @Override
    public String showAdString(){
        return "Twitter";
    }
    public String TwitterPost(){
        return "";
    }
    

    
}

package com.rungroup.web.models;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    private String name;
    private int capacity;
    private String amendments;
    @Column(name = "created_at", updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime created_at;
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updated_at;
    
    public void setAmendments(List<String> amendments) {
        if (amendments == null) {
            amendments = new ArrayList<>();
            return;
        }
        this.amendments = String.join(", ", amendments);
    }
    public List<String> getAmendments() {
        return List.of(amendments.split(", "));
    }
    
    public void addAmendment(String amendment) {
        if (this.amendments == null) {
            this.amendments = "";
        }
        
        if (!amendments.contains(amendment)) {
            if (this.amendments.isEmpty()) {
                this.amendments = amendment;
            } else {
                this.amendments += ", " + amendment;
            }
            setAmendments(List.of(amendments.split(", ")));
        }
    }
}

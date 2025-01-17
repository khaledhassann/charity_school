package com.rungroup.web.models;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

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
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "B")
public class B {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    private int B_SPECIFIC;
    @Column(name = "created_at", updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    protected LocalDateTime created_at;
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    protected LocalDateTime updated_at;

    // @ElementCollection
    // @CollectionTable(name = "B_Skills", joinColumns = @JoinColumn(name = "b_id"))
    // @Column(name = "skill")
    private String skills;
    
    public void setSkills(List<String> skills) {
        if (skills == null) {
            skills = new ArrayList<>();
            return;
        }
        this.skills = String.join(", ", skills);
    }
    public List<String> getSkills() {
        return List.of(skills.split(", "));
    }

}

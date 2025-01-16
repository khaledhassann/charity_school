package com.rungroup.web.models;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor

@MappedSuperclass
@Entity
@Table(name = "A")
public  class A {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id; 
    @Column(name = "created_at", updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    protected LocalDateTime created_at;
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    protected LocalDateTime updated_at;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "A_B", // Join table name
        joinColumns = @JoinColumn(name = "id"), // Foreign key in the join table for Class A
        inverseJoinColumns = @JoinColumn(name = "id") // Foreign key in the join table for Class B
    )
    private List<B> blist = new ArrayList<>();
    public List<Long> getBlist(){
        List<Long> ids = new ArrayList<>();
        for (B b : blist) {
            ids.add(b.getId());
        }
        return ids;
    } 
    // protected B obj_b;

}


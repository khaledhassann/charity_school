package com.rungroup.web.models;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private static Long idCounter = 0L; // Static counter to generate unique IDs
    private Long id; // Unique room ID
    private String name;
    private int capacity;
    private List<String> amendments;

    // Constructors
    public Room() {
        this.id = ++idCounter;
        this.amendments = new ArrayList<>();
    }

    public Room(String name, int capacity, List<String> amendments) {
        this.id = ++idCounter;
        this.name = name;
        this.capacity = capacity;
        this.amendments = (amendments != null) ? amendments : new ArrayList<>();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<String> getAmendments() {
        return amendments;
    }

    public void setAmendments(List<String> amendments) {
        this.amendments = amendments;
    }

    public void addAmendment(String amendment) {
        if (!amendments.contains(amendment)) {
            amendments.add(amendment);
        }
    }
}

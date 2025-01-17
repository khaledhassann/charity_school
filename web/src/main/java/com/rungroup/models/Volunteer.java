package com.rungroup.models;

import java.util.List;

public class Volunteer extends User {

    private List<String> skills;
    private boolean availability;

    public Volunteer(Long id,String name, String email, String password,List<String> skills,boolean availability) {
        super(id, name, email, password);
        this.skills = skills;
        this.availability=availability;
    
    }

    // Getters and setters
    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public boolean getAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
 
     @Override
     public String getRole() {
         return "Volunteer";
     }
}
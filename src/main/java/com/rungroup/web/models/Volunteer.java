package com.rungroup.web.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Volunteer extends User {

    private List<String> skills;
    private boolean availability;

  public Volunteer(){
    super();
  }

    public Volunteer(Long id,String name, String email, String password) {
        super(id, name, email, password);
        this.skills = new ArrayList<>();
        this.availability=false;
    
    }

    // Getters and setters
    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    // // Getters and setters
    // public String getName() {
    //     return name;
    // }
    // public void setId(Long id){
    //     this.id=id;
    // }

    // public void setName(String name) {
    //     this.name = name;
    // }

    // public String getEmail() {
    //     return email;
    // }

    // public void setEmail(String email) {
    //     this.email = email;
    // }

    // public String getPassword() {
    //     return password;
    // }

    // public void setPassword(String password) {
    //     this.password = password;
    // }
    @Override
    public String getRole() {
        return "Donor";
    }

}

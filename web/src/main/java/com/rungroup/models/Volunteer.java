package com.rungroup.models;

public class Volunteer extends User {
    public Volunteer(Long id, String name, String email, String password) {
        super(id, name, email, password);
     }
 
     @Override
     public String getRole() {
         return "Volunteer";
     }
}
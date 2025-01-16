package com.rungroup.models;

public class Admin extends User {
    

    public Admin(Long id, String name, String email, String password) {
       super(id, name, email, password);
    }

    @Override
    public String getRole() {
        return "Admin";
    }
}
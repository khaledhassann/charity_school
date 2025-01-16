package com.rungroup.web.models;

import jakarta.persistence.Entity;

import jakarta.persistence.Table;

import lombok.Data;

import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@Entity
@Table(name = "Volunteer")
public class Volunteer extends User {

    public Volunteer(String name, String email, String password) {
        super(name, email, password);

    }

    // // Getters and setters
    // public String getName() {
    // return name;
    // }
    // public void setId(Long id){
    // this.id=id;
    // }

    // public void setName(String name) {
    // this.name = name;
    // }

    // public String getEmail() {
    // return email;
    // }

    // public void setEmail(String email) {
    // this.email = email;
    // }

    // public String getPassword() {
    // return password;
    // }

    // public void setPassword(String password) {
    // this.password = password;
    // }
    @Override
    public String getRole() {
        return "Volunteer";
    }

}
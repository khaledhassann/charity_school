package com.rungroup.web.models;

import com.rungroup.web.repositories.Implementations.DonorRepository;
import com.rungroup.web.repositories.Implementations.VolunteerRepository;
import com.rungroup.web.utils.Command;

import jakarta.persistence.Entity;

import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@Entity
@Table(name = "Donor")
public class Donor extends User {
    private String preferred_type;
    @Transient
    private Command command;

    public Donor(){}

    public Donor(String name, String email, String password, String preferred_type) {
        super(name, email, password);
        this.preferred_type = preferred_type;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public boolean makeDonation(Donation donation) {
        if (command != null) {
            command.execute();
            return true;
        }
        throw new IllegalStateException("Command not set.");
    }

    public void undoDonation(Donation donation) {
        if (command != null) {
            command.undo();
        } else {
            throw new IllegalStateException("Command not set.");
        }
    }

    // // Getters and setters
    // public String getName() {
    //     return name;
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
    // public void setId(Long id){
    //     this.id=id;
    // }
    @Override
    public String getRole() {
        return "Donor";
    }

    @Override
    public boolean delete(){
        return new DonorRepository().deleteById(this.id);
    }
}

package com.rungroup.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Beneficiary extends User {
    private String grade;
    

    // List to keep track of registered courses
    private List<Course> registeredSubjects = new ArrayList<>();
    private List<VerbDetails> subjectDetails = new ArrayList<>();

    // Constructors
    public Beneficiary(Long id, String username, String email, String password, String grade) {
        super(id, username, email, password); // Call the superclass constructor
        this.grade = grade;
        
    }

    public Beneficiary() {
        super(); // Call the no-argument constructor of User
    }

    // Getters and Setters
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    
    public List<Course> getRegisteredSubjects() {
        return registeredSubjects;
    }

    public List<VerbDetails> getSubjectDetails() {
        return subjectDetails;
    }

    // Methods
    public String getRole() {
        return "Beneficiary";
    }

    public boolean registerForSubject(Course subject) {
        if (registeredSubjects.contains(subject)) {
            return false; // Already registered
        }
        registeredSubjects.add(subject);
        return true;
    }

    public List<VerbDetails> viewSubjects() {
        return new ArrayList<>(subjectDetails);
    }

    // Add and Remove Methods
    public void addSubjectDetail(VerbDetails detail) {
        subjectDetails.add(detail);
    }

    public void removeSubjectDetail(VerbDetails detail) {
        subjectDetails.remove(detail);
    }
}

package com.rungroup.web.models;

import java.time.LocalDateTime;

public class Beneficiary extends User {
    private String grade;
private LocalDateTime enrollmentDate;

    public Beneficiary() {
        super();
    }

    public Beneficiary(Long id, String name, String email, String password) {
        super(id, name, email, password);
    }
    public Beneficiary(Long id, String name, String email, String password, String grade, LocalDateTime enrollmentDate) {
        super(id, name, email, password);
        this.grade=grade;
        this.enrollmentDate=enrollmentDate;
    }

    @Override
    public String getRole() {
        return "BENEFICIARY";
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public LocalDateTime getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDateTime enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }
}

package com.rungroup.web.models;

import java.time.LocalDateTime;

import com.rungroup.web.repositories.Implementations.BeneficiaryRepository;
import com.rungroup.web.repositories.Implementations.DonorRepository;

import jakarta.persistence.Entity;

import jakarta.persistence.Table;

import lombok.Data;

import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@Entity
@Table(name = "Beneficiary")
public class Beneficiary extends User {
    private String grade;
    private LocalDateTime enrollment_date;

    public Beneficiary() {
        super();
    }

    public Beneficiary(String name, String email, String password) {
        super(name, email, password);
    }
    public Beneficiary(String name, String email, String password, String grade, LocalDateTime enrollmentDate) {
        super(name, email, password);
        this.grade=grade;
        this.enrollment_date=enrollmentDate;
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
        return enrollment_date;
    }

    public void setEnrollmentDate(LocalDateTime enrollmentDate) {
        this.enrollment_date = enrollmentDate;
    }
    @Override
    public boolean delete(){
        return new BeneficiaryRepository().deleteById(this.id);
    }
}

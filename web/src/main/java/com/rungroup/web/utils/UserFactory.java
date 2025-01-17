package com.rungroup.web.utils;

import com.rungroup.web.models.*;
import com.rungroup.web.repositories.Implementations.BeneficiaryRepository;
import com.rungroup.web.repositories.Implementations.DonorRepository;
import com.rungroup.web.repositories.Implementations.VolunteerRepository;

import java.time.LocalDateTime;
import java.util.List;

public class UserFactory {

    public static User createUser(
        Long id,
        String role, 
        String name, 
        String email, 
        String password,
        String grade, 
        LocalDateTime enrollmentDate,
        String preferred_type,
        List<String> skills,
        boolean availability
    ) {
        if ("Beneficiary".equalsIgnoreCase(role)) {
            Beneficiary o = new Beneficiary(name, email, password, grade, enrollmentDate);
            new BeneficiaryRepository().insert(o);
            return o;
        } else if ("Donor".equalsIgnoreCase(role)) {
            Donor o = new Donor(name, email, password, preferred_type);
            new DonorRepository().insert(o);
            return o;
        } else if ("Volunteer".equalsIgnoreCase(role)) {
            Volunteer o = new Volunteer(name, email, password, skills, availability);
            new VolunteerRepository().insert(o);
            return o;
        } else {
            throw new IllegalArgumentException("Invalid role: " + role);
        }
    }
}

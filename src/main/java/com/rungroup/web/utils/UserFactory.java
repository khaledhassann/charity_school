package com.rungroup.web.utils;

import com.rungroup.web.models.*;
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
            return new Beneficiary(id,name, email, password,grade,enrollmentDate);
        } else if ("Donor".equalsIgnoreCase(role)) {
            return new Donor(id,name, email, password,preferred_type);
        } else if ("Volunteer".equalsIgnoreCase(role)) {
            return new Volunteer(id,name, email, password,skills,availability);
        } else {
            throw new IllegalArgumentException("Invalid role: " + role);
        }
    }
}

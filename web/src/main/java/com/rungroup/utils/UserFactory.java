package com.rungroup.utils;

import com.rungroup.models.*;
import java.time.LocalDateTime;

public class UserFactory {

    public static User createUser(
        Long id,
        String role, 
        String name, 
        String email, 
        String password,
        String grade, 
        LocalDateTime enrollmentDate,
        String preferred_type
    ) {
        if ("Beneficiary".equalsIgnoreCase(role)) {
            return new Beneficiary(id,name, email, password,grade,enrollmentDate);
        } else if ("Donor".equalsIgnoreCase(role)) {
            return new Donor(id,name, email, password,preferred_type);
        } else if ("Volunteer".equalsIgnoreCase(role)) {
            return new Volunteer(id,name, email, password);
        }else if ("Admin".equalsIgnoreCase(role)) {
            return new Admin(id,name, email, password);
        } else {
            throw new IllegalArgumentException("Invalid role: " + role);
        }
    }
}
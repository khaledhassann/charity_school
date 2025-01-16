package com.rungroup.web.utils;

import com.rungroup.web.models.*;
import java.time.LocalDateTime;

public class UserFactory {

    public static User createUser(
        Long id,
        String role, 
        String name, 
        String email, 
        String password,
        String grade, 
        LocalDateTime enrollmentDate
    ) {
        if ("Beneficiary".equalsIgnoreCase(role)) {
            return new Beneficiary(id,name, email, password,grade,enrollmentDate);
        } else if ("Donor".equalsIgnoreCase(role)) {
            return new Donor(id,name, email, password);
        } else if ("Volunteer".equalsIgnoreCase(role)) {
            return new Volunteer(id,name, email, password);
        } else {
            throw new IllegalArgumentException("Invalid role: " + role);
        }
    }
}

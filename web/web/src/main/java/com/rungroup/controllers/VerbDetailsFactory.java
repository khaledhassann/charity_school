package com.rungroup.controllers;

import com.rungroup.models.*;
import com.rungroup.models.ParticipateDetails;
import com.rungroup.models.RegisterDetails;
import com.rungroup.models.TeachDetails;
import com.rungroup.models.User;
import com.rungroup.models.Verb;
import com.rungroup.models.VerbDetails;

import java.time.LocalDateTime;
import java.util.List;

public class VerbDetailsFactory {

    public static VerbDetails createVerbDetails(Verb verbType, User user, Object target, List<Object> additionalData) {
        String verbName = verbType.getName().toLowerCase(); 

        switch (verbName) {
            case "teach":
                double hoursTaught = (double) additionalData.get(0);
                return new TeachDetails(user, target, verbType, hoursTaught);

            case "participate":
                String role = (String) additionalData.get(0);
                return new ParticipateDetails(user, target, verbType, role);

                case "register":
                String status = (String) additionalData.get(0); // Safe access
                return new RegisterDetails(user, target, verbType, status);
            

            default:
                throw new IllegalArgumentException("Invalid verb type: " + verbName);
        }
    }
}

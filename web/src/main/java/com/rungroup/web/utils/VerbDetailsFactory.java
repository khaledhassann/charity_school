package com.rungroup.web.utils;

import java.util.Map;

import com.rungroup.web.models.ParticipateDetails;
import com.rungroup.web.models.RegisterDetails;
import com.rungroup.web.models.TeachDetails;
import com.rungroup.web.models.User;
import com.rungroup.web.models.Verb;
import com.rungroup.web.models.VerbDetails;
import com.rungroup.web.repositories.Implementations.AdminRepository;
import com.rungroup.web.repositories.Implementations.BeneficiaryRepository;
import com.rungroup.web.repositories.Implementations.CourseRepository;
import com.rungroup.web.repositories.Implementations.DonorRepository;
import com.rungroup.web.repositories.Implementations.EventRepository;
import com.rungroup.web.repositories.Implementations.ParticipateDetailsRepository;
import com.rungroup.web.repositories.Implementations.RegisterDetailsRepository;
import com.rungroup.web.repositories.Implementations.TeachDetailsRepository;
import com.rungroup.web.repositories.Implementations.VerbRepository;
import com.rungroup.web.repositories.Implementations.VolunteerRepository;

public class VerbDetailsFactory {
    public static VerbRepository verbRepository = new VerbRepository();
    public static AdminRepository adminRepository = new AdminRepository();
    public static BeneficiaryRepository beneficiaryRepository = new BeneficiaryRepository();
    public static CourseRepository courseRepository = new CourseRepository();
    public static DonorRepository donorRepository = new DonorRepository();
    public static EventRepository eventRepository = new EventRepository();
    public static ParticipateDetailsRepository pDetailsRepository = new ParticipateDetailsRepository();
    public static RegisterDetailsRepository rDetailsRepository = new RegisterDetailsRepository();
    public static TeachDetailsRepository tDetailsRepository = new TeachDetailsRepository();
    public static VolunteerRepository volunteerRepository = new VolunteerRepository();

    public static VerbDetails createVerbDetails(Long verb_id, Long user_id, String user_type, Long target_id,
            String target_type, Map<String, Object> additionalData) {

        // Retrieve the verb
        Verb verb = verbRepository.findById(verb_id);
        if (verb == null) {
            throw new IllegalArgumentException("Verb not found with id: " + verb_id);
        }

        // Retrieve the user based on user_type
        User user = null;
        switch (user_type.toLowerCase()) {
            case "admin":
                user = adminRepository.findById(user_id);
                break;
            case "beneficiary":
                user = beneficiaryRepository.findById(user_id);
                break;
            case "volunteer":
                user = volunteerRepository.findById(user_id);
                break;
            case "donor":
                user = donorRepository.findById(user_id);
                break;
            default:
                throw new IllegalArgumentException("Unknown user type: " + user_type);
        }

        if (user == null) {
            throw new IllegalArgumentException("User not found with id: " + user_id);
        }

        // Retrieve the target based on target_type
        Object target = null;
        switch (target_type.toLowerCase()) {
            case "course":
                target = courseRepository.findById(target_id);
                break;
            case "event":
                target = eventRepository.findById(target_id);
                break;
            default:
                throw new IllegalArgumentException("Unknown target type: " + target_type);
        }

        if (target == null) {
            throw new IllegalArgumentException("Target not found with id: " + target_id);
        }

        // Create the appropriate VerbDetails subclass based on verb name
        VerbDetails verbDetails = null;
        if (verb.getName().equalsIgnoreCase("Teaching")) { // Assuming "Teaching" corresponds to TeachDetails
            Long hours_taught = (Long) additionalData.get("hours_taught");
            verbDetails = new TeachDetails(user_id, "volunteer", target_id, "course", verb_id, hours_taught);
        } else if (verb.getName().equalsIgnoreCase("Participating")) { // Assuming "Participating" corresponds to
                                                                       // ParticipateDetails
            String role = (String) additionalData.get("role");
            verbDetails = new ParticipateDetails(user_id, "volunteer", target_id, "event", verb_id, role);
        } else if (verb.getName().equalsIgnoreCase("Registering")) { // Assuming "Registering" corresponds to
                                                                     // RegisterDetails
            String status = (String) additionalData.get("status");
            verbDetails = new RegisterDetails(user_id, "beneficiary", target_id, "course", verb_id, status);
        } else {
            throw new IllegalArgumentException("Unknown verb name: " + verb.getName());
        }

        return verbDetails;
    }

}
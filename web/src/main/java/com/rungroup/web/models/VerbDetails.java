package com.rungroup.web.models;

import java.time.LocalDateTime;

import javax.xml.stream.util.EventReaderDelegate;

import com.rungroup.web.repositories.Implementations.AdminRepository;
import com.rungroup.web.repositories.Implementations.BeneficiaryRepository;
import com.rungroup.web.repositories.Implementations.CourseRepository;
import com.rungroup.web.repositories.Implementations.DonorRepository;
import com.rungroup.web.repositories.Implementations.EventRepository;
import com.rungroup.web.repositories.Implementations.VerbRepository;
import com.rungroup.web.repositories.Implementations.VolunteerRepository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@MappedSuperclass
public abstract class VerbDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected Long user_id;
    protected Long target_id;
    protected Long verb_id;
    @Column(name = "created_at", updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    protected LocalDateTime created_at;
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    protected LocalDateTime updated_at;
    @Transient
    protected String user_type;
    @Transient
    protected String target_type;

    public VerbDetails(Long user_id, String user_type, Long target_id, String target_type, Long verb_id) {
        this.user_id = user_id;
        this.target_id = target_id;
        this.verb_id = verb_id;
        this.user_type = user_type;
        this.target_type = target_type;
    }

    public abstract String getInteractionDetails();

    public User getUser() {
        AdminRepository ar = new AdminRepository();
        BeneficiaryRepository br = new BeneficiaryRepository();
        DonorRepository dr = new DonorRepository();
        VolunteerRepository vr = new VolunteerRepository();

        // Retrieve the user based on user_type
        User user = null;
        switch (user_type.toLowerCase()) {
            case "admin":
                user = ar.findById(user_id);
                break;
            case "beneficiary":
                user = br.findById(user_id);
                break;
            case "volunteer":
                user = vr.findById(user_id);
                break;
            case "donor":
                user = dr.findById(user_id);
                break;
            default:
                throw new IllegalArgumentException("Unknown user type: " + user_type);
        }

        if (user == null) {
            throw new IllegalArgumentException("User not found with id: " + user_id);
        }
        return user;
    }

    public TargetAdapter getTargetAdapter() {
        CourseRepository cr = new CourseRepository();
        EventRepository er = new EventRepository();
        TargetAdapter tAdapter;

        Object target = null;
        switch (target_type.toLowerCase()) {
            case "course":
                target = cr.findById(target_id);
                tAdapter = new CourseAdapter((Course) target);
                break;
            case "event":
                target = er.findById(target_id);
                tAdapter = new EventAdapter((Event) target);
                break;
            default:
                throw new IllegalArgumentException("Unknown target type: " + target_type);
        }

        if (target == null || tAdapter == null) {
            throw new IllegalArgumentException("Target not found with id: " + target_id);
        }
        return tAdapter;

    }

    public Verb getVerb() {
        VerbRepository vr = new VerbRepository();

        try {
            Verb verb = vr.findById(verb_id);
            if (verb != null) {
                return verb;
            }
        } catch (Exception e) {
            // Log the exception if needed
            System.out.println(e);
        }

        throw new RuntimeException("Verb not found in the repository");
    }

}

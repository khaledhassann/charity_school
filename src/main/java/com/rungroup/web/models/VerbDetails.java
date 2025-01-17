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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
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

    public VerbDetails(Long user_id, Long target_id, Long verb_id) {
        this.user_id = user_id;
        this.target_id = target_id;
        this.verb_id = verb_id;
    }

    public abstract String getInteractionDetails();

    public User getUser() {
        AdminRepository ar = new AdminRepository();
        BeneficiaryRepository br = new BeneficiaryRepository();
        DonorRepository dr = new DonorRepository();
        VolunteerRepository vr = new VolunteerRepository();

        try {
            Admin admin = ar.findById(user_id);
            if (admin != null) {
                return admin;
            }
        } catch (Exception e) {
            // Log the exception if needed
        }

        try {
            Beneficiary beneficiary = br.findById(user_id);
            if (beneficiary != null) {
                return beneficiary;
            }
        } catch (Exception e) {
            // Log the exception if needed
        }

        try {
            Donor donor = dr.findById(user_id);
            if (donor != null) {
                return donor;
            }
        } catch (Exception e) {
            // Log the exception if needed
        }

        try {
            Volunteer volunteer = vr.findById(user_id);
            if (volunteer != null) {
                return volunteer;
            }
        } catch (Exception e) {
            // Log the exception if needed
        }

        throw new RuntimeException("User not found in any repository");
    }

    public TargetAdapter getTargetAdapter() {
        CourseRepository cr = new CourseRepository();
        EventRepository er = new EventRepository();

        try {
            Course course = cr.findById(target_id);
            if (course != null) {
                return new CourseAdapter(course);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Event event = er.findById(target_id);
            if (event != null) {
                return new EventAdapter(event);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        throw new RuntimeException("User not found in any repository");
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

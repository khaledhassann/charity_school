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
    protected Long userId;
    protected Long targetId;
    protected Long verbId;
    @Column(name = "created_at", updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    protected LocalDateTime created_at;
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    protected LocalDateTime updated_at;

    public VerbDetails(Long userId, Long targetId, Long verbId) {
        this.userId = userId;
        this.targetId = targetId;
        this.verbId = verbId;
    }

    public abstract String getInteractionDetails();

    public User getUser() {
        AdminRepository ar = new AdminRepository();
        BeneficiaryRepository br = new BeneficiaryRepository();
        DonorRepository dr = new DonorRepository();
        VolunteerRepository vr = new VolunteerRepository();

        try {
            Admin admin = ar.findById(userId);
            if (admin != null) {
                return admin;
            }
        } catch (Exception e) {
            // Log the exception if needed
        }

        try {
            Beneficiary beneficiary = br.findById(userId);
            if (beneficiary != null) {
                return beneficiary;
            }
        } catch (Exception e) {
            // Log the exception if needed
        }

        try {
            Donor donor = dr.findById(userId);
            if (donor != null) {
                return donor;
            }
        } catch (Exception e) {
            // Log the exception if needed
        }

        try {
            Volunteer volunteer = vr.findById(userId);
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
            Course course = cr.findById(targetId);
            if (course != null) {
                return new CourseAdapter(course);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Event event = er.findById(targetId);
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
            Verb verb = vr.findById(verbId);
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

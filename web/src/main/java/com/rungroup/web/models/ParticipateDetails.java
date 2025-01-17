package com.rungroup.web.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "participate_details")
public class ParticipateDetails extends VerbDetails {
    private String role;

    public ParticipateDetails(Long user_id, String user_type, Long target_id, String target_type, Long verb_id,
            String role) {
        super(user_id, user_type, target_id, target_type, verb_id);
        this.role = role;
    }

    @Override
    public String getInteractionDetails() {
        return getUser().getName() + " participated in " + getTargetAdapter().getTargetName() + " as " + role + " on "
                + created_at + ".";
    }

}

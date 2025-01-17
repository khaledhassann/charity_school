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
@Table(name = "register_details")
public class RegisterDetails extends VerbDetails {
    private String status;

    public RegisterDetails(Long user_id, String user_type, Long target_id, String target_type, Long verb_id,
            String status) {
        super(user_id, user_type, target_id, target_type, verb_id);
        this.status = status;
    }

    @Override
    public String getInteractionDetails() {
        return getUser().getName() + " registered for " + getTargetAdapter().getTargetName() + " with status: " + status
                + " on "
                + created_at + ".";
    }

}

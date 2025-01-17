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
@AllArgsConstructor
@Entity
@Table(name = "teach_details")
public class TeachDetails extends VerbDetails {
    private Long hours_taught;

    public TeachDetails(Long user_id, String user_type, Long target_id, String target_type, Long verb_id,
            Long hours_taught) {
        super(user_id, user_type, target_id, target_type, verb_id);
        this.hours_taught = hours_taught;
    }

    @Override
    public String getInteractionDetails() {
        return getUser().getName() + " taught " + getTargetAdapter().getTargetName() + " for " + hours_taught
                + " hours on "
                + created_at + ".";
    }

}

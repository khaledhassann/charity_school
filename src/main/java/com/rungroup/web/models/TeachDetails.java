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
@Entity
@Table(name = "TeachDetails")
public class TeachDetails extends VerbDetails {
    private Long hoursTaught;

    public TeachDetails(Long userId, Long targetId, Long verbId, Long hoursTaught) {
        super(userId, targetId, verbId);
        this.hoursTaught = hoursTaught;
    }

    @Override
    public String getInteractionDetails() {
        return getUser().getName() + " taught " + getTargetAdapter().getTargetName() + " for " + hoursTaught
                + " hours on "
                + updated_at + ".";
    }

}

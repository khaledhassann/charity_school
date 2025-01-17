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
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "Instagram")
public class Instagram extends Advertisement {
    private String PlatformAlgo;

    public Instagram(String content, String DecoratedAd, String status, LocalDateTime launchDate, Long eventId) {
        super(content, DecoratedAd, status, launchDate, eventId);
    }

    @Override
    public String showAdString() {
        return "Instagram";
    }

    public String InstagramPost() {
        return "";
    }

}
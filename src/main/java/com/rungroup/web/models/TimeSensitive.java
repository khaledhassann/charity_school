package com.rungroup.web.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "time_sensitive")

public class TimeSensitive extends AdDecorator {
    Long ad_id;
    @Transient
    Advertisement ad;

    public TimeSensitive(Advertisement ad) {
        System.out.println("time sensitive constructor called");
        System.out.println(ad.getDecorated_ad());
        this.ad = ad;
        this.ad_id = ad.getId();
        setAd();
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDescription'");
    }

    @Override
    public String showAdString() {
        return "TimeSensitive, " + ad.getDecorated_ad();
    }

    public void setAd() {
        ad.decorated_ad = showAdString();
    }

}

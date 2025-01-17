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
@Table(name = "geo_targetting")

public class GeoTargetting extends AdDecorator {
    Long ad_id;
    String targetLoc;
    String UserLoc;
    @Transient
    Advertisement ad;

    public GeoTargetting(Advertisement ad) {
        System.out.println("geo targetting constructor called");
        System.out.println(ad.getDecorated_ad());
        this.ad = ad;
        this.ad_id = ad.getId();
        setAd();
        System.out.println(ad.decorated_ad);
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDescription'");
    }

    public String showAdString() {
        return "Geo-targetted, " + ad.getDecorated_ad();
    }

    public void setAd() {
        ad.decorated_ad = showAdString();
    }

}
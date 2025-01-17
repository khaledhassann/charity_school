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
@Table(name = "device_targetting")

public class DeviceTargetting extends AdDecorator {

    Long ad_id;
    String targetDevice;
    @Transient
    Advertisement ad;

    public DeviceTargetting(Advertisement ad) {
        System.out.println(" device targetting constructor called");
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

    public String showAdString() {
        return "Device targetted, " + ad.getDecorated_ad();
    }

    public void setAd() {
        ad.decorated_ad = showAdString();
    }

}
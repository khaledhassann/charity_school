package com.rungroup.web.repositories.Implementations;

import java.time.LocalDateTime;

import com.rungroup.web.mappers.GenericMapper;

import com.rungroup.web.models.Advertisement;
import com.rungroup.web.repositories.GenericRepository;

public class AdvertisementRepository extends GenericRepository<Advertisement> {

    public AdvertisementRepository() {
        super("Advertisement", new GenericMapper<Advertisement>(Advertisement.class));
    }
    
    public boolean update (Advertisement entity) {
        // Add the update date explicitly
        entity.setUpdated_at(LocalDateTime.now());
        return super.update(entity);
    }
}
package com.rungroup.web.repositories.Implementations;

import java.time.LocalDateTime;

import com.rungroup.web.mappers.GenericMapper;

import com.rungroup.web.models.GeoTargetting;
import com.rungroup.web.repositories.CachingRepository;

public class GeoTargettingRepository extends CachingRepository<GeoTargetting> {

    public GeoTargettingRepository() {
        super("geo_targetting", new GenericMapper<GeoTargetting>(GeoTargetting.class));
    }

    public boolean update(GeoTargetting entity) {
        // Add the update date explicitly
        entity.setUpdated_at(LocalDateTime.now());
        return super.update(entity);
    }

    public Long insert(GeoTargetting entity) {
        try {
            Long Id = super.insert(entity);
            entity.setId(Id);
            entity.setCreated_at(LocalDateTime.now());
            return Id;
        } catch (Exception e) {
            System.out.println(e);
            return -1L;
        }

    }
}
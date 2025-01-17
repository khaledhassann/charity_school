package com.rungroup.web.repositories.Implementations;

import java.time.LocalDateTime;

import com.rungroup.web.mappers.GenericMapper;

import com.rungroup.web.models.DeviceTargetting;
import com.rungroup.web.repositories.CachingRepository;

public class DeviceTargettingRepository extends CachingRepository<DeviceTargetting> {

    public DeviceTargettingRepository() {
        super("device_targetting", new GenericMapper<DeviceTargetting>(DeviceTargetting.class));
    }

    public boolean update(DeviceTargetting entity) {
        // Add the update date explicitly
        entity.setUpdated_at(LocalDateTime.now());
        return super.update(entity);
    }

    public Long insert(DeviceTargetting entity) {
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
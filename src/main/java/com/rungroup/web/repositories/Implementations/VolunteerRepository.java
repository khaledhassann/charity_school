package com.rungroup.web.repositories.Implementations;

import java.time.LocalDateTime;

import com.rungroup.web.mappers.GenericMapper;

import com.rungroup.web.models.Volunteer;
import com.rungroup.web.repositories.GenericRepository;

public class VolunteerRepository extends GenericRepository<Volunteer> {

    public VolunteerRepository() {
        super("Volunteer", new GenericMapper<Volunteer>(Volunteer.class));
    }

    public boolean update(Volunteer entity) {
        // Add the update date explicitly
        entity.setUpdated_at(LocalDateTime.now());
        return super.update(entity);
    }

    public Long insert(Volunteer entity) {
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
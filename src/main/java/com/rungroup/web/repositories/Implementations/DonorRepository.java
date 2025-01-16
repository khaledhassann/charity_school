package com.rungroup.web.repositories.Implementations;

import java.time.LocalDateTime;

import com.rungroup.web.mappers.GenericMapper;

import com.rungroup.web.models.Donor;
import com.rungroup.web.repositories.GenericRepository;

public class DonorRepository extends GenericRepository<Donor> {

    public DonorRepository() {
        super("Donor", new GenericMapper<Donor>(Donor.class));
    }

    public boolean update(Donor entity) {
        // Add the update date explicitly
        entity.setUpdated_at(LocalDateTime.now());
        return super.update(entity);
    }
}
package com.rungroup.web.repositories.Implementations;

import java.time.LocalDateTime;

import com.rungroup.web.mappers.GenericMapper;

import com.rungroup.web.models.Donor;
import com.rungroup.web.models.TeachDetails;
import com.rungroup.web.repositories.CachingRepository;

public class DonorRepository extends CachingRepository<Donor> {

    public DonorRepository() {
        super("Donor", new GenericMapper<Donor>(Donor.class));
    }
    
    public boolean update (Donor entity) {
        // Add the update date explicitly
        entity.setUpdated_at(LocalDateTime.now());
        return super.update(entity);
    }
    public Long insert(Donor entity) {
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

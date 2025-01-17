package com.rungroup.web.repositories.Implementations;

import java.time.LocalDateTime;

import com.rungroup.web.mappers.GenericMapper;
import com.rungroup.web.models.B;
import com.rungroup.web.models.Donation;
import com.rungroup.web.models.TeachDetails;
import com.rungroup.web.repositories.CachingRepository;

public class DonationRepository extends CachingRepository<Donation> {

    public DonationRepository() {
        super("Donation", new GenericMapper<Donation>(Donation.class));
    }
    
    public boolean update (Donation entity) {
        // Add the update date explicitly
        entity.setUpdated_at(LocalDateTime.now());
        return super.update(entity);
    }
    public Long insert(Donation entity) {
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

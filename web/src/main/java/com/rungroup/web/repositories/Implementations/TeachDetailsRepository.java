package com.rungroup.web.repositories.Implementations;

import java.time.LocalDateTime;

import com.rungroup.web.mappers.GenericMapper;
import com.rungroup.web.models.TeachDetails;
import com.rungroup.web.repositories.CachingRepository;

public class TeachDetailsRepository extends CachingRepository<TeachDetails> {

    public TeachDetailsRepository() {
        super("teach_details", new GenericMapper<TeachDetails>(TeachDetails.class));
    }

    @Override
    public boolean update(TeachDetails entity) {
        // Add the update date explicitly
        entity.setUpdated_at(LocalDateTime.now());
        return super.update(entity);
    }

    public Long insert(TeachDetails entity) {
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
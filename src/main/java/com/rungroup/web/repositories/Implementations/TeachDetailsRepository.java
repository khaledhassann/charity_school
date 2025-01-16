package com.rungroup.web.repositories.Implementations;

import java.time.LocalDateTime;

import com.rungroup.web.mappers.GenericMapper;
import com.rungroup.web.models.TeachDetails;
import com.rungroup.web.repositories.GenericRepository;

public class TeachDetailsRepository extends GenericRepository<TeachDetails> {

    public TeachDetailsRepository() {
        super("TeachDetails", new GenericMapper<TeachDetails>(TeachDetails.class));
    }

    @Override
    public boolean update(TeachDetails entity) {
        // Add the update date explicitly
        entity.setUpdated_at(LocalDateTime.now());
        return super.update(entity);
    }
}
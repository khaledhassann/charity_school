package com.rungroup.web.repositories.Implementations;

import java.time.LocalDateTime;

import com.rungroup.web.mappers.GenericMapper;

import com.rungroup.web.models.Assessment;
import com.rungroup.web.repositories.CachingRepository;

public class AssessmentRepository extends CachingRepository<Assessment> {

    public AssessmentRepository() {
        super("assessment", new GenericMapper<Assessment>(Assessment.class));
    }
    
    public boolean update (Assessment entity) {
        // Add the update date explicitly
        entity.setUpdated_at(LocalDateTime.now());
        return super.update(entity);
    }
    public Long insert(Assessment entity) {
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

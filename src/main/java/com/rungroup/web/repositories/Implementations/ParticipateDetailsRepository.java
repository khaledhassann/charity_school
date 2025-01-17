package com.rungroup.web.repositories.Implementations;

import java.time.LocalDateTime;

import com.rungroup.web.mappers.GenericMapper;
import com.rungroup.web.models.ParticipateDetails;
import com.rungroup.web.repositories.GenericRepository;

public class ParticipateDetailsRepository extends GenericRepository<ParticipateDetails> {

    public ParticipateDetailsRepository() {
        super("participate_details", new GenericMapper<ParticipateDetails>(ParticipateDetails.class));
    }

    @Override
    public boolean update(ParticipateDetails entity) {
        // Add the update date explicitly
        entity.setUpdated_at(LocalDateTime.now());
        return super.update(entity);
    }

    public Long insert(ParticipateDetails entity) {
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
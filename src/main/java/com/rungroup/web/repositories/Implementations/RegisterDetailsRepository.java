package com.rungroup.web.repositories.Implementations;

import java.time.LocalDateTime;

import com.rungroup.web.mappers.GenericMapper;
import com.rungroup.web.models.RegisterDetails;
import com.rungroup.web.repositories.GenericRepository;

public class RegisterDetailsRepository extends GenericRepository<RegisterDetails> {

    public RegisterDetailsRepository() {
        super("register_details", new GenericMapper<RegisterDetails>(RegisterDetails.class));
    }

    @Override
    public boolean update(RegisterDetails entity) {
        // Add the update date explicitly
        entity.setUpdated_at(LocalDateTime.now());
        return super.update(entity);
    }

    public Long insert(RegisterDetails entity) {
        try {
            Long Id = super.insert(entity);
            entity.setId(Id);
            return 1L;
        } catch (Exception e) {
            System.out.println(e);
            return -1L;
        }

    }
}
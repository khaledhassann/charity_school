package com.rungroup.web.repositories.Implementations;

import java.time.LocalDateTime;

import com.rungroup.web.mappers.GenericMapper;

import com.rungroup.web.models.Facebook;
import com.rungroup.web.repositories.GenericRepository;

public class FacebookRepository extends GenericRepository<Facebook> {

    public FacebookRepository() {
        super("facebook", new GenericMapper<Facebook>(Facebook.class));
    }

    public boolean update(Facebook entity) {
        // Add the update date explicitly
        entity.setUpdated_at(LocalDateTime.now());
        return super.update(entity);
    }

    public Long insert(Facebook entity) {
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
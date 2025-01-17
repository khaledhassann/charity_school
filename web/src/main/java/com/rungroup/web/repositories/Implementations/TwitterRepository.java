package com.rungroup.web.repositories.Implementations;

import java.time.LocalDateTime;

import com.rungroup.web.mappers.GenericMapper;

import com.rungroup.web.models.Twitter;
import com.rungroup.web.repositories.CachingRepository;

public class TwitterRepository extends CachingRepository<Twitter> {

    public TwitterRepository() {
        super("twitter", new GenericMapper<Twitter>(Twitter.class));
    }

    public boolean update(Twitter entity) {
        // Add the update date explicitly
        entity.setUpdated_at(LocalDateTime.now());
        return super.update(entity);
    }

    public Long insert(Twitter entity) {
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
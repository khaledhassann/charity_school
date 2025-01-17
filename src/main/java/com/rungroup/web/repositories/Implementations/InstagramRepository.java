package com.rungroup.web.repositories.Implementations;

import java.time.LocalDateTime;

import com.rungroup.web.mappers.GenericMapper;

import com.rungroup.web.models.Instagram;
import com.rungroup.web.repositories.GenericRepository;

public class InstagramRepository extends GenericRepository<Instagram> {

    public InstagramRepository() {
        super("instagram", new GenericMapper<Instagram>(Instagram.class));
    }

    public boolean update(Instagram entity) {
        // Add the update date explicitly
        entity.setUpdated_at(LocalDateTime.now());
        return super.update(entity);
    }

    public Long insert(Instagram entity) {
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
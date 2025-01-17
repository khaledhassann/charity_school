package com.rungroup.web.repositories.Implementations;

import java.time.LocalDateTime;

import com.rungroup.web.mappers.GenericMapper;

import com.rungroup.web.models.TimeSensitive;
import com.rungroup.web.repositories.GenericRepository;

public class TimeSensitiveRepository extends GenericRepository<TimeSensitive> {

    public TimeSensitiveRepository() {
        super("time_sensitive", new GenericMapper<TimeSensitive>(TimeSensitive.class));
    }

    public boolean update(TimeSensitive entity) {
        // Add the update date explicitly
        entity.setUpdated_at(LocalDateTime.now());
        return super.update(entity);
    }

    public Long insert(TimeSensitive entity) {
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
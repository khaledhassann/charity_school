package com.rungroup.web.repositories.Implementations;

import java.time.LocalDateTime;

import com.rungroup.web.mappers.GenericMapper;

import com.rungroup.web.models.Verb;
import com.rungroup.web.repositories.CachingRepository;

public class VerbRepository extends CachingRepository<Verb> {

    public VerbRepository() {
        super("Verb", new GenericMapper<Verb>(Verb.class));
    }

    public boolean update(Verb entity) {
        // Add the update date explicitly
        entity.setUpdated_at(LocalDateTime.now());
        return super.update(entity);
    }

    public Long insert(Verb entity) {
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
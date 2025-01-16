package com.rungroup.web.repositories.Implementations;

import java.time.LocalDateTime;

import com.rungroup.web.mappers.GenericMapper;

import com.rungroup.web.models.Verb;
import com.rungroup.web.repositories.GenericRepository;

public class VerbRepository extends GenericRepository<Verb> {

    public VerbRepository() {
        super("Verb", new GenericMapper<Verb>(Verb.class));
    }

    public boolean update(Verb entity) {
        // Add the update date explicitly
        entity.setUpdated_at(LocalDateTime.now());
        return super.update(entity);
    }
}
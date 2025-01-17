package com.rungroup.web.repositories.Implementations;

import java.time.LocalDateTime;

import com.rungroup.web.mappers.GenericMapper;

import com.rungroup.web.models.B;
import com.rungroup.web.repositories.GenericRepository;

public class BRepository extends GenericRepository<B> {

    public BRepository() {
        super("V", new GenericMapper<B>(B.class));
    }
    
    public boolean update (B entity) {
        // Add the update date explicitly
        entity.setUpdated_at(LocalDateTime.now());
        return super.update(entity);
    }
}

package com.rungroup.web.repositories.Implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;

import com.rungroup.web.mappers.GenericMapper;
import com.rungroup.web.database.DatabaseConfig;

import com.rungroup.web.models.test;
import com.rungroup.web.repositories.GenericRepository;

public class TestRepository extends GenericRepository<test> {

    public TestRepository() {
        super("test", new GenericMapper<test>(test.class));
    }
    
    public boolean update (test entity) {
        // Add the update date explicitly
        entity.setUpdated_at(LocalDateTime.now());
        return super.update(entity);
    }
}

package com.rungroup.web.repositories.Implementations;

import java.time.LocalDateTime;

import com.rungroup.web.mappers.GenericMapper;

import com.rungroup.web.models.Admin;
import com.rungroup.web.repositories.GenericRepository;

public class AdminRepository extends GenericRepository<Admin> {

    public AdminRepository() {
        super("Admin", new GenericMapper<Admin>(Admin.class));
    }

    public boolean update(Admin entity) {
        // Add the update date explicitly
        entity.setUpdated_at(LocalDateTime.now());
        return super.update(entity);
    }
}
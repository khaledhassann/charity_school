package com.rungroup.web.repositories.Implementations;

import java.time.LocalDateTime;

import com.rungroup.web.mappers.GenericMapper;

import com.rungroup.web.models.Teacher;
import com.rungroup.web.repositories.CachingRepository;

public class TeacherRepository extends CachingRepository<Teacher> {

    public TeacherRepository() {
        super("Teacher", new GenericMapper<Teacher>(Teacher.class));
    }
    
    public boolean update (Teacher entity) {
        // Add the update date explicitly
        entity.setUpdated_at(LocalDateTime.now());
        return super.update(entity);
    }
}

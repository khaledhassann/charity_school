package com.rungroup.web.repositories.Implementations;

import java.time.LocalDateTime;

import com.rungroup.web.mappers.GenericMapper;

import com.rungroup.web.models.Course;
import com.rungroup.web.repositories.GenericRepository;

public class CourseRepository extends GenericRepository<Course> {

    public CourseRepository() {
        super("Course", new GenericMapper<Course>(Course.class));
    }
    
    public boolean update (Course entity) {
        // Add the update date explicitly
        entity.setUpdated_at(LocalDateTime.now());
        return super.update(entity);
    }
}

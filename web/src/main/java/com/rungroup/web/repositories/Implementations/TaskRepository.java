package com.rungroup.web.repositories.Implementations;

import java.time.LocalDateTime;

import com.rungroup.web.mappers.GenericMapper;

import com.rungroup.web.models.Task;
import com.rungroup.web.repositories.GenericRepository;

public class TaskRepository extends GenericRepository<Task> {

    public TaskRepository() {
        super("Task", new GenericMapper<Task>(Task.class));
    }
    
    public boolean update (Task entity) {
        // Add the update date explicitly
        entity.setUpdated_at(LocalDateTime.now());
        return super.update(entity);
    }

    public Long insert (Task entity){
        try{
            Long Id = super.insert(entity);
            entity.setId(Id);
            return Id;
        }catch(Exception e){
            System.out.println(e);
            return -1L;
        }

    }
}
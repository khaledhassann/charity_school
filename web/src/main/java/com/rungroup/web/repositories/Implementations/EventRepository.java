package com.rungroup.web.repositories.Implementations;

import java.time.LocalDateTime;

import com.rungroup.web.mappers.GenericMapper;
import com.rungroup.web.models.B;
import com.rungroup.web.models.Event;
import com.rungroup.web.repositories.GenericRepository;

public class EventRepository extends GenericRepository<Event> {

    public EventRepository() {
        super("Event", new GenericMapper<Event>(Event.class));
    }
    
    public boolean update (Event entity) {
        // Add the update date explicitly
        entity.setUpdated_at(LocalDateTime.now());
        return super.update(entity);
    }
    public Long insert (Event entity){
        try{
            Long Id = super.insert(entity);
            entity.setId(Id);
            return 1L;
        }catch(Exception e){
            System.out.println(e);
            return -1L;
        }

    }
}

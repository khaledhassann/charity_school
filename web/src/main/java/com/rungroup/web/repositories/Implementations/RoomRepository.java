package com.rungroup.web.repositories.Implementations;

import java.time.LocalDateTime;

import com.rungroup.web.mappers.GenericMapper;

import com.rungroup.web.models.Room;
import com.rungroup.web.models.TeachDetails;
import com.rungroup.web.repositories.CachingRepository;

public class RoomRepository extends CachingRepository<Room> {

    public RoomRepository() {
        super("Room", new GenericMapper<Room>(Room.class));
    }
    
    public boolean update (Room entity) {
        // Add the update date explicitly
        entity.setUpdated_at(LocalDateTime.now());
        return super.update(entity);
    }
    public Long insert(Room entity) {
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

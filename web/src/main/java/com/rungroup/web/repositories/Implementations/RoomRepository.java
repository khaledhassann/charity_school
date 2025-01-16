package com.rungroup.web.repositories.Implementations;

import java.time.LocalDateTime;

import com.rungroup.web.mappers.GenericMapper;

import com.rungroup.web.models.Room;
import com.rungroup.web.repositories.GenericRepository;

public class RoomRepository extends GenericRepository<Room> {

    public RoomRepository() {
        super("Room", new GenericMapper<Room>(Room.class));
    }
    
    public boolean update (Room entity) {
        // Add the update date explicitly
        entity.setUpdated_at(LocalDateTime.now());
        return super.update(entity);
    }
}

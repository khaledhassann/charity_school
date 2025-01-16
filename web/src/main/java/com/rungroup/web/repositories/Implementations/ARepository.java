package com.rungroup.web.repositories.Implementations;

import java.time.LocalDateTime;

import com.rungroup.web.mappers.GenericMapper;

import com.rungroup.web.models.A;
import com.rungroup.web.repositories.GenericRepository;

public class ARepository extends GenericRepository<A> {

    public ARepository() {
        super("A", new GenericMapper<A>(A.class));
    }
    
    public boolean update (A entity) {
        // Add the update date explicitly
        entity.setUpdated_at(LocalDateTime.now());
        return super.update(entity);
    }

    public Long insert (A entity){
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

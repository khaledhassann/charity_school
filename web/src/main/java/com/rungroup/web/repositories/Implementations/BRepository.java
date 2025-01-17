package com.rungroup.web.repositories.Implementations;

import java.time.LocalDateTime;

import com.rungroup.web.mappers.GenericMapper;

import com.rungroup.web.models.B;
import com.rungroup.web.repositories.GenericRepository;

public class BRepository extends GenericRepository<B> {

    public BRepository() {
        super("B", new GenericMapper<B>(B.class));
    }
    
    public boolean update (B entity) {
        // Add the update date explicitly
        entity.setUpdated_at(LocalDateTime.now());
        return super.update(entity);
    }

    public Long insert (B entity){
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
// package com.rungroup.web.repositories.Implementations;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.stereotype.Repository;

// import com.rungroup.web.models.B;

// import java.util.List;

// @Repository
// public interface BRepository extends JpaRepository<B, Long> {

//     // No need to implement CRUD operations here, as they are already provided by JpaRepository
//     // However, we can add custom query methods here if needed
// }
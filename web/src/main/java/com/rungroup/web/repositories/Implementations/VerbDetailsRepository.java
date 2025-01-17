// package com.rungroup.web.repositories.Implementations;

// import java.time.LocalDateTime;

// import com.rungroup.web.mappers.GenericMapper;

// import com.rungroup.web.models.VerbDetails;
// import com.rungroup.web.repositories.CachingRepository;

// public class VerbDetailsRepository extends CachingRepository<VerbDetails> {

//     public VerbDetailsRepository() {
//         super("VerbDetails", new GenericMapper<VerbDetails>(VerbDetails.class));
//     }
    
//     public boolean update (VerbDetails entity) {
//         // Add the update date explicitly
//         entity.setUpdated_at(LocalDateTime.now());
//         return super.update(entity);
//     }
// }

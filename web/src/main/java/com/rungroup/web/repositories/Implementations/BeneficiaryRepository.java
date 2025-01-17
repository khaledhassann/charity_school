package com.rungroup.web.repositories.Implementations;

import java.time.LocalDateTime;

import com.rungroup.web.mappers.GenericMapper;

import com.rungroup.web.models.Beneficiary;
import com.rungroup.web.repositories.GenericRepository;

public class BeneficiaryRepository extends GenericRepository<Beneficiary> {

    public BeneficiaryRepository() {
        super("Beneficiary", new GenericMapper<Beneficiary>(Beneficiary.class));
    }
    
    public boolean update (Beneficiary entity) {
        // Add the update date explicitly
        entity.setUpdated_at(LocalDateTime.now());
        return super.update(entity);
    }

    public Long insert (Beneficiary entity){
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
package com.rungroup.web.repositories;

import com.rungroup.web.mappers.GenericMapper;

import java.util.*;

public class CachingRepository<T> extends GenericRepository<T> {

    private final Map<Long, T> cache = new HashMap<>();
    private List<T> allEntitiesCache;

    public CachingRepository(String tableName, GenericMapper<T> mapper) {
        super(tableName, mapper);
    }

    @Override
    public T findById(Long id) {
        // Check cache first
        if (cache.containsKey(id)) {
            return cache.get(id);
        }

        // Fetch from DB and cache the result
        T entity = super.findById(id);
        if (entity != null) {
            cache.put(id, entity);
        }
        return entity;
    }

    @Override
    public List<T> findAll() {
        // Return cached list if available
        if (allEntitiesCache != null) {
            return allEntitiesCache;
        }

        // Fetch from DB and cache the result
        allEntitiesCache = super.findAll();
        return allEntitiesCache;
    }

    @Override
    public Long insert(T entity) {
        Long id = super.insert(entity);
        if (id != null && id > 0) {
            cache.put(id, entity);
            allEntitiesCache = null; // Invalidate cache
        }
        return id;
    }

    @Override
    public boolean update(T entity) {
        boolean updated = super.update(entity);
        if (updated) {
            Long id = getEntityId(entity);
            if (id != null) {
                cache.put(id, entity);
                allEntitiesCache = null; // Invalidate cache
            }
        }
        return updated;
    }

    @Override
    public boolean deleteById(Long id) {
        boolean deleted = super.deleteById(id);
        if (deleted) {
            cache.remove(id);
            allEntitiesCache = null; // Invalidate cache
        }
        return deleted;
    }

    private Long getEntityId(T entity) {
        try {
            return (Long) entity.getClass().getMethod("getId").invoke(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

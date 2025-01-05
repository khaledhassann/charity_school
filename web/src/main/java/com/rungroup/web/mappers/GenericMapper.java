package com.rungroup.web.mappers;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.StringJoiner;

public class GenericMapper<T> {
    private final Class<T> entityClass;

    public GenericMapper(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    
    public String toInsertQuery(T entity) {
        StringBuilder query = new StringBuilder();
        StringJoiner columns = new StringJoiner(", ");
        StringJoiner values = new StringJoiner(", ");

        query.append("INSERT INTO ").append(getTableName()).append(" (");

        for (Field field : entityClass.getDeclaredFields()) {
            field.setAccessible(true); // Allows access to private fields
            try {
                if (field.get(entity) != null && !field.isAnnotationPresent(jakarta.persistence.Id.class)) {
                    columns.add(field.getName());
                    values.add(formatValue(field.get(entity)));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        query.append(columns).append(") VALUES (").append(values).append(");");
        return query.toString();
    }

    
    public String toUpdateQuery(T entity) {
        StringBuilder query = new StringBuilder();
        StringJoiner setClause = new StringJoiner(", ");
        Object idValue = null;

        query.append("UPDATE ").append(getTableName()).append(" SET ");

        for (Field field : entityClass.getDeclaredFields()) {
            field.setAccessible(true);
            try {
                if (field.isAnnotationPresent(jakarta.persistence.Id.class)) {
                    idValue = field.get(entity);
                } else if (field.get(entity) != null) {
                    setClause.add(field.getName() + " = " + formatValue(field.get(entity)));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        if (idValue == null) {
            throw new IllegalStateException("ID field must not be null for UPDATE queries.");
        }

        query.append(setClause).append(" WHERE id = ").append(formatValue(idValue)).append(";");
        return query.toString();
    }

    
    public T fromResultSet(ResultSet rs) {
        try {
            T entity = entityClass.getDeclaredConstructor().newInstance();

            for (Field field : entityClass.getDeclaredFields()) {
                field.setAccessible(true);
                try {
                    Object value = rs.getObject(field.getName(), field.getType());
                    field.set(entity, value);
                } catch (SQLException ignored) {
                    // Ignore fields not in the ResultSet
                }
            }
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to map ResultSet to entity.");
        }
    }

    private String getTableName() {
        if (entityClass.isAnnotationPresent(jakarta.persistence.Table.class)) {
            return entityClass.getAnnotation(jakarta.persistence.Table.class).name();
        }
        return entityClass.getSimpleName().toLowerCase();
    }

    private String formatValue(Object value) {
        if (value instanceof String || value instanceof LocalDateTime) {
            return "'" + value.toString() + "'";
        }
        return value.toString();
    }
}

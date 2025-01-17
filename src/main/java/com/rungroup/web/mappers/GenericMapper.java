package com.rungroup.web.mappers;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

import jakarta.persistence.Column;
import jakarta.persistence.Transient;

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

        // for (Field field : entityClass.getDeclaredFields()) {
        // field.setAccessible(true); // Allows access to private fields
        // try {
        // if (field.get(entity) != null &&
        // !field.isAnnotationPresent(jakarta.persistence.Id.class)) {
        // columns.add(field.getName());
        // values.add(formatValue(field.get(entity)));
        // }
        // } catch (IllegalAccessException e) {
        // e.printStackTrace();
        // }
        // }
        for (Field field : getAllFields(entityClass)) {
            field.setAccessible(true); // Allows access to private fields
            try {

                // Skip fields annotated with @Transient
                if (field.isAnnotationPresent(Transient.class)) {
                    continue;
                }
                // Get the column name from the @Column annotation or the field name
                Column columnAnnotation = field.getAnnotation(Column.class);
                if (field.get(entity) != null && !field.isAnnotationPresent(jakarta.persistence.Id.class)) {
                    columns.add(columnAnnotation != null ? columnAnnotation.name() : field.getName());
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

        for (Field field : getAllFields(entityClass)) {
            field.setAccessible(true);
            try {
                // Skip fields annotated with @Transient
                if (field.isAnnotationPresent(Transient.class)) {
                    continue;
                }
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
            ResultSetMetaData metaData = rs.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                System.out.println("Column: " + metaData.getColumnName(i));
            }
            // Traverse all fields, including inherited ones
            for (Field field : getAllFields(entityClass)) {
                field.setAccessible(true);

                // Skip fields annotated with @Transient
                if (field.isAnnotationPresent(Transient.class)) {
                    continue;
                }

                // Get the column name from the @Column annotation or the field name
                Column columnAnnotation = field.getAnnotation(Column.class);
                String columnName = columnAnnotation != null ? columnAnnotation.name() : field.getName();

                try {
                    // Check if the column exists in the ResultSet
                    if (columnExists(rs, columnName)) {
                        Object value = rs.getObject(columnName);
                        if (value != null && field.getType().equals(LocalDateTime.class)
                                && value instanceof Timestamp) {
                            value = ((Timestamp) value).toLocalDateTime();
                        }
                        // System.out.println("Setting field: " + field.getName() +
                        // ", Type: " + field.getType().getName() +
                        // ", Value: " + value +
                        // ", Value Type: " + (value != null ? value.getClass().getName() : "null"));

                        field.set(entity, value);
                    }
                } catch (SQLException e) {
                    // Handle column type mismatches or missing columns gracefully
                    System.err.println("Error mapping field: " + field.getName() + " - " + e.getMessage());
                }
            }
            // System.out.println(entity);
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to map ResultSet to entity.");
        }
    }

    private static boolean columnExists(ResultSet rs, String columnName) {
        try {
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                if (metaData.getColumnName(i).equalsIgnoreCase(columnName)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
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

    private static List<Field> getAllFields(Class<?> entityClass) {
        List<Field> fields = new ArrayList<>();

        // Traverse the class hierarchy
        while (entityClass != null) {
            Field[] declaredFields = entityClass.getDeclaredFields();
            Collections.addAll(fields, declaredFields);
            entityClass = entityClass.getSuperclass();

        }

        return fields;
    }

}
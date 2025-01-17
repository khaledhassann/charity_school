package com.rungroup.web.repositories;

import com.rungroup.web.database.DatabaseConfig;
import com.rungroup.web.mappers.GenericMapper;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GenericRepository<T> {

    private final DatabaseConfig database;
    private final String tableName;
    private final GenericMapper<T> mapper;

    public GenericRepository(String tableName, GenericMapper<T> mapper) {
        this.database = DatabaseConfig.getInstance();
        // this.connection = connection;
        this.tableName = tableName;
        this.mapper = mapper;
    }

    public Long insert(T entity) {
        Long generatedId = null;
        try {
            // Generate SQL INSERT query
            String InsertQuery = mapper.toInsertQuery(entity);
            System.out.println("Insert Query: " + InsertQuery);

            // Get DB connection
            Connection connection = database.getConnection();

            // Prepare the statement to return generated keys
            PreparedStatement stmt = connection.prepareStatement(InsertQuery, Statement.RETURN_GENERATED_KEYS);

            // Execute the query (INSERT)
            stmt.executeUpdate();

            // Retrieve the generated keys (ID)
            ResultSet generatedKeys = stmt.getGeneratedKeys();

            // If the query generated keys, get the first one (the ID)
            if (generatedKeys.next()) {
                generatedId = generatedKeys.getLong(1);
                setId(entity, generatedId); // Use reflection to set the ID
                // Retrieve the inserted entity from the database
                T insertedEntity = findById(generatedId);
                if (insertedEntity != null) {
                    // Update the runtime object with the retrieved data
                    updateRuntimeObject(entity, insertedEntity);
                }

            }

            // Close resources
            generatedKeys.close();
            stmt.close();
            // connection.close();

        } catch (Exception e) {
            System.out.println(e);
            generatedId = -32L; // Return a specific error code if an exception occurs
        }

        // Return the generated ID or an error code
        return generatedId;
    }

    public boolean update(T entity) {
        try {
            // Generate SQL UPDATE query
            String updateQuery = mapper.toUpdateQuery(entity);
            System.out.println("Update Query: " + updateQuery);

            // Execute UPDATE query
            // Get db connection
            Connection connection = database.getConnection();
            PreparedStatement stmt = connection.prepareStatement(updateQuery);
            // Execute the query
            stmt.executeQuery();

            // Retrieve the updated entity from the database
            T updatedEntity = findById(getId(entity));
            if (updatedEntity != null) {
                // Update the runtime object with the retrieved data
                updateRuntimeObject(entity, updatedEntity);
            }

            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        // finally {

        // // Clean up
        // database.close();
        // }
    }

    public T findById(Long id) {
        // Returns a 'test' object if it exists in the database
        try {
            String query = "SELECT * FROM " + tableName + " WHERE id = " + id;
            System.out.println("findById Query: " + query);
            // Execute query
            // Get db connection
            Connection connection = database.getConnection();
            PreparedStatement stmt = connection.prepareStatement(query);
            // Execute the query
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Mapper that converts ResultSet to a 'test' object
                return this.mapper.fromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // finally {

        // // Clean up
        // database.close();
        // }
        return null;
    }

    public List<T> findAll() {
        // Returns a list of 'test' objects
        List<T> entities = new ArrayList<>();
        try {
            String query = "SELECT * FROM " + tableName;

            // Execute query
            // Get db connection
            Connection connection = database.getConnection();
            PreparedStatement stmt = connection.prepareStatement(query);
            // Execute the query
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // Mapper that converts ResultSet to a 'test' object
                entities.add(this.mapper.fromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // finally {

        // // Clean up
        // database.close();
        // }
        return entities;
    }

    public boolean deleteById(Long id) {
        // Deletes a 'test' object
        try {
            String query = "DELETE FROM " + tableName + " WHERE id = " + id;
            System.err.println("Delete query: " + query);
            // Execute query
            // Get db connection
            Connection connection = database.getConnection();
            PreparedStatement stmt = connection.prepareStatement(query);
            // Execute the query
            stmt.executeQuery();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        // finally {

        // // Clean up
        // database.close();
        // }
    }

    private void updateRuntimeObject(T runtimeObject, T databaseObject) {
        // Use reflection to update the fields of the runtime object with the fields of
        // the database object
        for (Field field : runtimeObject.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                field.set(runtimeObject, field.get(databaseObject));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private void setId(T entity, Long id) {
        try {
            Field idField = getIdField(entity.getClass());
            idField.setAccessible(true);
            idField.set(entity, id);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private Long getId(T entity) {
        try {
            Field idField = getIdField(entity.getClass());
            idField.setAccessible(true);
            return (Long) idField.get(entity);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Field getIdField(Class<?> clazz) throws NoSuchFieldException {
        while (clazz != null) {
            try {
                return clazz.getDeclaredField("id");
            } catch (NoSuchFieldException e) {
                clazz = clazz.getSuperclass();
            }
        }
        throw new NoSuchFieldException("No field named 'id' found in class hierarchy");
    }

}
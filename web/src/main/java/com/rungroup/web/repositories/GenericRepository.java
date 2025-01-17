package com.rungroup.web.repositories;

import com.rungroup.web.database.DatabaseConfig;
import com.rungroup.web.mappers.GenericMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GenericRepository<T>{

    protected final DatabaseConfig database;
    protected final String tableName;
    protected final GenericMapper<T> mapper;

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
            }
            
            // Close resources
            generatedKeys.close();
            stmt.close();
            //connection.close();
            
        } catch (Exception e) {
            System.out.println(e);
            generatedId = -32L; // Return a specific error code if an exception occurs
        }
        
        // Return the generated ID or an error code
        return generatedId;
    }

    public boolean update (T entity) {
        try{
            // Generate SQL UPDATE query
            String updateQuery = mapper.toUpdateQuery(entity);
            System.out.println("Update Query: " + updateQuery);

            // Execute UPDATE query
            //   Get db connection 
            Connection connection = database.getConnection();
            PreparedStatement stmt = connection.prepareStatement(updateQuery);
            //   Execute the query
            stmt.executeQuery();

            return true;
        }
        catch (Exception e){
            System.out.println(e);
            return false;
        }
        // finally {
            
        //     //  Clean up
        //     database.close();
        // }
    }
    
    public T findById(Long id) {
        // Returns a 'test' object if it exists in the database
        try {
            String query = "SELECT * FROM " + tableName + " WHERE id = " + id;
            System.out.println("findById Query: " + query);
            // Execute query
            //   Get db connection 
            Connection connection = database.getConnection();
            PreparedStatement stmt = connection.prepareStatement(query);
            //   Execute the query
            ResultSet rs = stmt.executeQuery();


            if (rs.next()) {
                // Mapper that converts ResultSet to a 'test' object
                return this.mapper.fromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // finally {
            
        //     //  Clean up
        //     database.close();
        // }
        return null;
    }

    
    public List<T> findAll() {
        // Returns a list of 'test' objects
        List<T> entities = new ArrayList<>();
        try {
            String query = "SELECT * FROM " + tableName;

            // Execute query
            //   Get db connection 
            Connection connection = database.getConnection();
            PreparedStatement stmt = connection.prepareStatement(query);
            //   Execute the query
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // Mapper that converts ResultSet to a 'test' object
                entities.add(this.mapper.fromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // finally {
            
        //     //  Clean up
        //     database.close();
        // }
        return entities;
    }

    
    public boolean deleteById(Long id) {
        // Deletes a 'test' object
        try {
            String query = "DELETE FROM " + tableName + " WHERE id = " + id;
            System.err.println("Delete query: " + query);
            // Execute query
            //   Get db connection 
            Connection connection = database.getConnection();
            PreparedStatement stmt = connection.prepareStatement(query);
            //   Execute the query
            stmt.executeQuery();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
        // finally {
            
        //     //  Clean up
        //     database.close();
        // }
    }

}

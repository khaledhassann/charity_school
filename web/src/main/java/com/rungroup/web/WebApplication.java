package com.rungroup.web;

import java.sql.Connection;
import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rungroup.web.models.test;
import com.rungroup.web.repositories.Implementations.TestRepository;

@SpringBootApplication
public class WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
		
        TestRepository testRepository = new TestRepository();

        testCreate(testRepository);
        testRead(testRepository);
        testUpdate(testRepository);
        testDelete(testRepository);

    }

    private static void testCreate(TestRepository testRepository) {
        // Create
        test newTestObj = new test();
        newTestObj.setName("John Doeeeeeeeee");
        newTestObj.setEmail("john.doe@example.com");
        newTestObj.setAge(30);
        testRepository.insert(newTestObj);
    }

    private static void testRead(TestRepository testRepository) {
        // Read
        test retrievedTest = testRepository.findById(1L);
        System.out.println("The retrieved object:\n" + retrievedTest);

        // Read All
        testRepository.findAll().forEach(System.out::println);
    }

    private static void testUpdate(TestRepository testRepository) {
        // Update
        test updatedTestObj = new test();
        updatedTestObj.setId(1L);
        updatedTestObj.setName("John Adham 5");
        updatedTestObj.setEmail("john.Adham@example.com");
        updatedTestObj.setAge(35);
        testRepository.update(updatedTestObj);
    }

    private static void testDelete(TestRepository testRepository) {
        // Delete
        testRepository.deleteById(13L);
	}


}

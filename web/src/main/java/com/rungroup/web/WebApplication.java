package com.rungroup.web;

import java.sql.Connection;
import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rungroup.web.models.*;
import com.rungroup.web.repositories.Implementations.*;

@SpringBootApplication
public class WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
		
        // TestRepository testRepository = new TestRepository();

        // testCreate(testRepository);
        // testRead(testRepository);
        // testUpdate(testRepository);
        // testDelete(testRepository);
        // CourseRepository courseRepository = new CourseRepository(); // Ensure proper initialization
        // createCourses(courseRepository);

    }

    private static void createCourses(CourseRepository courseRepository) {
        // List of courses to be created
        String[][] courseData = {
            {"History", "Explore ancient civilizations and key historical events.", "/images/A1VqnK8cuLL._AC_UF1000,1000_QL80_.jpg", "3", "1", "0.0"},
            {"Science", "Delve into the wonders of the natural world with engaging experiments.", "/images/science.jpg", "4", "2", "0.0"},
            {"Maths", "Master mathematical concepts and improve your problem-solving skills.", "/images/maths.jpg", "3", "3", "0.0"},
            {"English", "Master the language of global communication.", "/images/learning-english-doodle-set-language-school-in-sketch-style-online-language-education-course-hand-drawn-illustration-isolated-on-white-background-vector.jpg", "2", "4", "0.0"},
            {"French", "Learn the beautiful language of French culture and diplomacy.", "/images/french-language-hand-drawn-doodles-lettering-french-language-hand-drawn-doodles-lettering-language-education-vector-137829160.webp", "2", "5", "0.0"},
            {"Arabic", "Dive into the rich and ancient language of Arabic.", "/images/1634038961-arabic.jpg", "3", "6", "0.0"}
        };

        for (String[] data : courseData) {
            Course course = new Course();
            course.setName(data[0]);
            course.setDescription(data[1]);
            course.setImage_url(data[2]);
            course.setCredits(Integer.parseInt(data[3]));
            course.setTime_slot(Integer.parseInt(data[4]));
            course.setProgress(Double.parseDouble(data[5]));

            // Insert the course into the database
            courseRepository.insert(course);
            System.out.println("Inserted course: " + course.getName());
        }
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

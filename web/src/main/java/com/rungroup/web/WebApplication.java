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
        // EventRepository eventRepository = new EventRepository();
        // createEvents( eventRepository);

    }
    private static void createEvents(EventRepository eventRepository) {
        // List of events to be created
        String[][] eventData = {
            {"Tech Conference 2025", "A conference to discuss advancements in technology.", "https://example.com/images/tech.jpg", "2025-05-15T10:00", "Cairo International Conference Center"},
            {"Art Exhibition", "Explore the work of talented local artists.", "https://example.com/images/art.jpg", "2025-03-10T15:00", "Downtown Art Gallery"},
            {"Music Festival", "Enjoy live performances from top artists.", "https://example.com/images/music.jpg", "2025-06-20T18:30", "City Park"},
            {"Charity Marathon", "Run for a cause and help raise funds for charity.", "https://example.com/images/marathon.jpg", "2025-04-25T07:00", "Main Street"},
            {"Startup Pitch Night", "An opportunity for startups to pitch their ideas to investors.", "https://example.com/images/pitch.jpg", "2025-07-15T19:00", "Tech Hub Auditorium"}
        };
    
        for (String[] data : eventData) {
            Event event = new Event();
            event.setName(data[0]);
            event.setDescription(data[1]);
            event.setImage_url(data[2]);
            event.setDate(LocalDateTime.parse(data[3])); // Parsing the ISO 8601 date string
            event.setLocation(data[4]);
    
            // Insert the event into the database
            eventRepository.insert(event);
            System.out.println("Inserted event: " + event.getName());
        }
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

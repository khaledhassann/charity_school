package com.rungroup.web;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

// import com.rungroup.web.mappers.BService;
import com.rungroup.web.models.*;
import com.rungroup.web.repositories.Implementations.*;

@SpringBootApplication(scanBasePackages = "com.rungroup.web.*")
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
        // createEvents(eventRepository);
        // RoomRepository roomRepository = new RoomRepository();
        // createRooms( roomRepository);
        // BRepository r = new BRepository();
        // B b = new B();
        // b.setB_SPECIFIC(1);
        // b.setA(0);
        // r.insert(b);
        // TeacherRepository tr = new TeacherRepository();
        // createTeachers(tr);

        // B b1 = new B();
        // b1.setB_SPECIFIC(80);

        // B b2 = new B();
        // b2.setB_SPECIFIC(80);

        // B b3 = new B();
        // b3.setB_SPECIFIC(80);

        // Event e1 = new Event();
        // e1.setImage_url("ss");
        // Event e2 = new Event();
        // e2.setImage_url("ss");
        // Event e3 = new Event();
        // e3.setImage_url("ss");
        // EventRepository er = new EventRepository();
        // er.insert(e1);
        // er.insert(e2);
        // er.insert(e3);


        // BRepository br = new BRepository();
        // br.insert(b1);
        // br.insert(b2);
        // br.insert(b3);

        // A a = new A();
        // List<B> bList = new ArrayList<>();
        // bList.add(b1);
        // bList.add(b2);
        // bList.add(b3);
        // a.setBlist(bList);

        // ARepository ar = new ARepository();
        // ar.insert(a);
        // B b = new B();
        // b.setSkills(List.of("Skill1", "Skill2", "Skill3"));
        // BRepository br = new BRepository();
        // Long id = br.insert(b);
        // System.out.println("BABABABA: " +  id);

        // B b2 = br.findById(id);
        // System.out.println("B2: " + b2);
        // System.out.println("ID: " + b2.getId());
        // System.out.println("Created at: " + b2.getCreated_at());
        // System.out.println("Updated at: " + b2.getUpdated_at());
        // System.out.println("B_SPECIFIC: " + b2.getB_SPECIFIC());
        // System.out.println("Skills: " + b2.getSkills());
        // BeneficiaryRepository br = new BeneficiaryRepository();
        // Beneficiary b1 = new Beneficiary();
        // b1.setEmail("7a7a");
        // br.insert(b1);
        // br.findAll();
        // br.findAll();

    }

    private static void createTeachers(TeacherRepository tr) {
        // List of teachers to be created
        Object[][] teacherData = {
            {"Laila Ihab", "Science", "/images/laila.jpeg"},
            {"Mariam Sameh", "History", "/images/habiba.jpeg"},
            {"Habiba Yasser", "Maths", "/images/mariam.jpeg"}
        };

        for (Object[] data : teacherData) {
            Teacher teacher = new Teacher();//(String) data[0], (String) data[1], (String) data[2]);
            teacher.setName((String) data[0]);
            teacher.setSubject((String) data[1]);
            teacher.setImage_url((String) data[2]);
            tr.insert(teacher); 
        }
    }

    private static void createRooms(RoomRepository roomRepository) {
        // List of rooms to be created
        Object[][] roomData = {
            {"Conference Room A", 50, new String[] {"Projector", "Whiteboard", "Wi-Fi"}},
            {"Meeting Room B", 20, new String[] {"Whiteboard", "Teleconferencing"}},
            {"Workshop Room C", 30, new String[] {"Wi-Fi", "Sound System"}},
            {"Training Room D", 40, new String[] {"Computers", "Wi-Fi", "Projector"}},
            {"Event Hall E", 100, new String[] {"Stage", "Sound System", "Lighting"}}
        };
    
        for (Object[] data : roomData) {
            Room room = new Room();
            room.setName((String) data[0]);
            room.setCapacity((int) data[1]);
    
            // Populate the amendments list using the addAmendment method
            for (String amendment : (String[]) data[2]) {
                room.addAmendment(amendment);
            }
            
            System.out.println("Room: " + room.getAmendments());
            // Insert the room into the database
            roomRepository.insert(room);
            System.out.println("Inserted room: " + room.getName());
        }
    }
    
    private static void createEvents(EventRepository eventRepository) {
        // List of events to be created
        String[][] eventData = {
            {"Science Fair", "Exciting experiments await!", "/images/science fair.jpg", "2025-05-15T10:00", "Cairo International Conference Center"},
            {"History Exhibition", "Interactive history event.", "/images/National_Museum5.jpg", "2025-03-10T15:00", "Downtown Art Gallery"},
            {"Math Competition", "Challenge your math skills.", "/images/free-educational-vector-collection.jpg", "2025-06-20T18:30", "City Park"},
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

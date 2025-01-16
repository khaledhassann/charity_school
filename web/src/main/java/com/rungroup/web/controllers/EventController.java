// package com.rungroup.web.controllers;

// import com.rungroup.web.models.Event;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.*;
// import org.springframework.web.multipart.MultipartFile;

// import java.io.File;
// import java.io.IOException;
// import java.time.LocalDateTime;
// import java.util.ArrayList;
// import java.util.List;

// @Controller
// public class EventController {

//     private static long idCounter = 1L;

//     private synchronized long generateId() {
//         return idCounter++;
//     }

//     private List<Event> createdEvents = new ArrayList<>();

//     @GetMapping("/create-event")
//     public String showCreateEventForm(Model model) {
//         model.addAttribute("event", new Event());
//         return "create-event";
//     }

//     @PostMapping("/create-event")
// public String createEvent(
//         @RequestParam("name") String name,
//         @RequestParam("description") String description,
//         @RequestParam("date") LocalDateTime date,
//         @RequestParam("location") String location,
//         @RequestParam("imageFile") MultipartFile imageFile,
//         Model model) {
//     try {
//         String uploadsDir = "D:\\Semester 9\\SDP\\SDP_project\\web\\src\\main\\resources\\static\\images\\";
//         String originalFilename = imageFile.getOriginalFilename();
//         File file = new File(uploadsDir + originalFilename);

//         if (!file.exists()) {
//             file.getParentFile().mkdirs();
//             imageFile.transferTo(file);
//         }

//         long generatedId = generateId();

//         Event newEvent = new Event();
//         newEvent.setId(generatedId);
//         newEvent.setName(name);
//         newEvent.setDescription(description);
//         newEvent.setDate(date);
//         newEvent.setLocation(location);
//         newEvent.setimage_url("/images/" + originalFilename);

//         createdEvents.add(newEvent);

//         // Add success message
//         model.addAttribute("message", "Event created successfully!");

//         // Add event details to the model for display
//         model.addAttribute("eventDetails", newEvent);

//         // Print all attributes in the model
//         System.out.println("Model Attributes:");
//         model.asMap().forEach((key, value) -> System.out.println(key + " : " + value));

//     } catch (IOException e) {
//         System.out.println("error");
//         model.addAttribute("error", "Error uploading image: " + e.getMessage());
//         return "create-event";
//     }

//     return "create-event";
// }

// }
package com.rungroup.web.controllers;

import com.rungroup.web.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.rungroup.web.repositories.Implementations.AdvertisementRepository;
import com.rungroup.web.repositories.Implementations.EventRepository;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Controller
public class EventController {

    private EventRepository EventsRepository = new EventRepository();
    // Make createdEvents public static so it can be accessed by AdvertisementController
    public static List<Event> createdEvents = new ArrayList<>();

    public EventController(){
        // Pull the list of the available courses from the database
        createdEvents = EventsRepository.findAll();
        createdEvents.forEach(event -> System.out.println("Available events: " + event));
    }
    
    // private synchronized long generateId() {
    //     return idCounter++;
    // }

    @GetMapping("/create-event")
    public String showCreateEventForm(Model model) {
        model.addAttribute("event", new Event());
        return "create-event";
    }

    @PostMapping("/create-event")
    public String createEvent(
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("date") String date,
            @RequestParam("location") String location,
            @RequestParam("imageFile") MultipartFile imageFile,
            Model model) {
        try {
            String uploadsDir = "D:\\ASU\\sem 9\\SDP\\PROJECT_FINAL\\web\\src\\main\\resources\\static\\images\\";
            String originalFilename = imageFile.getOriginalFilename();
            File file = new File(uploadsDir + originalFilename);

            if (!file.exists()) {
                file.getParentFile().mkdirs();
                imageFile.transferTo(file);
            }


            Event newEvent = new Event();
            newEvent.setName(name);
            newEvent.setDescription(description);
            newEvent.setDate(LocalDateTime.parse(date));
            newEvent.setLocation(location);
            newEvent.setImage_url("/images/" + originalFilename);

            createdEvents.add(newEvent);  // This will now be accessible by AdvertisementController
            EventsRepository.insert(newEvent);
            model.addAttribute("message", "Event created successfully!");
            model.addAttribute("eventDetails", newEvent);

        } catch (IOException e) {
            model.addAttribute("error", "Error uploading image: " + e.getMessage());
            return "create-event";
        }

        return "create-event";
    }

    @GetMapping("/events")
    @ResponseBody
    public List<Event> getAllEvents() {
        return createdEvents;
    }
}

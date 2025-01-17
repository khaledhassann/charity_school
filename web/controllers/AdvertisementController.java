package com.rungroup.web.controllers;

import com.rungroup.web.models.Advertisement;
import com.rungroup.web.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.rungroup.web.repositories.Implementations.AdvertisementRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdvertisementController {
    private static List<Advertisement> advertisements = new ArrayList<>();
    private AdvertisementRepository advertisementsRepository = new AdvertisementRepository();

    public AdvertisementController() {
        // Pull the list of the available courses from the database
        advertisements = advertisementsRepository.findAll();
        advertisements.forEach(advertisement -> System.out.println("Available advertisements: " + advertisement));
                
    }
    @GetMapping("/create-advertisement")
    public String showCreateAdvertisementForm(Model model) {
        Advertisement advertisement = new Advertisement();
        // Use the shared createdEvents list from EventController
        model.addAttribute("events", EventController.createdEvents);
        model.addAttribute("advertisement", advertisement);
        return "create-advertisement";
    }

    @PostMapping("/create-advertisement")
    public String processAdvertisementForm(
            @RequestParam("content") String content,
            @RequestParam("platform") String platform,
            @RequestParam("status") String status,
            @RequestParam("launchDate") LocalDateTime launch_date,
            @RequestParam("event") Long event_id,
            Model model) {

        Advertisement advertisement = new Advertisement();
        advertisement.setContent(content);
        advertisement.setPlatform(platform);
        advertisement.setStatus(status);
        advertisement.setLaunch_date(launch_date);
        advertisement.setEvent_id(event_id);  // Simply set the eventId instead of the whole Event object

        advertisements.add(advertisement);
        model.addAttribute("message", "Advertisement created successfully!");
        this.advertisementsRepository.insert(advertisement);
        model.addAttribute("message", "Advertisement Inserted into DB successfully!");

        // Add fresh list of events back to model
        model.addAttribute("events", EventController.createdEvents);
        return "create-advertisement";
    }
}
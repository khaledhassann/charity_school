package com.rungroup.web.controllers;

import com.rungroup.web.models.Advertisement;
import com.rungroup.web.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdvertisementController {
    private static List<Advertisement> advertisements = new ArrayList<>();

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
            @RequestParam("launchDate") LocalDateTime launchDate,
            @ModelAttribute Event event,
        
            Model model) {

        Advertisement advertisement = new Advertisement();
        advertisement.setContent(content);
        advertisement.setPlatform(platform);
        advertisement.setStatus(status);
        advertisement.setLaunchDate(launchDate);
        advertisement.setEventId(event.getId());  // Simply set the eventId instead of the whole Event object

        advertisements.add(advertisement);
        model.addAttribute("message", "Advertisement created successfully!");

        // Add fresh list of events back to model
        model.addAttribute("events", EventController.createdEvents);
        return "create-advertisement";
    }
}
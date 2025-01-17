package com.rungroup.web.controllers;

import com.rungroup.web.models.Advertisement;
import com.rungroup.web.models.Event;
import com.rungroup.web.models.Facebook;
import com.rungroup.web.models.Instagram;
import com.rungroup.web.models.Twitter;
import com.rungroup.web.repositories.Implementations.FacebookRepository;
import com.rungroup.web.repositories.Implementations.InstagramRepository;
import com.rungroup.web.repositories.Implementations.TwitterRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
// import com.rungroup.web.repositories.Implementations.AdvertisementRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdvertisementController {
    // private static List<Advertisement> advertisements = new ArrayList<>();
    private static List<Twitter> twitterAds = new ArrayList<>();
    private static List<Facebook> facebookAds = new ArrayList<>();
    private static List<Instagram> instagramAds = new ArrayList<>();
    private TwitterRepository twitterRepository = new TwitterRepository();
    private FacebookRepository facebookRepository = new FacebookRepository();
    private InstagramRepository instagramRepository = new InstagramRepository();
    // private AdvertisementRepository advertisementsRepository = new AdvertisementRepository();

    public AdvertisementController() {
        // Pull the list of the available courses from the database
        twitterAds = twitterRepository.findAll();
        facebookAds = facebookRepository.findAll();
        instagramAds = instagramRepository.findAll();
        twitterAds.forEach(advertisement -> System.out.println("Available advertisements: " + advertisement));
        facebookAds.forEach(advertisement -> System.out.println("Available advertisements: " + advertisement));
        instagramAds.forEach(advertisement -> System.out.println("Available advertisements: " + advertisement));
        // advertisements = advertisementsRepository.findAll();
        // advertisements.forEach(advertisement -> System.out.println("Available advertisements: " + advertisement));
                
    }
    @GetMapping("/create-advertisement")
    public String showCreateAdvertisementForm(Model model) {
        // Advertisement advertisement = new Advertisement();
        // Use the shared createdEvents list from EventController
        model.addAttribute("events", EventController.createdEvents);
        // model.addAttribute("advertisement", advertisement);
        model.addAttribute("advertisement", null);
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
        
        
        Advertisement advertisement = null;
        switch (platform.toLowerCase()) {
            case "facebook":
                advertisement = new Facebook(content, "Facebook Ad", status, launch_date, event_id);
                facebookAds.add((Facebook)advertisement);
                facebookRepository.insert((Facebook)advertisement);
                break;
            case "instagram":
                advertisement = new Instagram(content, "Instagram Ad", status, launch_date, event_id);
                instagramAds.add((Instagram)advertisement);
                instagramRepository.insert((Instagram)advertisement);
                break;
            case "twitter":
                advertisement = new Twitter(content, "Twitter Ad", status, launch_date, event_id);
                twitterAds.add((Twitter)advertisement);
                twitterRepository.insert((Twitter)advertisement);
                break;
            default:
                break;
        }
        // advertisement.setContent(content);
        // advertisement.setPlatform(platform);
        // advertisement.setStatus(status);
        // advertisement.setLaunch_date(launch_date);
        // advertisement.setEvent_id(event_id);  // Simply set the eventId instead of the whole Event object

        // advertisements.add(advertisement);
        model.addAttribute("message", "Advertisement created successfully!");
        // this.advertisementsRepository.insert(advertisement);

        model.addAttribute("message", "Advertisement Inserted into DB successfully!");

        // Add fresh list of events back to model
        model.addAttribute("events", EventController.createdEvents);
        return "create-advertisement";
    }
}
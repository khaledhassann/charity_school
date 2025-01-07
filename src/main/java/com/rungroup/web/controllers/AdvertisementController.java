package com.rungroup.web.controllers;

import com.rungroup.web.models.Advertisement;
import com.rungroup.web.models.SocialMediaPlatform;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdvertisementController {

    private List<Advertisement> ads = new ArrayList<>();

    // Sample data
    public AdvertisementController() {
        ads.add(new Advertisement() {
            {
                setId(1L);
                setContent("Back to School Sale");
                setPlatform(SocialMediaPlatform.INSTAGRAM);
                setStatus("Upcoming");
                setLaunchDate(LocalDateTime.of(2025, 1, 10, 0, 0));
                setEventId(101L);
            }

            @Override
            public String showAd() {
                return "Back to School Sale on Instagram";
            }
        });

        ads.add(new Advertisement() {
            {
                setId(2L);
                setContent("New Year Campaign");
                setPlatform(SocialMediaPlatform.FACEBOOK);
                setStatus("Running");
                setLaunchDate(LocalDateTime.of(2025, 1, 1, 0, 0));
                setEventId(102L);
            }

            @Override
            public String showAd() {
                return "New Year Campaign on Facebook";
            }
        });

        ads.add(new Advertisement() {
            {
                setId(3L);
                setContent("Winter Sale");
                setPlatform(SocialMediaPlatform.TWITTER);
                setStatus("Paused");
                setLaunchDate(LocalDateTime.of(2025, 1, 5, 0, 0));
                setEventId(103L);
            }

            @Override
            public String showAd() {
                return "Winter Sale on Twitter";
            }
        });
    }

    @GetMapping("/ads")
    public String getAdvertisements(Model model) {
        model.addAttribute("ads", ads);
        return "ads-management";
    }

    @PostMapping("/ads/create")
    public String createAdvertisement(Model model) {
        // Add logic for creating a new advertisement
        return "redirect:/ads";
    }
}

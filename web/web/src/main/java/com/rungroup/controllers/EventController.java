package com.rungroup.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.rungroup.models.Event;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EventController {

    private List<Event> events = new ArrayList<>();

    public EventController() {
        // Static list of events (mock data)
        events.add(new Event(1L, "Science Fair", "Exciting experiments await!", 
            "/images/science-fair.jpg", LocalDateTime.of(2025, 2, 10, 10, 0), "Room 101"));
        events.add(new Event(2L, "History Exhibition", "Interactive history event.", 
            "/images/history-exhibition.jpg", LocalDateTime.of(2025, 3, 5, 14, 30), "Hall A"));
        events.add(new Event(3L, "Math Competition", "Challenge your math skills.", 
            "/images/math-competition.jpg", LocalDateTime.of(2025, 4, 20, 9, 0), "Room 202"));
    }

    @GetMapping("/events")
    public String getEventsPage(Model model) {
        model.addAttribute("events", events);
        return "events"; 
    }
}


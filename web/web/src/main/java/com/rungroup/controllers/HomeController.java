package com.rungroup.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.rungroup.models.*;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String homePage(Model model) {
        // Dummy courses
        List<Course> courses = new ArrayList<>();
        courses.add(new Course(1L, "History", "Discover ancient civilizations.", "/images/A1VqnK8cuLL._AC_UF1000,1000_QL80_.jpg", 3, 1, 75.0));
        courses.add(new Course(2L, "Science", "Explore the natural world.", "/images/science.jpg", 4, 2, 60.0));
        courses.add(new Course(3L, "Maths", "Master mathematical concepts.", "/images/maths.jpg", 5, 3, 80.0));

        // Dummy teachers
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher(1L, "Laila Ihab", "Science", "/images/laila.jpeg"));
        teachers.add(new Teacher(2L, "Mariam Sameh", "History", "/images/habiba.jpeg"));
        teachers.add(new Teacher(3L, "Habiba Yasser", "Maths", "/images/mariam.jpeg"));

        // Dummy events
        List<Event> events = new ArrayList<>();
events.add(new Event(
    1L,
    "Science Fair",
    "Exciting experiments await!",
    "/images/science fair.jpg",
    LocalDateTime.of(2025, 2, 10, 10, 0), // Event date: 10th February 2025 at 10:00 AM
    "Lab 101, Hope Haven School" // Event location
));
events.add(new Event(
    2L,
    "History Exhibition",
    "Interactive history event.",
    "/images/National_Museum5.jpg",
    LocalDateTime.of(2025, 3, 15, 12, 0), // Event date: 15th March 2025 at 12:00 PM
    "History Hall, Hope Haven School" // Event location
));
events.add(new Event(
    3L,
    "Math Competition",
    "Challenge your math skills.",
    "/images/free-educational-vector-collection.jpg",
    LocalDateTime.of(2025, 4, 5, 9, 30), // Event date: 5th April 2025 at 9:30 AM
    "Math Wing, Hope Haven School" // Event location
));

        model.addAttribute("courses", courses);
        model.addAttribute("teachers", teachers);
        model.addAttribute("events", events);

        return "home";
    }
}

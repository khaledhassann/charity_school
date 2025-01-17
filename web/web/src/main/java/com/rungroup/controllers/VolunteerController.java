package com.rungroup.controllers;

import com.rungroup.models.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class VolunteerController {

    private List<Course> availableCourses = new ArrayList<>();
    private List<Course> teachedCourses = new ArrayList<>();
    private Volunteer currentVolunteer;

    public VolunteerController() {
        // Initialize the current volunteer
        currentVolunteer = new Volunteer(1L, "John Doe", "john.doe@example.com", "password123", new ArrayList<>(), "Weekends");

        // Static list of available courses
        availableCourses.add(new Course(1L, "History", "Explore ancient civilizations and key historical events.",
                "/images/A1VqnK8cuLL._AC_UF1000,1000_QL80_.jpg", 3, 1, 0.0));
        availableCourses.add(new Course(2L, "Science", "Delve into the wonders of the natural world with engaging experiments.",
                "/images/science.jpg", 4, 2, 0.0));
        availableCourses.add(new Course(3L, "Maths", "Master mathematical concepts and improve your problem-solving skills.",
                "/images/maths.jpg", 3, 3, 0.0));
        availableCourses.add(new Course(4L, "English", "Master the language of global communication.",
                "/images/learning-english-doodle-set-language-school-in-sketch-style-online-language-education-course-hand-drawn-illustration-isolated-on-white-background-vector.jpg",
                2, 4, 0.0));
        availableCourses.add(new Course(5L, "French", "Learn the beautiful language of French culture and diplomacy.",
                "/images/french-language-hand-drawn-doodles-lettering-french-language-hand-drawn-doodles-lettering-language-education-vector-137829160.webp",
                2, 5, 0.0));
        availableCourses.add(new Course(6L, "Arabic", "Dive into the rich and ancient language of Arabic.",
                "/images/1634038961-arabic.jpg", 3, 6, 0.0));
    }

    @GetMapping("/teach-courses")
    public String getTeachCoursesPage(Model model) {
        // Filter courses to exclude already taught ones
        List<Course> coursesToTeach = new ArrayList<>(availableCourses);
        coursesToTeach.removeAll(teachedCourses);

        model.addAttribute("courses", coursesToTeach);
        return "teach-courses";
    }

    @PostMapping("/teach-course")
    public String teachCourse(@RequestParam Long courseId, Model model) {
        // Find the course by ID and add it to the taught courses list
        availableCourses.stream()
                .filter(course -> course.getId().equals(courseId))
                .findFirst()
                .ifPresent(course -> {
                    Verb verb = new Verb(2L, "Teach");

                    // Use the factory to create TeachDetails
                    List<Object> additionalData = new ArrayList<>();
                    additionalData.add(10.0); // Example: hours taught
                    

                    TeachDetails details = (TeachDetails) VerbDetailsFactory.createVerbDetails(
                            verb,
                            currentVolunteer,
                            course,
                            additionalData // Pass additional data
                    );

                    // Add the course to the teachedCourses list
                    teachedCourses.add(course);

                    // Log the details (for debugging)
                    System.out.println("Teach VerbDetails: " + details);
                });

        // Redirect to the teached courses page to reflect changes
        return "redirect:/teached-courses";
    }

    @GetMapping("/teached-courses")
    public String getTeachedCoursesPage(Model model) {
        // Pass the taught courses to the model
        model.addAttribute("teachedCourses", teachedCourses);
        return "teached-courses";
    }
    
}
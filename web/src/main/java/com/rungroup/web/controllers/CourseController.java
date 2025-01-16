package com.rungroup.web.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import com.rungroup.web.models.*;
import com.rungroup.web.models.Course;
import com.rungroup.web.repositories.Implementations.CourseRepository;


@Controller
public class CourseController {

    private CourseRepository courseRepository = new CourseRepository();
    private List<Course> availableCourses = new ArrayList<>();
    private List<Course> registeredCourses = new ArrayList<>();

    public CourseController() {
        // Pull the list of the available courses from the database
        availableCourses = courseRepository.findAll();
        availableCourses.forEach(course -> System.out.println("Available course: " + course));
        
    }

    @GetMapping("/register-courses")
    public String getRegisterCoursesPage(Model model) {
        model.addAttribute("courses", availableCourses);
        return "register-courses";
    }

    @PostMapping("/register-course") /////////////////////////////////////////////////////// Revise
    public String registerCourse(@RequestParam Long courseId, Model model) {
        // Find the course by ID and register it
        availableCourses.stream()
            .filter(course -> course.getId().equals(courseId))
            .findFirst()
            .ifPresent(course -> {
                // registeredCourses.add(new Course(
                //     course.getId(),
                //     course.getName(),
                //     course.getDescription(),
                //     course.getimage_url(),
                //     course.getCredits(),
                //     course.getTimeSlot(),
                //     course.getProgress() // Default progress remains 0.0
                // ));
                System.out.println("Couse found and user can register it: "+ course);
            });

        // Redirect back to the register courses page
        model.addAttribute("courses", availableCourses);
        return "redirect:/register-courses";
    }

    @GetMapping("/registered-courses") /////////////////////////////////////////////////////// Revise
    public String getRegisteredCoursesPage(Model model) {
        model.addAttribute("registeredCourses", registeredCourses);
        return "registered-courses";
    }
}
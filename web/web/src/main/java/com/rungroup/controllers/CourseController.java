package com.rungroup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

import com.rungroup.models.*;

@Controller
public class CourseController {

    private List<Course> availableCourses = new ArrayList<>();
    private List<Course> registeredCourses = new ArrayList<>();
    private User currentUser;

    public CourseController() {
        // Static list of available courses with updated attributes
        currentUser = new Beneficiary(1L, "mariam", "mariam@sameh", "123", "90");
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

    @GetMapping("/register-courses")
    public String getRegisterCoursesPage(Model model) {
        // Filter courses to exclude already registered ones
        List<Course> coursesToRegister = new ArrayList<>(availableCourses);
        coursesToRegister.removeAll(registeredCourses);

        model.addAttribute("courses", coursesToRegister);
        return "register-courses";
    }

    @PostMapping("/register-course")
    public String registerCourse(@RequestParam Long courseId, Model model) {
        // Find the course by ID and register it
        availableCourses.stream()
                .filter(course -> course.getId().equals(courseId))
                .findFirst()
                .ifPresent(course -> {
                    // Define the verb as "Register"
                    Verb verb = new Verb(1L, "Register");

                    // Use the factory to create RegisterDetails
                    List<Object> additionalData = new ArrayList<>();
                    additionalData.add("Pending"); // Example: status for "register"

                    RegisterDetails details = (RegisterDetails) VerbDetailsFactory.createVerbDetails(
                            verb,
                            currentUser,
                            course,
                            additionalData // Pass the non-null list
                    );

                    // Add the course to the registeredCourses list
                    registeredCourses.add(course);

                    // Log the details (for debugging)
                    System.out.println("Registered VerbDetails: " + details);
                });

        // Redirect to the registered courses page to reflect changes
        return "redirect:/registered-courses";
    }

    @GetMapping("/registered-courses")
    public String getRegisteredCoursesPage(Model model) {
        // Pass the registered courses to the model
        model.addAttribute("registeredCourses", registeredCourses);
        return "registered-courses";
    }
}

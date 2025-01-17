package com.rungroup.web.controllers;

// import com.rungroup.models.*;
import com.rungroup.web.models.Assessment;
import com.rungroup.web.models.Course;
import com.rungroup.web.models.CurrentUser;
import com.rungroup.web.models.RegisterDetails;
import com.rungroup.web.models.User;
import com.rungroup.web.models.Verb;
import com.rungroup.web.models.VerbDetails;
import com.rungroup.web.repositories.Implementations.CourseRepository;
import com.rungroup.web.repositories.Implementations.RegisterDetailsRepository;
import com.rungroup.web.utils.VerbDetailsFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class CourseController {

    
    private static List<Course> availableCourses = new ArrayList<>();
    private List<Course> registeredCourses = new ArrayList<>();
    CourseRepository courseRepository = new CourseRepository();
    RegisterDetailsRepository registerDetailsRepository = new RegisterDetailsRepository();
    Long id;

    private User currentUser;

    // Constructor with dependency injection for AssessmentController
    public CourseController(AssessmentController assessmentController) {
        //this.assessmentController = assessmentController;

        // Static list of available courses with updated attributes
        currentUser = CurrentUser.getUser();
        availableCourses = courseRepository.findAll();
        // availableCourses.add(new Course(1L, "History", "Explore ancient civilizations and key historical events.",
        //         "/images/A1VqnK8cuLL._AC_UF1000,1000_QL80_.jpg", 3, 1, 0.0));
        // availableCourses.add(new Course(2L, "Science", "Delve into the wonders of the natural world with engaging experiments.",
        //         "/images/science.jpg", 4, 2, 0.0));
        // availableCourses.add(new Course(3L, "Maths", "Master mathematical concepts and improve your problem-solving skills.",
        //         "/images/maths.jpg", 3, 3, 0.0));
        // availableCourses.add(new Course(4L, "English", "Master the language of global communication.",
        //         "/images/learning-english-doodle-set-language-school-in-sketch-style-online-language-education-course-hand-drawn-illustration-isolated-on-white-background-vector.jpg",
        //         2, 4, 0.0));
        // availableCourses.add(new Course(5L, "French", "Learn the beautiful language of French culture and diplomacy.",
        //         "/images/french-language-hand-drawn-doodles-lettering-french-language-hand-drawn-doodles-lettering-language-education-vector-137829160.webp",
        //         2, 5, 0.0));
        // availableCourses.add(new Course(6L, "Arabic", "Dive into the rich and ancient language of Arabic.",
        //         "/images/1634038961-arabic.jpg", 3, 6, 0.0));
    }
    public static List<Course> getAvailableCourses() {
        return availableCourses;
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
        Verb verb = new Verb("Register");
        Course registeredCourse = courseRepository.findById(courseId);
        registeredCourses.add(registeredCourse);
        HashMap <String, Object> additionalData = new HashMap<String, Object>();
        additionalData.put("status", "pending");
        id = VerbDetailsFactory.createVerbDetails(verb.getId(), currentUser.getId(), "beneficiary", courseId, "course", additionalData).getId();
        // // Find the course by ID and register it
        // availableCourses.stream()
        //         .filter(course -> course.getId().equals(courseId))
        //         .findFirst()
        //         .ifPresent(course -> {
        //             // Define the verb as "Register"
        //             Verb verb = new Verb(1L, "Register");

        //             // Use the factory to create RegisterDetails
        //             HashMap additionalData = new HashMap<>();
        //             // additionalData.add("Pending"); // Example: status for "register"

        //             RegisterDetails details = (RegisterDetails) VerbDetailsFactory.createVerbDetails(
        //                     verb.getId(),
        //                     currentUser.getId(),
        //                     "beneficiary",
        //                     course.getId(),
        //                     "course",
        //                     additionalData // Pass the non-null list
        //             );

        //             // Add the course to the registeredCourses list
        //             registeredCourses.add(course);

        //             // Log the details (for debugging)
        //             System.out.println("Registered VerbDetails: " + details);
        //         });

        // Redirect to the registered courses page to reflect changes
        return "redirect:/registered-courses";
    }

    @GetMapping("/registered-courses")
    public String getRegisteredCoursesPage(Model model) {
        List<RegisterDetails> all_registered_courses = registerDetailsRepository.findAll();
        for(RegisterDetails x: all_registered_courses){
            if(x.getUser().getId() == currentUser.getId()){
                Long course_id = x.getTargetAdapter().gettarget_id();
                Course regCourse = courseRepository.findById(course_id);
                registeredCourses.add(regCourse);
            }
        }

        // registerDetailsRepository.findById(id);
        // Pass the registered courses to the model
        model.addAttribute("registeredCourses", registeredCourses);

        return "registered-courses";
    }

    @GetMapping("/course-details")
    public String getCourseDetails(@RequestParam Long courseId, Model model) {
        // Find the course by ID
        Course course = availableCourses.stream()
                .filter(c -> c.getId().equals(courseId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Course not found"));

        // Add the course to the model
        model.addAttribute("course", course);

        // Return the course details page
        return "course-details"; // This corresponds to the name of the HTML file
    }

    @GetMapping("/course-assessments")
    public String getCourseAssessments(@RequestParam Long courseId, Model model) {
        Course course = availableCourses.stream()
                .filter(c -> c.getId().equals(courseId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Course not found"));
    
        // Fetch only active assessments for the course
        List<Assessment> activeAssessments = AssessmentController.getActiveAssessmentsForCourse(course);
    
        model.addAttribute("course", course);
        model.addAttribute("assessments", activeAssessments);
    
        return "course-assessments";
    }
    
}